package kr.ac.computereng.labmanager.user.repo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import kr.ac.computereng.labmanager.common.datatype.UserDatatype;
import kr.ac.computereng.labmanager.common.datatype.UserRole;
import kr.ac.computereng.labmanager.common.datatype.Role;
import kr.ac.computereng.labmanager.common.user.repo.IUserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:C:/Users/user/eclipse-workspace/labmanager/labmanager/src/main/resources/spring/context-*.xml")
@TransactionConfiguration(transactionManager="txManager")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	//테스트순서 오름차순으로
public class UserRepositoryTest {

	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String protocol = "jdbc:mysql://127.0.0.1:3306/sql?characterEncoding=utf8&verifyServerCertificate=false&useSSL=true";
	private final static String id = "scott";
	private final static String pw = "tiger";
	
	private static IDatabaseTester databaseTester;
	@Autowired
	private IUserRepository userRepository;
	
	@Test
	public void _0디비연결테스트() throws Exception{
		Class.forName(driver);
		
		try(Connection con = DriverManager.getConnection(protocol,id,pw)){
			assertNotNull(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public static void setUp() throws Exception{
		databaseTester = new JdbcDatabaseTester(driver, protocol,id,pw);
		
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/kr/co/computereng/user/repo/dataset/User.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);
		
		dataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/kr/co/computereng/user/repo/dataset/UserRole.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);
	
	}
	@Test
	public void _9회원가입테스트() throws SQLException, Exception{	//회원탈퇴보다 뒤에해야함
		UserDatatype testuser = new UserDatatype("test3","test","test3","email1","email2","study","hope");
		UserDatatype testuser2 = new UserDatatype("test4","test","test4","email1","email2","study","hope");
		boolean result = userRepository.addUser(testuser);
		assertTrue(result);
		result = userRepository.addUser(testuser2);
		assertTrue(result);
		compareTableContents("test_user", "src/test/resources/kr/co/computereng/user/repo/dataset/expected_user_insert.xml");
	}
	
	@Test
	public void _7회원정보가져오기테스트() throws Exception {
		UserDatatype user = this.userRepository.selectOne("test1");
		assertNotNull(user);
		assertEquals("test1", user.getId());
		assertEquals("test", user.getPassword());
		assertEquals("test1", user.getName());
	}

	@Test
	public void _4회원가입실패테스트_아이디중복() throws SQLException, Exception{
		UserDatatype user = new UserDatatype("test1","123","qwe","email1","email2","study","hope");
		boolean condition = this.userRepository.addUser(user);
		assertFalse(condition);
	}
	
	@Test
	public void _2회원탈퇴테스트_사용자() throws SQLException, Exception{ //회원가입테스트보다 먼저해야함
		boolean condition = userRepository.delete("test3");
		assertTrue(condition);
		compareTableContents("test_user", "src/test/resources/kr/co/computereng/user/repo/dataset/expected_user_delete.xml");
	}
	
	@Test
	public void _1회원정보수정테스트() throws SQLException, Exception{
		UserDatatype user = new UserDatatype("test2","update","update","email1","email2","study","hope");
		boolean condition = userRepository.update(user);
		assertTrue(condition);
		compareTableContents("test_user", "src/test/resources/kr/co/computereng/user/repo/dataset/expected_user_update.xml");
	}
	
	@Test
	public void _3회원전체가져오기테스트() throws SQLException, Exception{
		List<UserDatatype> user = this.userRepository.selectAll();
		assertNotNull(user);
		assertEquals(user.get(0).getId(),"test2");
		assertEquals(user.get(1).getId(),"test1");
	}	
	
	@Test
	public void _5회원권환바꾸기테스트() throws SQLException, Exception{ //회원권한추가하기보다 뒤에
		boolean condition = this.userRepository.authorize("test1",Role.RESEARCHER);
		assertTrue(condition);
		compareTableContents("test_role", "src/test/resources/kr/co/computereng/user/repo/dataset/expected_role_authorize.xml");
		
	}
	
	@Test
	public void _8회원권한추가하기() throws SQLException, Exception{ //회원권환바꾸기테스트 보다 먼저
		UserRole user = new UserRole("test4");
		boolean result = userRepository.addRole(user);
		assertTrue(result);
		compareTableContents("test_role", "src/test/resources/kr/co/computereng/user/repo/dataset/expected_role_insert.xml");
	}
	
	@Test
	public void _90회원권한삭제하기() throws SQLException, Exception{ //회원권환바꾸기테스트 보다 먼저
		boolean condition = userRepository.deleteRole("test4");
		assertTrue(condition);
		compareTableContents("test_role", "src/test/resources/kr/co/computereng/user/repo/dataset/expected_role_delete.xml");
		condition = userRepository.addRole(new UserRole("test4"));
		assertTrue(condition);
	}
	
	@Test
	public void _6회원한명권한가져오기() throws SQLException, Exception{
		UserRole userrole = new UserRole("test3");
		UserRole data = this.userRepository.selectOneRole(userrole.getId());
		assertEquals(Role.YET, data.getRole());
	}
	
	private void compareTableContents(String tableName, String expectedPath) throws DataSetException, SQLException, Exception {
		IDataSet currentData = databaseTester.getConnection().createDataSet(new String[] {tableName});
		IDataSet expectedData = new FlatXmlDataSetBuilder().build(new FileInputStream(new File(expectedPath)));
		Assertion.assertEquals(expectedData, currentData);
	}

	@AfterClass
	public static void endTest() throws SQLException, Exception {
		databaseTester.getConnection().close();
	}
}

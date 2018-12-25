package kr.ac.computereng.labmanager.user;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import kr.ac.computereng.labmanager.common.datatype.Role;
import kr.ac.computereng.labmanager.common.datatype.UserDatatype;
import kr.ac.computereng.labmanager.common.user.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:C:/Users/user/eclipse-workspace/labmanager/labmanager/src/main/resources/spring/context-*.xml")
@TransactionConfiguration(transactionManager="txManager")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	//테스트순서 오름차순으로
public class UserServiceTest {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void _0주입테스트() throws Exception {
		assertNotNull(this.userService);
	}
	
	@Test
	public void _1회원가입테스트() throws Exception {
		UserDatatype user = new UserDatatype("idid","test","test1","email1","email2","study","hope");
		boolean condition = this.userService.joinUser(user);
		assertTrue(condition);
	}
	
	@Test
	public void _2회원탈퇴테스트() throws Exception{		//가입보다 뒤에 있어야함
		boolean condition = this.userService.withdraw("idid");
		assertTrue(condition);
	}
	
	@Test
	public void _3회원업데이트테스트() throws Exception{		//가입보다 뒤에 있어야함
		UserDatatype user = new UserDatatype("test3","update","test1","email1","email2","study","hope");
		boolean condition = this.userService.updateUser(user);
		assertTrue(condition);
	}

	@Test
	public void _4회원한명검색테스트() throws Exception{		//가입보다 뒤에 있어야함
		UserDatatype testuser = this.userService.searchOne("test1");
		assertEquals("test1", testuser.getId());
		assertEquals("test", testuser.getPassword());
		assertEquals("test1", testuser.getName());
		assertEquals("email1", testuser.getEmail1());
		assertEquals("email2", testuser.getEmail2());
		assertEquals("hope", testuser.getHope());
		assertEquals("study", testuser.getStudy());
	}
	
	@Test
	public void _5회원권한부여테스트() throws Exception{
		boolean condition = this.userService.authorize("test2", Role.STUDENT);
		assertTrue(condition);
	}
	
	@Test
	public void _6회원전체가져오기테스트() throws Exception{
		List<UserDatatype> userAll = this.userService.search();
		for(int i=0;i<userAll.size();i++) {
			UserDatatype temp = userAll.get(i);
			System.out.println("----------1----------");
			System.out.println("id = " + temp.getId());
			System.out.println("pass = " + temp.getPassword());
			System.out.println("name = " + temp.getName());
			System.out.println("email = " + temp.getEmail1() + "@" + temp.getEmail2());
			System.out.println("hope = " + temp.getHope());
			System.out.println("study = " + temp.getStudy());
			System.out.println("role = " + temp.getRole().getRole());
		}
	}
}

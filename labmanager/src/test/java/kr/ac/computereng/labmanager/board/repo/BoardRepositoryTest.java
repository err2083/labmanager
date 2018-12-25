package kr.ac.computereng.labmanager.board.repo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
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

import kr.ac.computereng.labmanager.common.board.repo.IBoardRepository;
import kr.ac.computereng.labmanager.common.datatype.BoardDatatype;
import kr.ac.computereng.labmanager.common.datatype.Criteria;
import kr.ac.computereng.labmanager.common.datatype.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:C:/Users/user/eclipse-workspace/labmanager/labmanager/src/main/resources/spring/context-*.xml")
@TransactionConfiguration(transactionManager="txManager")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	//테스트순서 오름차순으로
public class BoardRepositoryTest {

	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String protocol = "jdbc:mysql://127.0.0.1:3306/board_ex?characterEncoding=utf8&verifyServerCertificate=false&useSSL=true";
	private final static String id = "scott";
	private final static String pw = "tiger";
	
	private static IDatabaseTester databaseTester;
	
	@Autowired
	private IBoardRepository boardRepository;

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
				new File("src/test/resources/kr/co/computereng/board/repo/dataset/Board.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);
	}
	
	@Test
	public void _1게시글전체가져오기() throws SQLException, Exception{
		List<BoardDatatype> board = this.boardRepository.listAll();
		assertNotNull(board);
		compareTableContents("tbl_board", "src/test/resources/kr/co/computereng/board/repo/dataset/Board.xml");
	}
	
	
	@Test
	public void _2게시글읽기() throws SQLException,Exception {
		BoardDatatype board = this.boardRepository.read(1);//1번 게시물 읽기
		assertEquals("test1", board.getTitle());
		assertEquals("test1cc", board.getContent());
		assertEquals("aa", board.getWriter());
		assertEquals(12, board.getViewcnt());
	}
	
	@Test
	public void _3게시글추가하기() throws SQLException,Exception {
		BoardDatatype board = new BoardDatatype();
		board.setTitle("test6");
		board.setContent("test6cc");
		board.setWriter("ff");
		//조회수는 생성될때 0이므로 따로 set 하지않음
		String[] ignore = new String[2];
		ignore[1] = "bno";
		ignore[0] = "regdate";
		this.boardRepository.create(board);
		compareTableContentsIgnoreCols("tbl_board", "src/test/resources/kr/co/computereng/board/repo/dataset/expected_board_insert.xml",ignore);
	}
	
	@Test
	public void _4게시글삭제하기() throws SQLException,Exception {
		String[] ignore = new String[2];
		ignore[0] = "regdate";
		ignore[1] = "bno";
		this.boardRepository.delete(3);
		compareTableContentsIgnoreCols("tbl_board", "src/test/resources/kr/co/computereng/board/repo/dataset/expected_board_delete.xml",ignore);
	}
	
	@Test
	public void _5게시글수정하기() throws SQLException,Exception {
		BoardDatatype board = new BoardDatatype();
		board.setBno(2);
		board.setTitle("update_title");
		board.setContent("update_content");
		//작성자는 수정 불가능
		board.setViewcnt(34);
		String[] ignore = new String[2];
		ignore[0] = "regdate";
		ignore[1] = "bno";
		this.boardRepository.update(board);
		compareTableContentsIgnoreCols("tbl_board", "src/test/resources/kr/co/computereng/board/repo/dataset/expected_board_update.xml",ignore);
	}
	
	@Test
	public void _6페이징() throws SQLException,Exception {
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(2);
		
		List<BoardDatatype> list = boardRepository.listCriteria(cri);
		
		assertNotNull(list);
		
		for(BoardDatatype board : list) {
			System.out.println(board.getBno() + ":" + board.getTitle());
		}
	}
	
	@Test
	public void _7검색된페이징() throws SQLException,Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("test");
		cri.setSearchType("t");
		
		List<BoardDatatype> list = boardRepository.search(cri);
		
		assertNotNull(list);
		
		for(BoardDatatype board : list) {
			System.out.println(board.getBno() + ":" + board.getTitle());
		}
	}
	
	private void compareTableContents(String tableName, String expectedPath) throws DataSetException, SQLException, Exception {
		IDataSet currentData = databaseTester.getConnection().createDataSet(new String[] {tableName});
		IDataSet expectedData = new FlatXmlDataSetBuilder().build(new FileInputStream(new File(expectedPath)));
		Assertion.assertEquals(expectedData, currentData);
	}
	
	private void compareTableContentsIgnoreCols(String tableName, String expectedPath,String[] ignore) throws DataSetException, SQLException, Exception {
		ITable currentData = databaseTester.getConnection().createTable(tableName);
		IDataSet expectedData = new FlatXmlDataSetBuilder().build(new FileInputStream(new File(expectedPath)));
		Assertion.assertEqualsIgnoreCols(expectedData.getTable("tbl_board"),currentData,ignore);
	}
	
	@AfterClass
	public static void endTest() throws SQLException, Exception {
		databaseTester.getConnection().close();
	}
}

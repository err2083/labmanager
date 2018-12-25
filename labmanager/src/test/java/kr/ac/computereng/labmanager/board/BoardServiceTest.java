package kr.ac.computereng.labmanager.board;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import kr.ac.computereng.labmanager.common.board.IBoardService;
import kr.ac.computereng.labmanager.common.datatype.BoardDatatype;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:C:/Users/user/eclipse-workspace/labmanager/labmanager/src/main/resources/spring/context-*.xml")
@TransactionConfiguration(transactionManager="txManager")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	//테스트순서 오름차순으로
public class BoardServiceTest {
	@Autowired
	private IBoardService boardService; 
	
	@Test
	public void _0주입테스트() {
		assertNotNull(boardService);
	}
	
	@Test
	public void _1전체글가져오기() throws Exception {
	}
	
	@Test
	public void _2글등록하기() throws Exception {
	}
	
	@Test
	public void _3글읽기() {
	}

	@Test
	public void _4글삭제하기() throws Exception {
	}
	
	@Test
	public void _5글수정하기() throws Exception {
	}
}

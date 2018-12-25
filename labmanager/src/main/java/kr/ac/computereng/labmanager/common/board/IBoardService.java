package kr.ac.computereng.labmanager.common.board;

import java.util.List;

import kr.ac.computereng.labmanager.common.datatype.BoardDatatype;
import kr.ac.computereng.labmanager.common.datatype.Criteria;
import kr.ac.computereng.labmanager.common.datatype.SearchCriteria;

public interface IBoardService {

	public void regist(BoardDatatype Board) throws Exception;
	
	public BoardDatatype read(Integer bno) throws Exception;
	
	public void modify(BoardDatatype board) throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardDatatype> listAll() throws Exception;
	
	public List<BoardDatatype> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<BoardDatatype> search(SearchCriteria cri) throws Exception;
	
	public int searchCount(SearchCriteria cri) throws Exception;
}

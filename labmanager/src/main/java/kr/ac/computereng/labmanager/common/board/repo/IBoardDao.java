package kr.ac.computereng.labmanager.common.board.repo;

import java.util.List;
import kr.ac.computereng.labmanager.common.datatype.BoardDatatype;
import kr.ac.computereng.labmanager.common.datatype.Criteria;
import kr.ac.computereng.labmanager.common.datatype.SearchCriteria;

public interface IBoardDao {
	public void create(BoardDatatype vo) throws Exception;
	public BoardDatatype read(Integer bno) throws Exception;
	public void update(BoardDatatype vo) throws Exception;
	public void delete(Integer bno) throws Exception;
	public List<BoardDatatype> listAll() throws Exception;
	public List<BoardDatatype> listPage(int page) throws Exception;
	public List<BoardDatatype> listCriteria(Criteria cri) throws Exception;
	public int countPaging(Criteria cri) throws Exception;
	public List<BoardDatatype> search(SearchCriteria cri) throws Exception;
	public int searchCount(SearchCriteria cri) throws Exception;
}

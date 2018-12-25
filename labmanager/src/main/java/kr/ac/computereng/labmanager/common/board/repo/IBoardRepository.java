package kr.ac.computereng.labmanager.common.board.repo;

import java.util.List;
import kr.ac.computereng.labmanager.common.datatype.BoardDatatype;
import kr.ac.computereng.labmanager.common.datatype.Criteria;
import kr.ac.computereng.labmanager.common.datatype.SearchCriteria;

public interface IBoardRepository {
	/**
	 * 게시글 생성
	 * @param vo
	 * @throws Exception
	 */
	public void create(BoardDatatype vo) throws Exception;
	/**
	 * 게시글 읽기
	 * @param bno
	 * @return
	 * @throws Exception
	 */
	public BoardDatatype read(Integer bno) throws Exception;
	/**
	 * 게시글 수정
	 * @param vo
	 * @throws Exception
	 */
	public void update(BoardDatatype vo) throws Exception;
	/**
	 * 게시글 삭제
	 * @param bno
	 * @throws Exception
	 */
	public void delete(Integer bno) throws Exception;
	/**
	 * 게시글 로드
	 * @return
	 * @throws Exception
	 */
	public List<BoardDatatype> listAll() throws Exception;
	
	/**
	 * 페이징
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<BoardDatatype> listPage(int page) throws Exception;
	
	/**
	 * 페이징
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<BoardDatatype> listCriteria(Criteria cri) throws Exception;
	
	/**
	 * 전체 게시글
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int countPaging(Criteria cri) throws Exception;
	
	/**
	 * 검색된 게시글
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<BoardDatatype> search(SearchCriteria cri) throws Exception;
	
	/**
	 * 검색된 게시글 페이징
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int searchCount(SearchCriteria cri) throws Exception;
}

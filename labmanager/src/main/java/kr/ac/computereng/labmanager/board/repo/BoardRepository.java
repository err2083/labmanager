package kr.ac.computereng.labmanager.board.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.computereng.labmanager.common.board.repo.IBoardDao;
import kr.ac.computereng.labmanager.common.board.repo.IBoardRepository;
import kr.ac.computereng.labmanager.common.datatype.BoardDatatype;
import kr.ac.computereng.labmanager.common.datatype.Criteria;
import kr.ac.computereng.labmanager.common.datatype.SearchCriteria;

@Repository
public class BoardRepository implements IBoardRepository {
	@Autowired //의존성 주입
	private IBoardDao boardDao;
	@Override
	public void create(BoardDatatype vo) throws Exception {
		boardDao.create(vo);
	}
	@Override
	public BoardDatatype read(Integer bno) throws Exception {
		return boardDao.read(bno);
	}
	@Override
	public void update(BoardDatatype vo) throws Exception {
		boardDao.update(vo);
	}
	@Override
	public void delete(Integer bno) throws Exception {
		boardDao.delete(bno);
	}
	@Override
	public List<BoardDatatype> listAll() throws Exception {
		return boardDao.listAll();
	}
	@Override
	public List<BoardDatatype> listPage(int page) throws Exception {
		return boardDao.listPage(page);
	}
	@Override
	public List<BoardDatatype> listCriteria(Criteria cri) throws Exception {
		return boardDao.listCriteria(cri);
	}
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return boardDao.countPaging(cri);
	}
	@Override
	public List<BoardDatatype> search(SearchCriteria cri) throws Exception {
		return boardDao.search(cri);
	}
	@Override
	public int searchCount(SearchCriteria cri) throws Exception {
		return boardDao.searchCount(cri);
	}
}

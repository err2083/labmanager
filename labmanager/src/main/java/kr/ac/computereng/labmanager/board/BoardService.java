package kr.ac.computereng.labmanager.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//@Transactional(rollbackFor=Exception.class)
import kr.ac.computereng.labmanager.common.board.IBoardService;
import kr.ac.computereng.labmanager.common.board.repo.IBoardRepository;
import kr.ac.computereng.labmanager.common.datatype.BoardDatatype;
import kr.ac.computereng.labmanager.common.datatype.Criteria;
import kr.ac.computereng.labmanager.common.datatype.SearchCriteria;

@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardRepository boardRepository;

	@Override
	public void regist(BoardDatatype Board) throws Exception {
		boardRepository.create(Board);
	}

	@Override
	public BoardDatatype read(Integer bno) throws Exception {
		return boardRepository.read(bno);
	}

	@Override
	public void modify(BoardDatatype board) throws Exception {
		boardRepository.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		boardRepository.delete(bno);
	}

	@Override
	public List<BoardDatatype> listAll() throws Exception {
		return boardRepository.listAll();
	}

	@Override
	public List<BoardDatatype> listCriteria(Criteria cri) throws Exception {
		return boardRepository.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return boardRepository.countPaging(cri);
	}

	@Override
	public List<BoardDatatype> search(SearchCriteria cri) throws Exception {
		return boardRepository.search(cri);
	}

	@Override
	public int searchCount(SearchCriteria cri) throws Exception {
		return boardRepository.searchCount(cri);
	} 

}

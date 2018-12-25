package kr.ac.computereng.labmanager.board.reply.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.computereng.labmanager.common.datatype.ReplyDatatype;
import kr.ac.computereng.labmanager.common.board.reply.repo.IReplyDao;
import kr.ac.computereng.labmanager.common.board.reply.repo.IReplyRepository;

public class ReplyRepository implements IReplyRepository {

	@Autowired
	private IReplyDao replyDao;

	
	@Override
	public List<ReplyDatatype> list(Integer bno) throws Exception {
		return replyDao.list(bno);
	}

	@Override
	public void create(ReplyDatatype vo) throws Exception {
		replyDao.create(vo);
	}

	@Override
	public void update(ReplyDatatype vo) throws Exception {
		replyDao.update(vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		replyDao.delete(rno);
	}
}

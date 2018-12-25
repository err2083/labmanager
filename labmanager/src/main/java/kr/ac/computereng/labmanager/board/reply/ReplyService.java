package kr.ac.computereng.labmanager.board.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.computereng.labmanager.common.board.reply.IReplyService;
import kr.ac.computereng.labmanager.common.board.reply.repo.IReplyRepository;
import kr.ac.computereng.labmanager.common.datatype.ReplyDatatype;

public class ReplyService implements IReplyService{

	@Autowired
	private IReplyRepository replyRepository;
	
	@Override
	public void addReply(ReplyDatatype vo) throws Exception {
		replyRepository.create(vo);
	}

	@Override
	public List<ReplyDatatype> listReply(Integer bno) throws Exception {
		return replyRepository.list(bno);
	}

	@Override
	public void modifyReply(ReplyDatatype vo) throws Exception {
		replyRepository.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		replyRepository.delete(rno);
	}
}

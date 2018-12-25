package kr.ac.computereng.labmanager.common.board.reply.repo;

import java.util.List;

import kr.ac.computereng.labmanager.common.datatype.ReplyDatatype;

public interface IReplyRepository {
	public List<ReplyDatatype> list(Integer bno) throws Exception;
	public void create(ReplyDatatype vo) throws Exception;
	public void update(ReplyDatatype vo) throws Exception;
	public void delete(Integer rno) throws Exception;
}

package kr.ac.computereng.labmanager.common.board.reply;

import java.util.List;

import kr.ac.computereng.labmanager.common.datatype.ReplyDatatype;

public interface IReplyService {
	public void addReply(ReplyDatatype vo) throws Exception;
	public List<ReplyDatatype> listReply(Integer bno) throws Exception;
	public void modifyReply(ReplyDatatype vo) throws Exception;
	public void removeReply(Integer rno) throws Exception;
}

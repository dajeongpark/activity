package com.bora.board;

public interface BoardReplyDAO {
	
	//reply
	public int reply(BoardReplyDTO brDTO) throws Exception;
	
	//replyUpdate
	public int replyUpdate(BoardReplyDTO brDTO) throws Exception;
	
	
}

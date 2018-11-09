package com.bora.board;

public interface BoardReplyDAO {
	
	//reply
	public int reply(BoardReplyDTO boardReplyDTO) throws Exception;
	
	//replyUpdate
	public int replyUpdate(BoardReplyDTO boardReplyDTO) throws Exception;

}

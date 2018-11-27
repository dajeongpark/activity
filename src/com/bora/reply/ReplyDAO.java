package com.bora.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bora.board.BoardDAO;
import com.bora.board.BoardDTO;
import com.bora.board.BoardReplyDAO;
import com.bora.board.BoardReplyDTO;
import com.bora.page.RowNumber;
import com.bora.page.Search;
import com.bora.util.DBConnector;




public class ReplyDAO implements BoardDAO {

	
	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<ReplyDTO> selectList() { //?
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> selectList(RowNumber rowNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	


}

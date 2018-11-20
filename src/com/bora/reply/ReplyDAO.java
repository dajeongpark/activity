package com.bora.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bora.board.BoardDAO;
import com.bora.board.BoardDTO;
import com.bora.board.BoardReplyDAO;
import com.bora.page.RowNumber;
import com.bora.page.Search;
import com.bora.util.DBConnector;




public class ReplyDAO implements BoardDAO {

	@Override
	public List<BoardDTO> selectList(RowNumber rowNumber) throws Exception {
	Connection con = DBConnector.getConnect();
	String sql="select * from reply ";
	
	PreparedStatement st =con.prepareStatement(sql);
	List<BoardDTO> ar = new ArrayList<>();
	ResultSet rs = st.executeQuery();
	  ReplyDTO replyDTO = null;
	while(rs.next()) {
		replyDTO = new ReplyDTO();
		replyDTO.setNum(rs.getInt("num"));
		replyDTO.setWriter(rs.getString("writer"));
		replyDTO.setContents(rs.getString("contents"));
		replyDTO.setReg_date(rs.getDate("reg_date"));
		replyDTO.setDtKind(rs.getString("dtkind"));
		ar.add(replyDTO);
	}
	DBConnector.disConnect(rs, st, con);
		return ar;
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
	
	
	


}

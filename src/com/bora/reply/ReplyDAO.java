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
//답글
	@Override
	public List<BoardDTO> selectList(RowNumber rowNumber) throws Exception {
	Connection con = DBConnector.getConnect();
	String sql="select * from reply";
	PreparedStatement st =con.prepareStatement(sql);
	
	ResultSet rs = st.executeQuery();
	List<BoardDTO> ar = new ArrayList<>();
	while(rs.next()) {
		BoardReplyDTO boardReplyDTO=null;
		ReplyDTO replyDTO = new ReplyDTO();
		
		replyDTO.setNum(rs.getInt("num"));
		replyDTO.setWriter(rs.getString("writer"));
		replyDTO.setContents(rs.getString("contents"));
		replyDTO.setReg_date(rs.getDate("reg_date"));
		replyDTO.setDtKind(rs.getString("dtkind"));
		ar.add(boardReplyDTO);
	}
	DBConnector.disConnect(rs, st, con);
		return ar;
	}


	@Override
	public BoardDTO selectOne(int num) throws Exception {
		BoardDTO boardDTO=null;
		BoardReplyDTO boardReplyDTO = new BoardReplyDTO();
		Connection con=DBConnector.getConnect();
		String sql="select * from Qna where num=?";
		
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setInt(1, num);
		ResultSet rs=st.executeQuery();
		
		if(rs.next()) {
			boardDTO= new BoardDTO();
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setReg_date(rs.getDate("reg_date"));
			boardReplyDTO.setRef(rs.getInt("ref"));
			boardReplyDTO.setStep(rs.getInt("step"));
			boardReplyDTO.setDepth(rs.getInt("depth"));
		}
		return boardReplyDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		Connection con=DBConnector.getConnect();
		String sql="insert into reply values(reply_seq.nextval,?,?,sysdate,?)";
		
		PreparedStatement st=con.prepareStatement(sql);
		ReplyDTO replyDTO = new ReplyDTO();
		
		st.setString(1, replyDTO.getWriter());
		st.setString(2, replyDTO.getContents());
		st.setString(3, replyDTO.getDtKind());
		int result= st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
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

	public List<ReplyDTO> selectList() { //?
		// TODO Auto-generated method stub
		return null;
	}
	
	
	


}

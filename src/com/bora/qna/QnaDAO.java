package com.bora.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bora.board.BoardDAO;
import com.bora.board.BoardDTO;
import com.bora.board.BoardReplyService;
import com.bora.board.BoardReplyDAO;
import com.bora.board.BoardReplyDTO;
import com.bora.page.RowNumber;
import com.bora.page.Search;
import com.bora.util.DBConnector;

public class QnaDAO implements BoardDAO, BoardReplyDAO {
	
	@Override			 //답글
	public int reply(BoardReplyDTO boardReplyDTO) throws Exception {
		Connection con =DBConnector.getConnect();
		String sql="insert into qna values(qna_seq.nextval,?,?,?,sysdate,0,?,?,?)";
		
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, boardReplyDTO.getTitle());
		st.setString(2, boardReplyDTO.getWriter());
		st.setString(3, boardReplyDTO.getContents());
		st.setInt(4, boardReplyDTO.getRef());
		st.setInt(5, boardReplyDTO.getStep());
		st.setInt(6, boardReplyDTO.getDepth());
		int result= st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	@Override 		//replyUpdate
	public int replyUpdate(BoardReplyDTO parent) throws Exception {
		Connection con= DBConnector.getConnect();
		String sql="update qna set step=step+1 where ref=? and step>?";
		
		PreparedStatement st= con.prepareStatement(sql);
		st.setInt(1, parent.getRef());
		st.setInt(2, parent.getStep());
		int result=st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override		//selectOne
	public BoardDTO selectOne(int num) throws Exception {
		QnaDTO qnaDTO=null;
		Connection con = DBConnector.getConnect();
		String sql ="select * from qna where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			qnaDTO = new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));	
		}
		
		DBConnector.disConnect(rs, st, con);
		return qnaDTO;
	}
	
	@Override
	public List<BoardDTO> selectList(RowNumber rowNumber) throws Exception {
		Connection con = DBConnector.getConnect();
		//rownum을 하나의 컬럼으로 만들어서 컬럼 갯수 세기
		//from 뒤에 띄어쓰기 유의
		String sql = "select * from "
				+ "(select rownum R, Q.* from "
				+ "(select * from qna "
				+ "where "+rowNumber.getSearch().getKind()+" like ? "
				+ "order by ref desc, step asc) Q) "
				+ "where R between ? and ?";
			
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+rowNumber.getSearch().getSearch()+"%");
		st.setInt(2, rowNumber.getStartRow());
		st.setInt(3, rowNumber.getLastRow());
			
		ResultSet rs = st.executeQuery();
		List<BoardDTO> ar = new ArrayList<>();
		QnaDTO qnaDTO = null;
			
		while(rs.next()) {
			qnaDTO = new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			qnaDTO.setDepth(rs.getInt("depth"));
			ar.add(qnaDTO);
		}
			
		DBConnector.disConnect(rs, st, con);
		return ar;
	}


	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into qna values(?,?,?,?,sysdate,0,)";
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update qna set title=?,contents=? where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public int delete(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete qna where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
		
	}

	@Override
	public int getCount(Search search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select count(num) from qna "
				+ "where "+search.getKind()+" like ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search.getSearch()+"%");
		
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}

}

package com.bora.nontice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.bora.board.BoardDAO;
import com.bora.board.BoardDTO;
import com.bora.page.RowNumber;
import com.bora.page.Search;
import com.bora.util.DBConnector;

public class NoticeDAO implements BoardDAO {

	@Override
	public List<BoardDTO> selectList(RowNumber rowNumber) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql="";
		PreparedStatement st = con.prepareStatement(sql);
		
		
		return null;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from notice where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		NoticeDTO ndto = new NoticeDTO();
		if(rs.next()) {
			ndto.setNum(rs.getInt("num"));
			ndto.setTitle(rs.getString("title"));
			ndto.setContents(rs.getString("contents"));
			ndto.setWriter(rs.getString("writer"));
			ndto.setReg_date(rs.getDate("reg_date"));
			ndto.setHit(rs.getInt("hit"));
		}
		DBConnector.disConnect(rs, st, con);
		return ndto;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into notice values(?,?,?,?,sysdate,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, boardDTO.getNum());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		st.setString(4, boardDTO.getWriter());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update notice set title=? contents=? where num=?";
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
		String sql = "delete notice where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override
	public int getCount(Search search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		return 0;
	}

}

package com.bora.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.bora.board.BoardDAO;
import com.bora.board.BoardDTO;
import com.bora.page.RowNumber;
import com.bora.page.Search;
import com.bora.util.DBConnector;

public class NoticeDAO implements BoardDAO{

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
		Connection con = DBConnector.getConnect();
		String sql = "insert into notice values(?,?,?,?,sysdate,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, boardDTO.getNum());//글번호
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		st.setString(4, boardDTO.getWriter());
		int result = st.executeUpdate();
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
		Connection con = DBConnector.getConnect();
		String sql = "delete * from notice where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);//숫자
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override
	public int getCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.bora.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bora.activity.ActivityDTO;
import com.bora.page.RowNumber;
import com.bora.page.Search;
import com.bora.util.DBConnector;

public class ReplyDAO {
	
	//selectList(replyList)
	public List<ReplyDTO> selectList(int idx, RowNumber rowNumber) throws Exception {
		Connection con = DBConnector.getConnect();
		ReplyDTO replyDTO = new ReplyDTO();
		String sql = "select * from "
				+ "(select rownum R, M.* from "
				+ "(select * from reply where idx=? order by num desc) M) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, idx);
		st.setInt(2, rowNumber.getStartRow());
		st.setInt(3, rowNumber.getLastRow());
		
		ResultSet rs = st.executeQuery();
		List<ReplyDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			replyDTO.setNum(rs.getInt("num"));
			replyDTO.setWriter(rs.getString("writer"));
			replyDTO.setContents(rs.getString("contents"));
			replyDTO.setReg_date(rs.getDate("reg_date"));
			replyDTO.setIdx(rs.getInt("idx"));
			ar.add(replyDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	
	/* 댓글 paging 안 할 때
		//selectList(replyList)
		public List<ReplyDTO> selectList(int idx) throws Exception {
			Connection con = DBConnector.getConnect();
			ReplyDTO replyDTO = null;
			String sql = "select * from (select * from reply where idx=? order by num asc)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idx);
			
			ResultSet rs = st.executeQuery();
			List<ReplyDTO> ar = new ArrayList<>();
			
			while(rs.next()) {
				replyDTO = new ReplyDTO();
				replyDTO.setNum(rs.getInt("num"));
				replyDTO.setWriter(rs.getString("writer"));
				replyDTO.setContents(rs.getString("contents"));
				replyDTO.setReg_date(rs.getDate("reg_date"));
				replyDTO.setIdx(rs.getInt("idx"));
				ar.add(replyDTO);
			}
			
			DBConnector.disConnect(rs, st, con);
			return ar;
		}*/
	
	
	
	
	
	//insert(replyWrite)
	public int insert(int idx, ReplyDTO replyDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		ActivityDTO activityDTO = new ActivityDTO();
		String sql = "insert into reply values (reply_seq.nextval, ?, ?, sysdate, ?)";
												//num,writer,contents,reg_date,idx
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, replyDTO.getWriter());
		st.setString(2, replyDTO.getContents());
		st.setInt(3, idx); //replyDTO.getIdx()
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//update(replyUpdate)
	public int update(ReplyDTO replyDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update reply set contents=? where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, replyDTO.getContents());
		st.setInt(2, replyDTO.getNum());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//delete(replyDelete)
	public int delete(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete reply where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num); // or replyDTO.num ?
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//getCount
	public int getCount(Search search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select count(num) from reply "
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

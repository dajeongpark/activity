package com.bora.activity;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bora.page.RowNumber;
import com.bora.util.DBConnector;
import com.bora.page.Search;

public class ActivityDAO {
	
	//selectList
	public List<ActivityDTO> selectList(RowNumber rowNumber) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+ "(select rownum R, M.* from "
				+ "(select * from activity order by num desc) M) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, rowNumber.getStartRow());
		st.setInt(2, rowNumber.getLastRow());
		
		ResultSet rs = st.executeQuery();
		List<ActivityDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			ActivityDTO activityDTO = new ActivityDTO();
			activityDTO.setNum(rs.getInt("num"));
			activityDTO.setWriter(rs.getString("writer"));
			activityDTO.setTitle(URLEncoder.encode(rs.getString("title"), "UTF-8"));
			activityDTO.setContents(rs.getString("contents"));
			activityDTO.setHit(rs.getInt("hit"));
			activityDTO.setArea(rs.getString("area"));
			activityDTO.setOnePrice(rs.getInt("onePrice"));
			ar.add(activityDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	//selectOne
	public ActivityDTO selectOne(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from activity where num = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		ActivityDTO activityDTO = null;
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			activityDTO = new ActivityDTO();
			activityDTO.setNum(rs.getInt("num"));
			activityDTO.setWriter(rs.getString("writer"));
			activityDTO.setTitle(rs.getString("title"));
			activityDTO.setContents(rs.getString("contents"));
			activityDTO.setHit(rs.getInt("hit"));
			activityDTO.setArea(rs.getString("area"));
			activityDTO.setOnePrice(rs.getInt("onePrice"));
		}
		
		DBConnector.disConnect(rs, st, con);
		return activityDTO;
	}
	
	//insert
	public int insert(ActivityDTO activityDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into activity values (?, 'admin', ?, ?, 0, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, activityDTO.getNum());
		st.setString(2, activityDTO.getTitle());
		st.setString(3, activityDTO.getContents());
		st.setString(4, activityDTO.getArea());
		st.setInt(5, activityDTO.getOnePrice());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//getNum (sequence 가져오기)
	public int getNum() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select activity_seq.nextval from dual";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		int num = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return num;
	}
	
	//update
	public int update(ActivityDTO activityDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update activity set title=?, area=?, onePrice=?, contents=? where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, activityDTO.getTitle());
		st.setString(2, activityDTO.getArea());
		st.setInt(3, activityDTO.getOnePrice());
		st.setString(4, activityDTO.getContents());
		st.setInt(5, activityDTO.getNum());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//delete
	public int delete(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete activity where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//getCount
	public int getCount(Search search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select count(num) from notice "
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

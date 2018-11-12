package com.bora.activity;

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
			activityDTO.setTitle(rs.getString("title"));
			activityDTO.setContents(rs.getString("contents"));
			activityDTO.setHit(rs.getInt("hit"));
			activityDTO.setFname(rs.getString("fname"));
			activityDTO.setOname(rs.getString("oname"));
			activityDTO.setArea(rs.getString("area"));
			ar.add(activityDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	//selectOne
	
	//activityWrite
	
	//activityUpdate
	
	//activityDelete
	
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

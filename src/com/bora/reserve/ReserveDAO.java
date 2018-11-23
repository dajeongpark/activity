package com.bora.reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bora.util.DBConnector;

public class ReserveDAO {
	
	//selectOne
	public List<ReserveDTO> selectOne(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+ "(select * from reserve where num = ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ReserveDTO reserveDTO = null;
		List<ReserveDTO> ar = new ArrayList<>();
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			reserveDTO = new ReserveDTO();
			reserveDTO.setNum(rs.getInt("num"));
			reserveDTO.setTitle(rs.getString("title"));
			reserveDTO.setSelectDate(rs.getString("selectDate"));
			reserveDTO.setPerson(rs.getInt("person"));
			reserveDTO.setPrice(rs.getInt("price"));
			ar.add(reserveDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	/*public int insert(ReserveDTO reserveDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into reserve(num, title, price) values (?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, reserveDTO.getNum()); //get it with parameter
		st.setString(2, reserveDTO.getTitle()); //get it from activity
		st.setInt(3, reserveDTO.getPrice()); //get it from activity
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}*/
	
	//reserve
	public int reserve(ReserveDTO reserveDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into reserve values (?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		//get all of these with parameters
		st.setInt(1, reserveDTO.getNum());
		st.setString(2, reserveDTO.getTitle());
		st.setString(3, reserveDTO.getSelectDate());
		st.setInt(4, reserveDTO.getPerson());
		st.setInt(5, reserveDTO.getPrice());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
}

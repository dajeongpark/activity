package com.bora.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bora.util.DBConnector;
import com.sun.org.apache.regexp.internal.recompile;

public class MemberDAO {
	
	//checkId
	public boolean checkId(String id) throws Exception {
		boolean check = true;
		Connection con = DBConnector.getConnect();
		String sql = "select id from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		check = rs.next();
		
		DBConnector.disConnect(rs, st, con);
		return check;
	}
	
	//delete 
	public int delete(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//update
	public int update(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update member set pw=?, name=?, email=?, birth=?, domain=?, phone1=?, phone2=?, phone3=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getPw());
		st.setString(2, memberDTO.getName());
		st.setString(3, memberDTO.getEmail());
		st.setString(4, memberDTO.getBirth());
		st.setString(5, memberDTO.getDomain());
		st.setString(6, memberDTO.getPhone1());
		st.setString(7, memberDTO.getPhone2());
		st.setString(8, memberDTO.getPhone3());
		st.setString(9, memberDTO.getId());
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
		
	}
	
	//login
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from member where id=? and pw=? and kind=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getKind());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setDomain(rs.getString("domain"));
			memberDTO.setBirth(rs.getString("birth"));
			memberDTO.setPhone1(rs.getString("phone1"));
			memberDTO.setPhone2(rs.getString("phone2"));
			memberDTO.setPhone3(rs.getString("phone3"));
		}else {
			memberDTO = null;
		}
		DBConnector.disConnect(rs, st, con);
		return memberDTO;
	}
	
	//join
	public int join(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getPhone1());
		st.setString(6, memberDTO.getBirth());
		st.setString(7, memberDTO.getKind());
		st.setString(8, memberDTO.getDomain());
		st.setString(9, memberDTO.getPhone2());
		st.setString(10, memberDTO.getPhone3());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
	}

}

package com.bora.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bora.util.DBConnector;

public class FileDAO {
	
	//selectList
	public List<FileDTO> selectList(FileDTO fileDTO) throws Exception {
		List<FileDTO> ar = new ArrayList<>();
		Connection con = DBConnector.getConnect();
		String sql = "select * from upload where num = ? and kind = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, fileDTO.getNum());
		st.setString(2, fileDTO.getKind()); // A : Activity
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			fileDTO = new FileDTO();
			fileDTO.setFnum(rs.getInt("fnum"));
			fileDTO.setFname(rs.getString("fname"));
			fileDTO.setOname(rs.getString("oname"));
			fileDTO.setNum(rs.getInt("num"));
			fileDTO.setKind(rs.getString("kind"));
			ar.add(fileDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	//selectOne
	public FileDTO selectOne(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from upload where num = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		FileDTO fileDTO = null;
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			fileDTO = new FileDTO();
			fileDTO.setFnum(rs.getInt("fnum"));
			fileDTO.setFname(rs.getString("fname"));
			fileDTO.setOname(rs.getString("oname"));
			fileDTO.setNum(rs.getInt("num"));
			fileDTO.setKind(rs.getString("kind"));
		}
		DBConnector.disConnect(rs, st, con);
		return fileDTO;
	}
	
	//insert
	public int insert(FileDTO fileDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into upload values (upload_seq.nextval,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, fileDTO.getFname());
		st.setString(2, fileDTO.getOname());
		st.setInt(3, fileDTO.getNum());
		st.setString(4, fileDTO.getKind());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	
	//delete
	public int delete(int fnum) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete upload where fNum=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, fnum);
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//deleteAll
	public int deleteAll(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete upload where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
}

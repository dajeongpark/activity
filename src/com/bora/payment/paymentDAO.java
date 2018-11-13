package com.bora.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.bora.util.DBConnector;

public class paymentDAO {

	//payment Add
	//payment Edit
	//payment Delete
	//payment update
	//payment Save
	//payment search
	//payment checkDetaills
	
	public int paymentAdd() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into teamP values(?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		int result = 
		
		DBConnector.disConnect(st, con);
		return result;
	};
	public void paymentDelete() throws Exception{
		
	};
	public void paymentUpdate() throws Exception{
		
	};
	
	public void paymentSave() throws Exception{
		
	}
	public void paymentSearch() throws Exception{
		
	}
	public void paymentCheckDetails() throws Exception{
		
	};
	
	
}

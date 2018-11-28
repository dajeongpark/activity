package com.bora.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bora.activity.ActivityDTO;
import com.bora.card.CardDTO;
import com.bora.payment.MemberDTO;
import com.bora.payment.paymentDTO;
import com.bora.reserve.ReserveDTO;
import com.bora.util.DBConnector;

public class OrderDAO {
	//payment Add
		//payment Edit
		//payment Delete
		//payment update
		//payment Save
		//payment search
		//payment checkDetaills
		
		
		
		
	/*	public void paymentSave() throws Exception{
			
		}
		public void paymentSearch() throws Exception{
			
		}
		public void paymentCheckDetails() throws Exception{
			
		};*/
		
		//주문ID생성
		
		public void orderId() throws Exception{
			paymentDTO paymentDTO= new paymentDTO();
			
			 //주문번호 생성을 위한 날짜를 구합니다.
			Date now = new Date();
			SimpleDateFormat today = new SimpleDateFormat("yyyyMMddSS");
			SimpleDateFormat thisTime = new SimpleDateFormat("hhmmss");
			String orderDate = today.format(now);
			orderDate = orderDate + '-' + thisTime.format(now);
			 //주문 번호를 생성(중복이 되지 않겠끔)
			 String  orderID = orderDate;
			 //System.out.println(orderID);
			 paymentDTO.setOrderId(orderID);
		}
		
		
		//주문내용 확인하고 확인누르면 result값 넘겨주기
		public int orderConfirm(ReserveDTO reserveDTO, MemberDTO memberDTO, CardDTO cardDTO) throws Exception{
			Connection con = DBConnector.getConnect();
			String sql = "insert into payment values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			int totalPrice = reserveDTO.getOnePrice()*reserveDTO.getPerson();
			String payMethod = "card";
			
			st.setString(1, memberDTO.getName());
			st.setString(2, memberDTO.getEmail());
			st.setString(3, memberDTO.getPhone());
			st.setString(4, reserveDTO.getTitle());
			st.setInt(5, reserveDTO.getOnePrice());
			st.setInt(6, reserveDTO.getPerson());
			st.setInt(7, totalPrice);
			st.setString(8, payMethod);
			st.setInt(9, cardDTO.getNum());
			st.setDate(10, reserveDTO.getSelectDate());

			int result= st.executeQuery();
			
			DBConnector.disConnect(st, con);
			return result;
		}
		
		//수수료 계산
		public void feesCal() throws Exception{
			paymentDTO paymentDTO= new paymentDTO();
			int fees = 0;
			fees = (int)(paymentDTO.getTotalPrice()*0.05);
			
			//System.out.println(fees);
			
		}
		

		//주문정보불러오기
		public ReserveDTO orderInfo(int idx) throws Exception{
			Connection con= DBConnector.getConnect();
			String sql ="select num,title,selectDate,onePrice,person from reserve where idx=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idx);
					
			ReserveDTO reserveDTO = null;
			paymentDTO paymentDTO = null;

			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				reserveDTO = new ReserveDTO();
				paymentDTO = new paymentDTO();
				int totalPrice = reserveDTO.getOnePrice()*reserveDTO.getPerson();
				reserveDTO.setNum(rs.getInt("num"));
				reserveDTO.setTitle(rs.getString("title"));
				reserveDTO.setSelectDate(rs.getDate("selectDate"));
				reserveDTO.setOnePrice(rs.getInt("onePrice"));
				reserveDTO.setPerson(rs.getInt("person"));
				paymentDTO.setTotalPrice(totalPrice);
				
			}
			
			DBConnector.disConnect(rs, st, con);
			
			return reserveDTO;
			
		}
		//선택한 액티비티 상세내용 불러오기
		
		public ActivityDTO actInfo(int idx) throws Exception{
			Connection con = DBConnector.getConnect();
			String sql ="select * from activity where idx=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idx);
			
			ResultSet rs = st.executeQuery();
			
			ActivityDTO activityDTO = null;
			
			if(rs.next()) {
				activityDTO = new ActivityDTO();
				activityDTO.setNum(rs.getInt("num"));
				activityDTO.setTitle(rs.getString("title"));
				activityDTO.setFname(rs.getString("fname"));
				activityDTO.setOname(rs.getString("oname"));
				activityDTO.setContents(rs.getString("contents"));
				activityDTO.setHit(rs.getInt("hit"));
				activityDTO.setArea(rs.getString("area"));
			}
			
			DBConnector.disConnect(rs, st, con);
			return activityDTO; 
		}
		
}

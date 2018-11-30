package com.bora.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bora.activity.ActivityDTO;
import com.bora.card.CardDTO;
import com.bora.member.MemberDAO;
import com.bora.member.MemberDTO;
import com.bora.reserve.ReserveDAO;
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
		
		
		/*//주문ID생성
		
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

		//수수료 계산
		public void feesCal() throws Exception{
			paymentDTO paymentDTO= new paymentDTO();
			int fees = 0;
			fees = (int)(paymentDTO.getTotalPrice()*0.05);
			
			//System.out.println(fees);
			
		}
		*/
		

		//주문정보불러오기
		public OrderDTO orderInfo(int num, ReserveDTO reserveDTO) throws Exception{
			Connection con= DBConnector.getConnect();
			String sql ="select num,title,selectDate,onePrice,person from reserve where num=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, num);//상품번호
					
			OrderDTO orderDTO = null;

			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				orderDTO = new OrderDTO();
				int totalPrice = reserveDTO.getOnePrice()*reserveDTO.getPerson();
				orderDTO.setNum(rs.getInt("num"));
				orderDTO.setTitle(rs.getString("title"));
				orderDTO.setSelectDate(rs.getString("selectDate"));
				orderDTO.setOnePrice(rs.getInt("onePrice"));
				orderDTO.setPerson(rs.getInt("person"));
				orderDTO.setTotalPrice(totalPrice);
				
			}
			
			DBConnector.disConnect(rs, st, con);
			
			return orderDTO;
			
		}
		

		//주문내용 확인하고 확인누르면 result값 넘겨주기
		public int orderConfirm(ReserveDTO reserveDTO, MemberDTO memberDTO) throws Exception{
			Connection con = DBConnector.getConnect();
			String sql = "insert into payment values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			int totalPrice = reserveDTO.getOnePrice()*reserveDTO.getPerson();
			String payMethod = "card";
			String phone = memberDTO.getPhone1()+memberDTO.getPhone2()+memberDTO.getPhone3();
			
			st.setString(1, memberDTO.getName());
			st.setString(2, memberDTO.getEmail());
			st.setString(3, phone);
			st.setString(4, reserveDTO.getTitle());
			st.setInt(5, reserveDTO.getOnePrice());
			st.setInt(6, reserveDTO.getPerson());
			st.setInt(7, totalPrice);
			st.setString(8, payMethod);
			st.setString(9, reserveDTO.getSelectDate());

			int result= st.executeUpdate();
			
			DBConnector.disConnect(st, con);
			return result;
		}
		/*//주문내용 확인하고 확인누르면 result값 넘겨주기
		public int orderConfirm(ReserveDTO reserveDTO, MemberDTO memberDTO) throws Exception{
			Connection con = DBConnector.getConnect();
			String sql = "insert into payment values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			int totalPrice = reserveDTO.getOnePrice()*reserveDTO.getPerson();
			String payMethod = "card";
			
			st.setString(1, memberDTO.getName());
			st.setString(2, memberDTO.getEmail());
			st.setString(3, memberDTO.getPhone1());
			st.setString(4, memberDTO.getPhone2());
			st.setString(5, memberDTO.getPhone3());
			st.setString(6, reserveDTO.getTitle());
			st.setInt(7, reserveDTO.getOnePrice());
			st.setInt(8, reserveDTO.getPerson());
			st.setInt(9, totalPrice);
			st.setString(10, payMethod);
			st.setString(11, reserveDTO.getSelectDate());

			int result= st.executeUpdate();
			
			DBConnector.disConnect(st, con);
			return result;
		}*/
		
		/*//선택한 액티비티 상세내용 불러오기
		
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
		}*/
		
}

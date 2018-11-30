package com.bora.order;


import com.bora.action.ActionForward;
import com.bora.member.MemberDTO;
import com.bora.reserve.ReserveDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderService {
private OrderDAO orderDAO;
	
	public OrderService() {
		orderDAO = new OrderDAO();
	}
	
	//selectOne
	public ActionForward orderInfo(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		ReserveDTO reserveDTO = new ReserveDTO();	
		
		reserveDTO.setNum(Integer.parseInt(request.getParameter("num")));
		reserveDTO.setTitle(request.getParameter("title"));
		reserveDTO.setSelectDate(request.getParameter("selectDate"));
		reserveDTO.setOnePrice(Integer.parseInt(request.getParameter("onePrice")));
		reserveDTO.setPerson(Integer.parseInt(request.getParameter("person")));
		
		

		request.setAttribute("reserve", reserveDTO);
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/order/orderPage.jsp");
		
		
		return actionForward;
	}
	
	public ActionForward orderConfirm(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();

		String method=request.getMethod();
		
		if(method.equals("POST")) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setNum(Integer.parseInt(request.getParameter("num")));
			orderDTO.setName(request.getParameter("name"));
			orderDTO.setOnePrice(Integer.parseInt(request.getParameter("onePrice")));
			orderDTO.setPerson(Integer.parseInt(request.getParameter("person")));
			orderDTO.setEmail(request.getParameter("email"));
			orderDTO.setOrderId(request.getParameter("orderId"));
			orderDTO.setPayMethod(request.getParameter("payMethod"));
			orderDTO.setPhone(request.getParameter("phone"));
			orderDTO.setSelectDate(request.getParameter("selectDate"));
			orderDTO.setTotalPrice(Integer.parseInt(request.getParameter("totalPrice")));
			orderDTO.setTitle(request.getParameter("title"));
			HttpSession session = request.getSession();
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			ReserveDTO reserveDTO = new ReserveDTO();
			reserveDTO.setNum(Integer.parseInt(request.getParameter("num")));
			reserveDTO.setOnePrice(Integer.parseInt(request.getParameter("onePrice")));
			reserveDTO.setPerson(Integer.parseInt(request.getParameter("person")));
			reserveDTO.setSelectDate(request.getParameter("selectDate"));
			reserveDTO.setTitle(request.getParameter("title"));
			
			int result = 0;
			try {
				result = orderDAO.orderConfirm(reserveDTO, memberDTO);
			} catch (Exception e) {
				result = 0;
				e.printStackTrace();
			}
			
			if(result != 0) {
				session.setAttribute("order", orderDTO);
				actionForward.setCheck(false);
				actionForward.setPath("./orderResult.jsp");
			}else {
				request.setAttribute("message", "예약을 실패했습니다.");
				actionForward.setCheck(true);
				actionForward.setPath("../WEB-INF/view/reserve/reserve.jsp");
			}
			
		}else {
			//GET
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/order/orderPage.jsp");
			
		}
		return actionForward;
	}
}
package com.bora.order;


import com.bora.action.ActionForward;
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
		request.setAttribute("reserveDTO", reserveDTO);
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		OrderDAO orderDAO = new OrderDAO();
		try {
			orderDAO.orderInfo(num, reserveDTO);
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/order/orderPage.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			
			try {
				orderDTO = orderDAO.orderConfirm(reserveDTO, memberDTO);
			} catch (Exception e) {
				orderDTO = null;
				e.printStackTrace();
			}
			
			if(orderDTO != null) {
				HttpSession session = request.getSession();
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
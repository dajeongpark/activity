package com.bora.order;

import com.bora.action.ActionForward;
import com.bora.payment.HttpServletRequest;
import com.bora.payment.HttpServletResponse;
import com.bora.reserve.ReserveDTO;
/*import com.iu.action.ActionFoward;
import com.iu.member.HttpSession;
import com.iu.member.MemberDTO;*/

public class OrderService {
	
	
	public ActionForward orderInfo(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();

		String method=request.getMethod();
		
		if(method.equals("POST")) {
			OrderDTO orderDTO = new OrderDTO();
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
				orderDTO = orderDAO.orderInfo(orderDTO);
			} catch (Exception e) {
				orderDTO = null;
				e.printStackTrace();
			}
			
			if(orderDTO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("payment", orderDTO);
				actionForward.setCheck(false);
				actionForward.setPath("./orderResult.jsp");
			}else {
				request.setAttribute("message", "예약을 실패했습니다.");
				actionForward.setCheck(true);
				actionForward.setPath("../WEB-INF/view/reserve/reservePage.jsp");
			}
			
		}else {
			//GET
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/order/orderPage.jsp");
			
		}
		return actionForward;
	}
}
	/*
	//login
	public ActionFoward login(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		String method=request.getMethod();
		
		if(method.equals("POST")) {
		
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setKind(request.getParameter("kind"));
			try {
				memberDTO = memberDAO.login(memberDTO);
			} catch (Exception e) {
				memberDTO = null;
				e.printStackTrace();
			}
			
			if(memberDTO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", memberDTO);
				actionFoward.setCheck(false);
				actionFoward.setPath("../index.jsp");
			}else {
				request.setAttribute("message", "Login Fail");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberLogin.jsp");
			}
			
		}else {
			//GET
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberLogin.jsp");
			
		}
		return actionFoward;
	}
}
*/
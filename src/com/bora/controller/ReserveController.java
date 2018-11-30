package com.bora.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.order.OrderService;
import com.bora.reserve.ReserveService;

/**
 * Servlet implementation class ReserveController
 */
@WebServlet("/ReserveController")
public class ReserveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReserveService reserveService;
	private OrderService orderService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveController() {
        super();
        reserveService = new ReserveService();
        orderService = new OrderService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String command = request.getPathInfo();
		ActionForward actionForward = new ActionForward();
		
		if(command.equals("/reserve.do")) {
			actionForward = reserveService.selectOne(request, response);
		}else if(command.equals("/reserveWrite.do")) {
			actionForward = reserveService.reserve(request, response);
		}else if(command.equals("/orderPage.do")) {
			actionForward = orderService.orderInfo(request, response);
		}
		
		if(actionForward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionForward.getPath());
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

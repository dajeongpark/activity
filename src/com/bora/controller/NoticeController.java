package com.bora.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.notice.NoticeService;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getServletContext().getInitParameter("phone");
		System.out.println(phone);
		String command = request.getPathInfo();
		ActionForward actionForward = null;
		NoticeService noticeService = new NoticeService();
		
		if(command.equals("/noticeList.do")) {
			actionForward = noticeService.selectList(request, response);
		}else if(command.equals("/noticeSelectOne.do")) {
			actionForward = noticeService.selectOne(request, response);
		}else if(command.equals("/noticeWrite.do")) {
			actionForward = noticeService.insert(request, response);
		}else  if(command.equals("/noticeUpdate.do")){
			actionForward = noticeService.update(request, response);
		}
		
		if(actionForward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionForward.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

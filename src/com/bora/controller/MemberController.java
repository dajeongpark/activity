package com.bora.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.member.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
       memberService = new MemberService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = null;
		
		if(command.equals("/memberJoin.do")) {
			actionForward = memberService.join(request, response);
		}else if(command.equals("/memberLogin.do")){
			actionForward = memberService.login(request, response);
		}else if(command.equals("/memberLogout.do")) {
			actionForward = memberService.logout(request, response);
		}else if(command.equals("/memberMypage.do")) {
			actionForward = memberService.myPage(request, response);
		}else if(command.equals("/memberUpdate.do")) {
			actionForward = memberService.update(request, response);
		}else if(command.equals("/memberDelete.do")) {
			actionForward = memberService.delete(request, response);
		}else if(command.equals("/memberCheckId.do")) {
			actionForward = memberService.checkId(request, response);
		}else {
			actionForward = new ActionForward();
			actionForward.setCheck(true);
			actionForward.setPath("../index.jsp");
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

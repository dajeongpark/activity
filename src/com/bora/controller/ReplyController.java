package com.bora.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.reply.ReplyService;
/**
 * Servlet implementation class ReplyController
 */
@WebServlet("/ReplyController")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private ReplyService replyService;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyController() {
        super();
        replyService = new ReplyService();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board= this.getServletConfig().getInitParameter("board");
		System.out.println(board);
		
		String command = request.getPathInfo();
		ActionForward actionFoward = null;
		
		/*if(command.equals("/boardList.do")) {
			actionFoward = replyService.se
		}
	*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

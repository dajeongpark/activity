package com.bora.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.qna.QnaService;

/**
 * Servlet implementation class QnaController
 */
@WebServlet("/QnaController")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private QnaService qnaService;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaController() {
        super();
        qnaService = new QnaService();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String board = config.getInitParameter("board");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board = this.getServletConfig().getInitParameter("board");
		System.out.println(board);
		
		String command = request.getPathInfo();
		
		ActionForward actionForward = null;
		
		if(command.equals("/qnaList.do")) {
			actionForward = qnaService.selectList(request, response);
		}else if(command.equals("/qnaSelectOne.do")) {
			actionForward = qnaService.selectOne(request, response);
		}else if(command.equals("/qnaWrite.do")) {
			actionForward = qnaService.insert(request, response);
		}
			
		
		if(actionForward.isCheck()) {
			RequestDispatcher view  = request.getRequestDispatcher(actionForward.getPath());
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

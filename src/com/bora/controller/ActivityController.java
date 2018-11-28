package com.bora.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.activity.ActivityService;
/**
 * Servlet implementation class ActivityController
 */
@WebServlet("/ActivityController")
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityService activityService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityController() {
        super();
        activityService = new ActivityService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = new ActionForward();
		
		if(command.equals("/activityList.do")) {
			actionForward = activityService.selectList(request, response);
		}else if(command.equals("/activitySelectOne.do")){
			actionForward = activityService.selectOne(request, response);
		}else if(command.equals("/activityWrite.do")) {
			actionForward = activityService.insert(request, response);
		}else if(command.equals("/activityUpdate.do")) {
			actionForward = activityService.update(request, response);
		}else if(command.equals("/activityDelete.do")) {
			actionForward = activityService.delete(request, response);
		}else if(command.equals("/activityMore.do")) {
			actionForward = activityService.more(request, response);
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

package com.bora.activity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;

public class ActivityService {
	
	private ActionForward actionForward;
	
	public ActivityService() {
		actionForward = new ActionForward();
	}
	
	//selectList
	public ActionForward selectList(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		
		return actionForward;
	}
	
	//selectOne
	public void selectOne() {
		
	}
	
	//insert
	
	//update
	
	//delete

}

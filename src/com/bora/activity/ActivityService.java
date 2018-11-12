package com.bora.activity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.page.MakePager;
import com.bora.page.RowNumber;
import com.bora.page.Pager;

public class ActivityService {
	
	private ActionForward actionForward;
	private ActivityDAO activityDAO;
	
	public ActivityService() {
		actionForward = new ActionForward();
		activityDAO = new ActivityDAO();
	}
	
	//selectList
	public ActionForward selectList(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		int curPage=1;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			
		}
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		MakePager mk = new MakePager(curPage, search, kind);
		RowNumber rowNumber = mk.makeRow();
		
		try {
			List<ActivityDTO> ar = activityDAO.selectList(rowNumber);
			int totalCount = activityDAO.getCount(rowNumber.getSearch());
			Pager pager = mk.makePage(totalCount);
			request.setAttribute("list", ar);
			request.setAttribute("pager", pager);
			request.setAttribute("activity", "notice");
			actionForward.setPath("../WEB-INF/view/activity/activityList.jsp");
		} catch (Exception e) {
			request.setAttribute("message", "Fail");
			request.setAttribute("path", "../index.jsp");
			//actionForward.setPath("../WEB-INF/view/common/result.jsp");
			actionForward.setPath("../WEB-INF/view/activity/activityList.jsp");//지우기
			e.printStackTrace();
		}
		
		actionForward.setCheck(true);
		
		return actionForward;
	}
	
	//selectOne
	public void selectOne() {
		
	}
	
	//insert
	
	//update
	
	//delete

}

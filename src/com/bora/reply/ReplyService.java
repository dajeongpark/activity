package com.bora.reply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.page.MakePager;
import com.bora.page.RowNumber;

public class ReplyService {
	
	private ReplyDAO replyDAO;
	
	public ReplyService() {
		replyDAO = new ReplyDAO();
	}
	
	//selectList
	public ActionForward selectList(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		ReplyDTO replyDTO = new ReplyDTO();
		
		//int curPage = Integer.parseInt(request.getParameter("curPage"));
		int curPage=1;
		MakePager mk = new MakePager(curPage, 10, "", "");
		RowNumber rowNumber = mk.makeRow();
		
		try {
			int idx = Integer.parseInt(request.getParameter("num"));
			List<ReplyDTO> ar = replyDAO.selectList(idx, rowNumber);
			request.setAttribute("comments", ar);
			request.setAttribute("replyDTO", replyDTO);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/activity/activitySelectOne.jsp");
		
		return actionForward;
	}
	
	//insert
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		ReplyDTO replyDTO = new ReplyDTO();
		
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		MakePager mk = new MakePager(curPage, 10, "", "");
		RowNumber rowNumber = mk.makeRow();
		
		replyDTO.setContents(request.getParameter("contents"));
		//replyDTO.setWriter(request.getParameter("writer"));
		
		try {
			replyDAO.insert(replyDTO);
			int idx = Integer.parseInt(request.getParameter("num"));
			List<ReplyDTO> ar = replyDAO.selectList(idx, rowNumber);
			request.setAttribute("comments", ar);
			request.setAttribute("replyDTO", replyDTO);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/activity/replyWrite.jsp");
		
		return actionForward;
	}
	
	//update
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		return actionForward;
	}
	
	//delete
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		return actionForward;
	}

}

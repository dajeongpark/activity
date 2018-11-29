package com.bora.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.board.BoardReplyService;

public class NoticeService implements BoardReplyService{

	private NoticeDAO noticeDAO;
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	@Override
	public ActionForward selectList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward selectOne(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		//
		int num = Integer.parseInt(request.getParameter("num"));
		try {
			num = noticeDAO.delete(num);
			request.setAttribute("message", "delete fail");
			request.setAttribute("path", "./noticeList.do");
			if(num>0) {
				request.setAttribute("message", "delete success");
				request.setAttribute("path", "./noticeList.do");
			}
			
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/common/result.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actionForward;
	}

}

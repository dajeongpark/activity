package com.bora.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.board.BoardReplyService;
import com.bora.file.FileDAO;

public class NoticeService implements BoardReplyService{

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
		// TODO Auto-generated method stub
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
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			FileDAO fileDAO = new FileDAO();
			fileDAO.deleteAll(num);
			num = noticeDAO.delete(num);
			
			if(num>0) {
				request.setAttribute("message", "Delete Success");
				request.setAttribute("path", "./noticeList.do");
			}else {
				//update fail
				request.setAttribute("message", "Delete Fail");
				request.setAttribute("path", "./noticeList.do");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Delete Fail");
			request.setAttribute("path", "./noticeList.do");
			e.printStackTrace();
		}
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/common/result.jsp");
		
		return actionForward;
	}

}

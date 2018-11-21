package com.bora.reply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;

public class ReplyService {
	

	private ReplyDAO replyDAO;
	
	public ReplyService() {
		replyDAO= new ReplyDAO();
	}
	//insert
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		ReplyDTO replyDTO = new ReplyDTO();
		replyDTO.setContents(request.getParameter("contents"));
		try {
			int result= replyDAO.insert(replyDTO);
			String message= "fail";
			if(result>0) {
				message="Comment upload";
			}
			request.setAttribute("message", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/common/resultAjax.jsp");
		return actionForward;
	}
	//selectList
	public ActionForward selectList(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		try {
			List<ReplyDTO> ar = replyDAO.selectList();
			request.setAttribute("comments", ar);
		} catch (Exception e) {
			// TODO: handle exception
		}
//		actionForward.setCheck(true);
//		actionForward.setPath();
				
		
		return actionForward;
	}
	
	//delete
	
}

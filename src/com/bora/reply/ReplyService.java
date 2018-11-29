package com.bora.reply;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.activity.ActivityDTO;
import com.bora.member.MemberDTO;
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
		System.out.println("came");
		//int curPage = Integer.parseInt(request.getParameter("curPage"));
		int curPage=1;
		MakePager mk = new MakePager(curPage, 10, "", "");
		RowNumber rowNumber = mk.makeRow();
		
		replyDTO.setContents(request.getParameter("contents"));
		replyDTO.setWriter(request.getParameter("writer"));
		
		try {
			int idx = Integer.parseInt(request.getParameter("num"));
			replyDAO.insert(idx, replyDTO);
			System.out.println("idx : "+idx);
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		ReplyDTO replyDTO = new ReplyDTO();
		try {
			replyDTO.setNum(Integer.parseInt(request.getParameter("num")));
			replyDTO.setWriter(request.getParameter("writer"));
			replyDTO.setContents(request.getParameter("contents"));
			replyDTO.setReg_date((Date)sdf.parse(request.getParameter("reg_date")));
			replyDTO.setIdx(Integer.parseInt(request.getParameter("idx")));
			replyDAO.update(replyDTO);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String path = request.getPathInfo();
		path = path.replace(".do", ".jsp");
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/activity/"+path);
		
		
		return actionForward;
	}
	
	//delete
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		return actionForward;
	}

}

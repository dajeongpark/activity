package com.bora.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bora.action.ActionForward;

public class MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	//checkId
	public ActionForward checkId(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String id = request.getParameter("id");
		boolean check = true;
		String result = "0";
		
		try {
			check = memberDAO.checkId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(check) {
			result = "1";
		}
		
		request.setAttribute("result", result);
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/member/memberCheckId.jsp");
		
		return actionForward;
	}
	
	//delete
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		MemberDTO memberDTO = null;
		HttpSession session = request.getSession();
		memberDTO = (MemberDTO)session.getAttribute("member");
		String message = "회원 탈퇴에 실패하였습니다.";
		
		try {
			int result = memberDAO.delete(memberDTO);
			if(result>0) {
				message = "회원 탈퇴가 처리되었습니다.";
				session.invalidate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		request.setAttribute("path", "../index.jsp");
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/common/result.jsp");
		
		return actionForward;
	}
	
	//update
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		if(method.equals("POST")) {
			
			String message = "Update Fail";
			
			try {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setEmail(request.getParameter("email"));
				memberDTO.setDomain(request.getParameter("domain"));
				memberDTO.setBirth(request.getParameter("birth"));
				memberDTO.setPhone1(request.getParameter("phone1"));
				memberDTO.setPhone2(request.getParameter("phone2"));
				memberDTO.setPhone3(request.getParameter("phone3"));

				int result = memberDAO.update(memberDTO);
				if(result>0) {
					request.getSession().setAttribute("member", memberDTO);
					message="회원 정보가 수정되었습니다.";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("message", message);
			request.setAttribute("path", "./memberMypage.do");
			
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/common/result.jsp");
		}else {
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/member/memberUpdate.jsp");
		}
		return actionForward;
	}
	
	//MyPage
	public ActionForward myPage(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/member/memberMypage.jsp");
		
		return actionForward;
	}
	
	//logout
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		HttpSession session = request.getSession();
		session.invalidate();
		
		actionForward.setCheck(false);
		actionForward.setPath("../index.jsp");
		
		return actionForward;
	}
	
	//login
	public ActionForward login(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		if(method.equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setKind(request.getParameter("kind"));
			try {
				memberDTO = memberDAO.login(memberDTO);
			} catch (Exception e) {
				memberDTO = null;
				e.printStackTrace();
			}
			
			if(memberDTO!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", memberDTO);
				actionForward.setCheck(false);
				actionForward.setPath("../index.jsp");
			}else {
				request.setAttribute("message", "아이디 또는 비밀번호를 다시 확인하세요.");
				actionForward.setCheck(true);
				actionForward.setPath("../WEB-INF/view/member/memberLogin.jsp");
			}
		}else {
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/member/memberLogin.jsp");
		}
		
		return actionForward;
	}
	
	//join
	public ActionForward join(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		if(method.equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setName(request.getParameter("name"));
			memberDTO.setEmail(request.getParameter("email"));
			memberDTO.setDomain(request.getParameter("domain"));
			memberDTO.setBirth(request.getParameter("birth"));
			memberDTO.setKind(request.getParameter("kind"));
			memberDTO.setPhone1(request.getParameter("phone1"));
			memberDTO.setPhone2(request.getParameter("phone2"));
			memberDTO.setPhone3(request.getParameter("phone3"));
			
			try {
				int result = memberDAO.join(memberDTO);
				if(result>0) {
					request.setAttribute("message", "회원가입을 축하합니다.");
					request.setAttribute("path", "../index.jsp");
				}else {
					request.setAttribute("message", "Join Fail");
					request.setAttribute("path", "./memberJoin.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/common/result.jsp");
		}else {
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/member/memberJoin.jsp");
		}
		
		return actionForward;		
	}
	
	

}

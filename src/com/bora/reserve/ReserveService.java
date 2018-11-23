package com.bora.reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.activity.ActivityDTO;

public class ReserveService {
	
	private ReserveDAO reserveDAO;
	
	public ReserveService() {
		reserveDAO = new ReserveDAO();
	}
	
	//selectOne
	public ActionForward selectOne(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		ActivityDTO activityDTO = new ActivityDTO();
		request.setAttribute("activityDTO", activityDTO);
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/reserve/reserve.jsp");
		
		return actionForward;
	}
	
	//reserve(insert) (get selectDate, person with parameter and then put those into reserve)
	public ActionForward reserve(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		ReserveDTO reserveDTO = new ReserveDTO();
		
		String message="Fail";
		
		int num = Integer.parseInt(request.getParameter("num"));
		reserveDTO.setNum(num);
		reserveDTO.setSelectDate(request.getParameter("selectDate"));
		reserveDTO.setPerson(Integer.parseInt(request.getParameter("person")));
		reserveDTO.setTitle(request.getParameter("title"));
		reserveDTO.setPrice(Integer.parseInt(request.getParameter("price")));
		
		/* 어차피 title, price도 새 창에 뿌려줘야해서 DB로 가져오기 안 하고 parameter로 가져올거임
		ActivityDAO activityDAO = new ActivityDAO();
		ActivityDTO activityDTO = new ActivityDTO();
		try {
			activityDTO = activityDAO.selectOne(num);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		reserveDTO.setTitle(activityDTO.getTitle());
		reserveDTO.setPrice(activityDTO.getPrice());*/
		
		try {
			int result = reserveDAO.reserve(reserveDTO);
			
			request.setAttribute("message", result);
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/common/resultAjax.jsp");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return actionForward;
	}
	
}

package com.bora.file;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;

public class FileService {
	
	private FileDAO fileDAO;
	
	public FileService() {
		fileDAO = new FileDAO();
	}
	
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		int fnum = 0;
		try {
			fnum = Integer.parseInt(request.getParameter("fnum"));
		}catch (Exception e) {
			
		}
		
		String fname = request.getParameter("fname");
		
		try {
			fnum = fileDAO.delete(fnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(fnum>0) {
			String path = request.getServletContext().getRealPath("upload");
			System.out.println(path);
			File file = new File(path, fname);
			file.delete();
		}
		request.setAttribute("message", fnum);
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/common/resultAjax.jsp");
		
		return actionForward;
	}

}

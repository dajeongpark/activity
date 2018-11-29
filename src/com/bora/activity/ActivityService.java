package com.bora.activity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.file.FileDAO;
import com.bora.file.FileDTO;
import com.bora.page.MakePager;
import com.bora.page.RowNumber;
import com.bora.reply.ReplyDAO;
import com.bora.reply.ReplyDTO;
import com.bora.reply.ReplyService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.bora.page.Pager;

public class ActivityService {
	
	private ActivityDAO activityDAO;
	
	public ActivityService() {
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
		
		MakePager mk = new MakePager(curPage, "", "");
		RowNumber rowNumber = mk.makeRow();
		
		try {
			List<ActivityDTO> ar = activityDAO.selectList(rowNumber);
			request.setAttribute("list", ar);
		
		
		
		/* ==================== File for Title ==================== */
		
		
			FileDAO fileDAO = new FileDAO();
			List<FileDTO> fileAr = new ArrayList<>();
			for (int i=0; i<ar.size() ; i++) {
				FileDTO fileDTO = fileDAO.selectOne(ar.get(i).getNum());
				fileAr.add(fileDTO);
			}
			request.setAttribute("files", fileAr);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		/* ==================== File for Title ==================== */
		
		
		String path=request.getPathInfo();
		path = path.replace(".do", ".jsp");
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/activity"+path);
		
		return actionForward;
	}
	
	//selectOne
	public ActionForward selectOne(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		ActivityDTO activityDTO = null;
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		try {
			activityDTO = activityDAO.selectOne(num);
			FileDAO fileDAO = new FileDAO();
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setKind("A");
			List<FileDTO> ar = fileDAO.selectList(fileDTO);
			request.setAttribute("files", ar);
			request.setAttribute("activityDTO", activityDTO);
			
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/activity/activitySelectOne.jsp");
			
		} catch (Exception e) {
			actionForward.setCheck(false);
			actionForward.setPath("./activityList.do");
			e.printStackTrace();
		}
		
		/* ==================== replyList ==================== */
		
		ReplyService replyService = new ReplyService();
		replyService.selectList(request, response);
		
		/* ==================== replyList ==================== */
		
		
		if(activityDTO == null) {
			actionForward.setCheck(false);
			actionForward.setPath("./activityList.do");
		}
		
		return actionForward;
	}
	
	//insert
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		String method = request.getMethod();
		if(method.equals("POST")) {
			String message = "Insert Fail";
			String path = "./activityList.do";
			int maxSize = 1024*1024*10;
			String save = request.getServletContext().getRealPath("upload");
			System.out.println(save);
			File file = new File(save);
			if(!file.exists()) {
				file.mkdirs();
			}
			
			MultipartRequest multi;
			try {
				multi = new MultipartRequest(request, save, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				ActivityDTO activityDTO = new ActivityDTO();
				activityDTO.setNum(activityDAO.getNum());
				activityDTO.setTitle(multi.getParameter("title"));
				activityDTO.setContents(multi.getParameter("contents"));
				activityDTO.setArea(multi.getParameter("area"));
				activityDTO.setOnePrice(Integer.parseInt(multi.getParameter("onePrice")));
				int result = activityDAO.insert(activityDTO);
				if(result>0) {
					FileDAO fileDAO = new FileDAO();
					Enumeration<Object> e = multi.getFileNames();
					while(e.hasMoreElements()) {
						String p = (String)e.nextElement();
						FileDTO fileDTO = new FileDTO();
						fileDTO.setKind("A");
						fileDTO.setNum(activityDTO.getNum());
						fileDTO.setFname(multi.getFilesystemName(p));
						fileDTO.setOname(multi.getOriginalFileName(p));
						fileDAO.insert(fileDTO);
					}
					
					message = "Insert Success";
					actionForward.setCheck(true);
					actionForward.setPath("../WEB-INF/view/common/result.jsp");
					
				}else {
					actionForward.setCheck(true);
					actionForward.setPath("../WEB-INF/view/common/result.jsp");
				}
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("message", message);
			request.setAttribute("path", path);
			
		}else {
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/activity/activityWrite.jsp");
		}
		return actionForward;
	}
	
	//update
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		
		if(method.equals("POST")) {
			//DB Update
			int maxSize=1024*1024*10;
			String path = request.getServletContext().getRealPath("upload");
			File file = new File(path);
			if(!file.exists()) {
				file.mkdirs();
			}
			
			try {
				MultipartRequest multi = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				ActivityDTO activityDTO = new ActivityDTO();
				activityDTO.setNum(Integer.parseInt(multi.getParameter("num")));
				activityDTO.setTitle(multi.getParameter("title"));
				activityDTO.setArea(multi.getParameter("area"));
				activityDTO.setOnePrice(Integer.parseInt(multi.getParameter("onePrice")));
				activityDTO.setContents(multi.getParameter("contents"));
				
				//update
				int result = activityDAO.update(activityDTO);
				if(result>0) { //Update Success
					Enumeration<Object> e = multi.getFileNames();
					FileDAO fileDAO = new FileDAO();
					while(e.hasMoreElements()) {
						String key = (String)e.nextElement();
						FileDTO fileDTO = new FileDTO();
						fileDTO.setOname(multi.getOriginalFileName(key));
						fileDTO.setFname(multi.getFilesystemName(key));
						fileDTO.setKind("A");
						fileDTO.setNum(activityDTO.getNum());
						fileDAO.insert(fileDTO);
					}
					request.setAttribute("message", "Update Success");
					request.setAttribute("path", "./activityList.do");
				}
				
				
			} catch (Exception e) { //Exception 발생 시 Fail
				request.setAttribute("message", "Update Fail");
				request.setAttribute("path", "./activityList.do");
				e.printStackTrace();
			}
			
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/common/result.jsp");
			
		}else {
			//Form
			int num = Integer.parseInt(request.getParameter("num"));
			try {
				ActivityDTO activityDTO = activityDAO.selectOne(num);
				FileDAO fileDAO = new FileDAO();
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(num);
				fileDTO.setKind("A");
				List<FileDTO> ar = fileDAO.selectList(fileDTO);
				request.setAttribute("activityDTO", activityDTO);
				request.setAttribute("files", ar);
				actionForward.setCheck(true);
				actionForward.setPath("../WEB-INF/view/activity/activityUpdate.jsp");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return actionForward;
		
	}
	
	//delete
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			
			FileDAO fileDAO = new FileDAO();
			fileDAO.deleteAll(num);
			
			num = activityDAO.delete(num);
			
			if(num>0) {
				request.setAttribute("message", "Delete Success");
				request.setAttribute("path", "./activityList.do");
			}else {
				request.setAttribute("message", "Delete Fail");
				request.setAttribute("path", "./activityList.do");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Delete Fail");
			request.setAttribute("path", "./activityList.do");
			e.printStackTrace();
		}
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/common/result.jsp");
		
		return actionForward;
	}
	
	//more
	public ActionForward more(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		ActivityDTO activityDTO = new ActivityDTO();
		
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		
		MakePager mk = new MakePager(curPage, "", "");
		RowNumber rowNumber = mk.makeRow();
		
		List<ActivityDTO> ar;
		try {
			ar = activityDAO.selectList(rowNumber);
			request.setAttribute("list", ar);
			request.setAttribute("activityDTO", activityDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String path = request.getPathInfo();
		path = path.replace(".do", ".jsp");
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/activity/"+path);
		
		return actionForward;
	}
	
}
	


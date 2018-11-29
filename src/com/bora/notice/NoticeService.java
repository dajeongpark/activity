package com.bora.notice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.board.BoardDTO;
import com.bora.board.BoardReplyService;
import com.bora.file.FileDAO;
import com.bora.file.FileDTO;
import com.bora.page.MakePager;
import com.bora.page.Pager;
import com.bora.page.RowNumber;

public class NoticeService implements BoardReplyService{

	private NoticeDAO noticeDAO;
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	@Override
	public ActionForward selectList(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		int curPage = 1;
		curPage = Integer.parseInt(request.getParameter("curPage"));
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		MakePager mk = new MakePager(curPage, search, kind);
		RowNumber rowNumber = mk.makeRow();
		
		List<BoardDTO> ar;
		try {
			ar = noticeDAO.selectList(rowNumber);
			int totalCount = noticeDAO.getCount(rowNumber.getSearch());
			request.setAttribute("list", ar);
			Pager pager = mk.makePage(totalCount);
			request.setAttribute("pager", pager);
			request.setAttribute("board", "notice");
			actionForward.setPath("../WEB-INF/view/board/boardList.jsp");
		} catch (Exception e) {
			request.setAttribute("message", "Fail");
			request.setAttribute("path", "../index.jsp");
			e.printStackTrace();
		}
		actionForward.setPath("../WEB-INF/common/result/jsp");
		
		return actionForward;
	}

	@Override
	public ActionForward selectOne(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		BoardDTO boardDTO = null;
		int num = Integer.parseInt(request.getParameter("num"));
		try {
			boardDTO = noticeDAO.selectOne(num);
			FileDAO fileDAO = new FileDAO();
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setKind("N");
			List<FileDTO> ar = fileDAO.selectList(fileDTO);
			request.setAttribute("dto", boardDTO);
			request.setAttribute("files", ar);
			request.setAttribute("board", "notice");
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/board/boardSelectOne.jsp");
		} catch (Exception e) {
			actionForward.setCheck(false);
			actionForward.setPath("./noticeList.do");
			e.printStackTrace();
		}
		
		if(boardDTO ==null) {
			actionForward.setCheck(false);
			actionForward.setPath("./noticeLsit.do");
		}
		return actionForward;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		if(method.equals("POST")) {
			String message = "Fail";
			String path = "./noticeList.do";
			int maxSize = 1024*1024*10;
			String save = request.getServletContext().getRealPath("upload");
			System.out.println(save);
			File file = new File(save);
			if(!file.exists()) {
				file.mkdirs();
			}
		}
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

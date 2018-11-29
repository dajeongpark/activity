package com.bora.notice;

import java.io.File;
import java.util.Enumeration;
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
import com.bora.notice.NoticeDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeService implements BoardReplyService{

	private NoticeDAO noticeDAO;
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}

	@Override
	public ActionForward selectList(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		int curPage = 1;
		try {
			curPage = Integer.getInteger(request.getParameter("curPage"));
		}catch (Exception e) {

		}

		String kind = request.getParameter("kind");
		String search = request.getParameter("search");

		MakePager mk = new MakePager(curPage, search, kind);
		RowNumber rowNumber = mk.makeRow();
		List<BoardDTO> ar;

		try {
			ar = noticeDAO.selectList(rowNumber);
			int totalCount = noticeDAO.getCount(rowNumber.getSearch());
			Pager pager = mk.makePage(totalCount);
			request.setAttribute("list", ar);
			request.setAttribute("pager", pager);
			request.setAttribute("board", "notice");
			actionForward.setPath("../WEB-INF/view/board/boardList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionForward.setCheck(true);	
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

			try {
				MultipartRequest multi = new MultipartRequest(request, save, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setTitle(multi.getParameter("title"));
				noticeDTO.setWriter(multi.getParameter("writer"));
				noticeDTO.setContents(multi.getParameter("contents"));
				noticeDTO.setNum(noticeDAO.getNum());
				int result = noticeDAO.insert(noticeDTO);
				if(result>0) {
					FileDAO fileDAO = new FileDAO();
					//파일의 파라미터 명을 모은 것
					Enumeration<Object> e= multi.getFileNames();
					while(e.hasMoreElements()) {
						String p=(String)e.nextElement();
						FileDTO fileDTO = new FileDTO();
						fileDTO.setKind("N");
						fileDTO.setNum(noticeDTO.getNum());
						fileDTO.setFname(multi.getFilesystemName(p));
						fileDTO.setOname(multi.getOriginalFileName(p));
						fileDAO.insert(fileDTO);
					}
					
					message ="Success";
					actionForward.setCheck(true);
					actionForward.setPath("../WEB-INF/view/common/result.jsp");
				}else {
					actionForward.setCheck(true);
					actionForward.setPath("../WEB-INF/view/common/result.jsp");
					
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("message", message);
			request.setAttribute("path", path);
			
			
			
		}else {
			request.setAttribute("board", "notice");
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/board/boardWrite.jsp");
		}
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		if(method.equals("POST")) {
			//DB Update
			int max=1024*1024*10;
			String path = request.getServletContext().getRealPath("upload");
			File file = new File(path);
			if(!file.exists()) {
				file.mkdirs();
			}
			try {
				MultipartRequest multi = new MultipartRequest(request, path, max, "UTF-8", new DefaultFileRenamePolicy());
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setNum(Integer.parseInt(multi.getParameter("num")));
				noticeDTO.setTitle(multi.getParameter("title"));
				noticeDTO.setContents(multi.getParameter("contents"));
				//update
				int result = noticeDAO.update(noticeDTO);
				if(result>0) {
					Enumeration<Object> e = multi.getFileNames();
					FileDAO fileDAO = new FileDAO();
					while(e.hasMoreElements()) {
						FileDTO fileDTO = new FileDTO();
						String key = (String)e.nextElement();
						fileDTO.setOname(multi.getOriginalFileName(key));
						fileDTO.setFname(multi.getFilesystemName(key));
						fileDTO.setKind("N");
						fileDTO.setNum(noticeDTO.getNum());
						fileDAO.insert(fileDTO);
					}//while 끝
					
					request.setAttribute("message", "Update Success");
					request.setAttribute("path", "./noticeList.do");
				}else {
					//update fail
					request.setAttribute("message", "Update Fail");
					request.setAttribute("path", "./noticeList.do");
				}
				
				
			} catch (Exception e) {
				request.setAttribute("message", "Update Fail");
				request.setAttribute("path", "./noticeList.do");
				e.printStackTrace();
			}
			
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/common/result.jsp");
			
			
		}else {
			//Form 
			try {
				int num = Integer.parseInt(request.getParameter("num"));
				BoardDTO boardDTO = noticeDAO.selectOne(num);
				FileDAO fileDAO = new FileDAO();
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(num);
				fileDTO.setKind("N");
				List<FileDTO> ar = fileDAO.selectList(fileDTO);
				request.setAttribute("dto", boardDTO);
				request.setAttribute("files", ar);
				request.setAttribute("board", "notice");
				actionForward.setCheck(true);
				actionForward.setPath("../WEB-INF/view/board/boardUpdate.jsp");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return actionForward;
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
				request.setAttribute("message", "삭제되었습니다");
				request.setAttribute("path", "./noticeList.do");
			}else {
				request.setAttribute("message", "삭제가 실패되었습니다");
				request.setAttribute("path", "./noticeList.do");				
			} 


		} catch (Exception e) {
			request.setAttribute("message", "안되요오류에용");
			request.setAttribute("path", "./noticeList.do");
			e.printStackTrace();
		}

		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/common/result.jsp");
		return actionForward;
	}

}

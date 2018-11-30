package com.bora.qna;

import java.io.File;
import java.io.IOException;
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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class QnaService implements BoardReplyService {

	private QnaDAO qnaDAO;

	public QnaService() {
		qnaDAO = new QnaDAO();
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		if(method.equals("POST")) {
			String message = "Fail";
			String path = "./qnaList.do";
			int maxSize = 1024*1024*10;
			String save = request.getServletContext().getRealPath("upload");
			System.out.println(save);
			File file = new File(save);
			if(!file.exists()) {
				file.mkdirs();
			}
			try {
				MultipartRequest multi = new MultipartRequest(request, save, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				QnaDTO qnaDTO = new QnaDTO();
				qnaDTO.setTitle(multi.getParameter("title"));
				qnaDTO.setWriter(multi.getParameter("writer"));
				qnaDTO.setContents(multi.getParameter("contents"));
				qnaDTO.setNum(qnaDTO.getNum());
				int result = qnaDAO.insert(qnaDTO);
				if(result>0) {
					FileDAO fileDAO = new FileDAO();
					//파일의 파라미터 명을 모은 것
					Enumeration<Object> e= multi.getFileNames();
					while(e.hasMoreElements()) {
						String p=(String)e.nextElement();
						FileDTO fileDTO = new FileDTO();
						fileDTO.setKind("N");
						fileDTO.setNum(qnaDTO.getNum());
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
				e.printStackTrace();
			}

			request.setAttribute("message", message);
			request.setAttribute("path", path);

		}else {
			request.setAttribute("board", "qna");
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/board/boardWrite.jsp");
		}

		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();

		String method = request.getMethod();

		if(method.equals("post")) {
			//DBUPDATE
			int max=1024*1024*10;
			String path= request.getServletContext().getRealPath("upload");
			File file = new File(path);
			if(!file.exists()) {
				file.mkdirs(); //만들고자 하는 디렉토리의 상위 디렉토리가 존재하지 않는 이유?
			}
			try {	
				MultipartRequest multi = new MultipartRequest(request, path, max, "UTF-8", new DefaultFileRenamePolicy());
				QnaDTO qnaDTO = new QnaDTO();
				qnaDTO.setNum(Integer.parseInt(multi.getParameter("num")));
				qnaDTO.setTitle(multi.getParameter("title"));
				qnaDTO.setContents(multi.getParameter("contents"));
				int result = qnaDAO.update(qnaDTO);

				//up
				if(result>0) {
					Enumeration<Object> e= multi.getFileNames();
					FileDAO fileDAO = new FileDAO();

					while(e.hasMoreElements()) {
						FileDTO fileDTO =new FileDTO();
						String key = (String)e.nextElement();
						fileDTO.setOname(multi.getOriginalFileName(key));
						fileDTO.setFname(multi.getFilesystemName(key));
						fileDTO.setKind("N");
						fileDTO.setNum(qnaDTO.getNum());
						fileDAO.insert(fileDTO);

					} //while 끝

					//Update 성공
					request.setAttribute("message", "Update Success");
					request.setAttribute("path", "./qnaList.do");
				}else {
					// Update 실패
					request.setAttribute("message", "Update Fail");
					request.setAttribute("path", "./qnaList.do");
				}

			}catch (Exception e) {
				request.setAttribute("message", "Upate Fail");
				request.setAttribute("path", "./qnaList.do");
				e.printStackTrace();
			}

			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/view/common/result.jsp"); //실제 파일을 불러옴

		}else {
			try {
				int num= Integer.parseInt(request.getParameter("num"));
				BoardDTO boardDTO = qnaDAO.selectOne(num);
				FileDAO fileDAO = new FileDAO();
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(num);
				fileDTO.setKind("N");
				List<FileDTO> ar = fileDAO.selectList(fileDTO);
				request.setAttribute("dto", boardDTO);
				request.setAttribute("board", "qna");
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
		ActionForward actionForward= new ActionForward(); //알림창띄우게 만들기.

		try {
			int num= Integer.parseInt(request.getParameter("num"));//메세지를 요청
			FileDAO fileDAO = new FileDAO();
			fileDAO.deleteAll(num);
			num =qnaDAO.delete(num);

			if(num>0) {
				request.setAttribute("message", "Delete success"); //성공메세지를 띄운다.
				request.setAttribute("path", "./qnaList.do");

			}else {

				request.setAttribute("message", "Delete fail"); //실패 메세지를 띄우고
				request.setAttribute("path", "./qnaList.do");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Delete Fail");
			request.setAttribute("path", "./qnaList.do");

			e.printStackTrace();
		}

		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/view/common/result.jsp"); //실제 있는 파일을 불러옴

		return actionForward;
	}

	//select
	public ActionForward selectOne(HttpServletRequest request, HttpServletResponse response) {

		ActionForward actionForward = new ActionForward();
		actionForward.setCheck(false);
		actionForward.setPath("./qnaList.do");
		BoardDTO boardDTO = null;
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			boardDTO = qnaDAO.selectOne(num);

			request.setAttribute("dto", boardDTO);
			request.setAttribute("board", "qna");
			actionForward.setPath("../WEB-INF/view/board/boardSelectOne.jsp");
			actionForward.setCheck(true);

		}catch (Exception e) {

		}

		if(boardDTO==null){
			actionForward.setCheck(false);
			actionForward.setPath("./qnaList.do"); //실제 존재하는 파일을 불러옴.
		}
		return actionForward;
	}

	//list
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
			ar = qnaDAO.selectList(rowNumber);
			int totalCount = qnaDAO.getCount(rowNumber.getSearch());
			Pager pager = mk.makePage(totalCount);
			request.setAttribute("list", ar);
			request.setAttribute("pager", pager);
			request.setAttribute("board", "qna");
			actionForward.setPath("../WEB-INF/view/board/boardList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		actionForward.setCheck(true);
		return actionForward;

	}

}

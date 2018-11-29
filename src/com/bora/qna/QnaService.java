package com.bora.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bora.action.ActionForward;
import com.bora.board.BoardDTO;
import com.bora.board.BoardReplyService;
import com.bora.page.MakePager;
import com.bora.page.Pager;
import com.bora.page.RowNumber;

public class QnaService implements BoardReplyService {
	
	private QnaDAO qnaDAO;
	
	public QnaService() {
		qnaDAO = new QnaDAO();
	}
	
	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		BoardDTO boardDTO = new BoardDTO(); //QNADAO안에 insert랑 값이 같고, 
		boardDTO.setTitle(request.getParameter("title")); //set : 입력한 값을 getParameter를 통해 가
		boardDTO.setContents(request.getParameter("contents"));
		boardDTO.setWriter(request.getParameter("writer"));
		try {
			
			int insert=qnaDAO.insert(boardDTO);
			System.out.println(insert);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
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
			actionForward.setPath("./qnaList.do");
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
			Pager pager = mk.makePager(totalCount);		
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

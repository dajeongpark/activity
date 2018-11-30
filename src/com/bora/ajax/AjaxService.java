package com.bora.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bora.action.ActionForward;
import com.bora.board.BoardDTO;
import com.bora.notice.NoticeDAO;
import com.bora.page.RowNumber;
import com.bora.page.Search;

public class AjaxService {
   
   public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
      ActionForward actionForward = new ActionForward();
      NoticeDAO noticeDAO = new NoticeDAO();
      RowNumber rowNumber = new RowNumber();
      rowNumber.setStartRow(1);
      rowNumber.setLastRow(10);
      rowNumber.setSearch(new Search());
      List<BoardDTO> ar = null;
      
      try {
         ar = noticeDAO.selectList(rowNumber);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      JSONArray jr = new JSONArray();
      
      for(BoardDTO boardDTO : ar) {
         JSONObject js = new JSONObject();
         js.put("num", boardDTO.getNum());
         js.put("title", boardDTO.getTitle());
         js.put("writer", boardDTO.getWriter());
         jr.add(js);
      }
      
      request.setAttribute("message", jr.toJSONString());
      actionForward.setCheck(true);
      actionForward.setPath("../WEB-INF/view/common/resultAjax.jsp");
      
      return actionForward;
   }   

}
<%@page import="com.bora.board.BoardReplyDAO"%>
<%@page import="com.bora.qna.QnaDAO"%>
<%@page import="com.bora.qna.QnaDTO"%>
<%@page import="com.bora.board.BoardDTO"%>
<%@page import="com.bora.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <% 
    
    
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>
<%
   QnaDTO qnaDTO= (QnaDTO)session.getAttribute("qnadto");
%>
<% int num= Integer.parseInt(request.getParameter("num")); %>

<div class="container-fluid">
	<div class="row">
	<h1>Reply form</h1>
	  <form action="./qnaReplyProcess.jsp" method="post">
		<input type="hidden" name="num" value="<%=num%>">
	  
	    <div class="form-group">
	      <label for="title">TITLE:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">WRITER:</label>
	      <input type="text" class="form-control"  id="writer" placeholder="Enter writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">CONTENTS:</label>
	      <textarea rows="25" cols="" class="form-control" name="contents"></textarea>
	    </div>
	    
	    <button type="submit" class="btn btn-default">WRITER</button>
 	 </form>
	</div>
</div>
	

<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
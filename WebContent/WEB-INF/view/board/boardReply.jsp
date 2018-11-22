<%@page import="com.bora.board.BoardDTO"%>
<%@page import="com.bora.board.BoardDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    //1.부모 글 조회
    BoardDAO boardDAO = new BoardDAO();
    BoardDTO parent =boardDAO.selectOne(boardDTO.getNum());
    
    //2.stepupdate-업데이트 시켜줌
    int result= boardDAO.
    
    //3.reply
  	 boardDTO.setRef(parent.getRef());
    
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

<h2 align="center">답글쓰기</h2>
<form action="${board}Reply.do" method="post"></form>
	

<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
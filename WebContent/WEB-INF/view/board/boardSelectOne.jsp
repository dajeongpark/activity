<%@page import="java.util.List"%>
<%@page import="com.bora.file.FileDAO"%>
<%@page import="com.bora.file.FileDTO"%>
<%@page import="com.bora.board.BoardDTO"%>
<%@page import="com.bora.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../temp/bootStrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../../temp/header.jsp"></jsp:include>
	<div class="container-fluid">
	  <div class="row">
	  	<h1>${board} View</h1>
	  </div>
	  <div class="row">
		<h1>TITLE: ${dto.title}</h1>
		<h1>WRITER: ${dto.writer}</h1>
		<h1>CONTENTS: ${dto.contents}</h1>
	  </div>
	</div>
	<div>
	<!-- ${내장객체 이름 Scope.가져올값} -->
		<a href="./${requestScope.board}List.do">LIST</a>
		<a href="./${requestScope.board}Update.do?num=${dto.num}">UPDATE</a>
		<a href="./${requestScope.board}Delete.do?num=${dto.num}">DELETE</a>
	  <c:if test="${board ne 'notice'}">	
		<a href="./${board}Reply.do">REPLY</a>
	  </c:if>	
	</div>
<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="com.bora.file.FileDTO"%>
<%@page import="com.bora.file.FileDAO"%>
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
			<h1>TITLE : ${dto.title} </h1>
			<h1>WRITER : ${dto.writer} </h1>
			<h1>Contents : ${dto.contents}</h1>
			
		</div>	
		<c:forEach items="${files}" var="fileDTO">
			<img src="../upload/${fileDTO.fname}"><br>
		</c:forEach>
	<div>
		<a href="./${requestScope.board}List.do">List</a>
		<a href="./${requestScope.board}Update.do?num=${dto.num}">Update</a>
		<a href="./${requestScope.board}Delete.do?num=${dto.num}">Delete</a>
		<c:if test="${board ne 'notice'}">
			<a href="./${board}Reply.do">Reply</a>
		</c:if>
		<%-- <c:if test="${not empty board}"></c:if> --%>
	</div>
	</div>
	
<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>








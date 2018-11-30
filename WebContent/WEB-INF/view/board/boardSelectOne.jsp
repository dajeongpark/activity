<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<c:import url="../../../temp/bootStrap.jsp"/>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

	<div class="container-fluid" id="wrap" align="center">
		<div class="row">
			<h1>${board}View</h1>
		</div>
	<div class="row">
			<h1>Title :${boardDTO.title}</h1>
			<h1>Writer :${boardDTO.writer}</h1>
			<h1>Contents :${boardDTO.contents}</h1>
		</div>
		<div> 
			<a href="./${requestScope.board}List.do">LIST</a> 
			<a href="./${requestScope.board}Update.do?num=${boardDTO.num}">UPDATE</a>
			<a href="./${requestScope.board}Delete.do?num=${boardDTO.num}">DELETE</a>
			<%-- <a href="./${requestScope.board}Replyform.do?num=${boardDTO.num}">Reply</a> 

--%>
		<c:if test="${board ne 'notice'}"><!-- notice랑 board는 같지 않다 -->
		<a href="./${board}Replyform.do">REPLY</a> 
		</c:if>
		</div>
	</div>


	<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>

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
			<a href="./<%=request.getContextPath()%>/boardList.do">List</a> 
			<a href="./${requestScope.board}Update.do?num=${boardDTO.num}">Update</a>
			<a href="./${requestScope.board}Delete.do?num=${boardDTO.num}">Delete</a>
			<a href="./${requestScope.board}Reply.do?num=${boardDTO.num}">Reply</a>
		</div>
	</div>


	<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
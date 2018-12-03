<%@page import="java.util.List"%>
<%@page import="com.bora.file.FileDTO"%>
<%@page import="com.bora.file.FileDAO"%>
<%@page import="com.bora.board.BoardDTO"%>
<%@page import="com.bora.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../temp/bootStrap.jsp"></jsp:include>
<style type="text/css">
.box {
	margin-top: 50px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 90%;
	margin: 0 auto;
}

.contentsTable td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

.contentsTable tr:nth-child(odd) { /* nth-last-child(even) */
	background-color: #dddddd;
}

.replyWriteTable tr:first-child {
	background-color: white;
}

.replyTable tr:nth-child(odd) {
	background-color: #dddddd;
}

.btnBox {
	display: block;
	margin: 30px auto;
}

.second {
	display: block;
	margin-top: 30px;
}

.replyWriteTable td, th {
	border: none;
	text-align: center;
	padding: 8px;
}

.replySpace {
	border-top: 2px solid #dddddd;
	border-bottom: 2px solid #dddddd;
}

.commentBox {
	margin: 25px;
}

.replyTable td, th {
	border: none;
	text-align: center;
	padding: 8px;
}

.replyTable {
	margin-bottom: 60px;
}

.replyTable tr:last-child {
	border-bottom: 2px solid #dddddd;
}

.contents {
	width: 300px;
}
</style>
</head>
<body>
	<jsp:include page="../../../temp/header.jsp"></jsp:include>

	<div class="container-fluid box">

		<div class="row">
			<input type="hidden" name="idx" value="${param.num}">
			<table class="contentsTable">
				<tr>
					<td>TITLE</td>
				</tr>
				<tr>
					<td>${dto.title}</td>
				</tr>
				<tr>
					<td>WRITER</td>
				</tr>
				<tr>
					<td>${dto.writer}</td>
				</tr>
				<tr>
					<td>CONTENTS</td>
				</tr>
				<tr>
					<td>
						${dto.contents}
						<c:forEach items="${files}" var="fileDTO">
							<img src="../upload/${fileDTO.fname}">
							<br>
						</c:forEach> ${firstFile} <br>${activityDTO.contents}<br>
						<div class="btnBox">
							<a href="./${requestScope.board}List.do" class="btn btn-default">List</a>
							<a href="./${requestScope.board}Update.do?num=${dto.num}" class="btn btn-default">수정</a> 
							<a href="./${requestScope.board}Delete.do?num=${dto.num}" class="btn btn-default">삭제</a>
							<c:if test="${board ne 'notice'}">
								<a href="./${board}Replyform.do">Reply</a>
							</c:if>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>








<%@page import="com.bora.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../../../temp/header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row">
			<h1>board List</h1>
		</div>
		<form class="form-inline" action="./boardList.jsp">
			<div class="form-grop">
				<select class="form-control" id="sel1" name="kind">
					<option>Title</option>
					<option>Contents</option>
					<option>Writer</option>
				</select>
				<input type="text" class="form-control" id="search" placeholder="Enter search" name="search">
			</div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	<table class="table table-hover">
	<tr>
		<th>NO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>DATE</th>
		<th>HIT</th>
	</tr>
	<c:forEach items="list" var="boardDTO">
	<tr>
	<td>boardDTO.num</td>
	<td></td>
	</tr>
	</c:forEach>

</table>


	<%@include file="../../../temp/footer.jsp"%>
</body>
</html>
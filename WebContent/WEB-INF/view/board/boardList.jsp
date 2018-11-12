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
			<h1>board</h1>
		</div>
		<form class="form-inline" action="./boardList.jsp">
			<div class="form-grop">
				<select class="form-control" id="sel1" name="kind">
					<option>Title</option>
					<option>Contents</option>
					<option>Writer</option>
				</select>
				<input type="">

			</div>

		</form>
	</div>







	<%@include file="../../../temp/footer.jsp"%>
</body>
</html>
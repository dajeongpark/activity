<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../temp/bootStrap.jsp"/>
</head>
<body>
<jsp:include page="../../../temp/header.jsp"/>

<div class="container-fluid">
	<div class="row">
		<h2>로그인</h2>
		<form name="frm" action="./memberLogin.do" method="post" >
			<input type="hidden" value="f" name="idcheck" id="idcheck">
			    <div class="form-group">
			      <label for="id">ID:</label>
			      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
			    </div>
				<div class="form-group">
			      <label for="pw">PASSWORD:</label>
			      <input type="password" class="form-control" id="pw" placeholder="Enter pw" name="pw">
			    </div>
			    <div class="form-group">
			      <label for="kind">KIND:</label>
			      <p>admin: <input type="radio" id="kind" name="kind" value="admin"> user: <input type="radio" id="kind" name="kind" value="user" checked="checked"></p>
			    </div>

			    <p style="color: red">${message}</p><br>

			 <button type="submit" class="btn btn-default">LOGIN</button>
		</form>
	</div>
</div>

<jsp:include page="../../../temp/footer.jsp"/>
</body>
</html>
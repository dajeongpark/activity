<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"/>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

<div class="container-fluid">
	<div class="row">
		<h3>ID : ${member.id}</h3>
		<h3>NAME : ${member.name}</h3>
		<h3>BIRTH : ${member.birth}</h3>
		<h3>PHONE : ${member.phone}</h3>
		<h3>E-MAIL : ${member.email}</h3>
	</div>
	<div class="row">
		<a href="./memberUpdate.do">UPDATE</a>
		<a href="./memberDelete.do">DELETE</a>
	</div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
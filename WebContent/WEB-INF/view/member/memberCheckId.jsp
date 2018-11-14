<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"/>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			opener.document.frm.id.value='${param.id}';
			opener.document.frm.idCheck.value='s';
			self.close();
		});
	});
</script>
</head>
<body>
<h1>아이디 중복 체크</h1>
	<div>
		<c:if test="${result eq '0'}">
			<h3>${param.id} 사용 가능한 ID입니다.</h3>
			<button id="btn" class="btn btn-default">사용하기</button>
		</c:if>
		<c:if test="${result eq '1'}">
			<h3>${param.id} 사용 불가능한 ID입니다.</h3>
		</c:if>
	</div>
	
	<div>
		<form action="./memberCheckId.do">
			<input type="text" name="id">
			<button class="btn btn-default">중복확인</button>
		</form>
	</div>

</body>
</html>
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
		$("#btn1").click(function() {
			opener.document.frm.id.value='${param.id}';
			opener.document.frm.idCheck.value='s';
			self.close();
		});
		
	});
</script>
</head>
<body>
<h2>아이디 중복 체크</h2>
	<div>
		<c:if test="${result eq '0'}">
			<p style="color: green; font-size: 17px">${param.id} 사용 가능한 ID입니다.</p>
			<button id="btn1" class="btn btn-default">사용하기</button>
		</c:if>
		<c:if test="${result eq '1'}">
			<p style="color: red; font-size: 17px">${param.id} 사용 불가능한 ID입니다.</p>
		</c:if>
	</div>
	
	<div>
		<form id="frm" action="./memberCheckId.do" method="post">
				<input type="text" id="id" placeholder="Enter id" name="id">
				<button id="btn2" class="btn btn-default">중복확인</button>
		</form>
	</div>

</body>
</html>
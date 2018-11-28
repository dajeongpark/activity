<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../temp/bootStrap.jsp"></c:import>
<c:import url="../../css/sub.css"></c:import>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="mWt48p">
				<div class="left_box">
					<c:import url="../../temp/header.jsp"></c:import>
					<c:if test="${result eq '1'}">
						<h3>예약이 완료되었습니다</h3>
					</c:if>
					<c:if test="${result not '1'}">
						<h3>
							예약도중 문제가 발생했습니다.<br>다시 시도해주세요.
						</h3>
					</c:if>
					<c:import url="../../temp/footer.jsp"></c:import>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
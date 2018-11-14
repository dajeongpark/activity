<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 삭제 폼</title>
<jsp:include page="../../../temp/bootStrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../../temp/header.jsp"></jsp:include>

<form action="${board}Delete.jsp" name="deleteform" method="post">
<table border="1" summary="게시판 삭제">
<h2>Delete</h2>


</table>
</form>
<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>
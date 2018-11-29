<%@page import="com.bora.qna.QnaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    int num=Integer.parseInt(request.getParameter("num"));
    QnaDAO qnaDAO = new QnaDAO();
    int result=qnaDAO.delete(num); //해보고 안되면 삭제ㄱ
    	String str="삭제 실패하셨습니다.";
    if(result>0){
    	str = "삭제 완료하셨습니다.";
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 삭제</title>
<script type="text/javascript">
<%if (result>0){%>
alert('Delete Success');
location.href="./boardlist.jsp";
<%}else {%>
alert("Delete Fail");
history.go(-1);
<%}%>


</script>
<jsp:include page="../../../temp/bootStrap.jsp"/>
</head>
<body>
<jsp:include page="../../../temp/header.jsp"></jsp:include>

	<div class="container">
		<h1>${board}Delete</h1>

		<form class="form-horizontal" action="./${board}Delete.do" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="boardPw">pw check: </label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="boardPw" id="boardPw"
						placeholder="boardPw">
				</div>
			</div>

			<div class="form-group text-center">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">삭제</button>

				</div>
			</div>
		</form>
	</div>
	
<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>
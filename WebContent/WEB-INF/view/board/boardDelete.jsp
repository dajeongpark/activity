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
location.href="./boardList.jsp";
<%}else {%>
alert("Delete Fail");
history.go(-1);
<%}%>



</script>
<jsp:include page="../../../temp/bootStrap.jsp"/>
</head>
<body>
<jsp:include page="../../../temp/header.jsp"></jsp:include>

	
<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>
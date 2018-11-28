<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="replyTable">
	<c:forEach items="${comments}" var="replyDTO">
		<tr> <td>${replyDTO.writer}</td> <td>${replyDTO.contents}</td> <td>${replyDTO.reg_date}</td> </tr>
	</c:forEach>
</table>
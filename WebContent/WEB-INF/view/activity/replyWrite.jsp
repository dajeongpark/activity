<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="replyTable">
	<c:forEach items="${comments}" var="replyDTO">
		<tr>
			<td>${replyDTO.writer}</td>
			<td class="replyContents">${replyDTO.contents}</td>
			<td>${replyDTO.reg_date}</td> 
			
			<%-- <c:if test="${not empty member and '${activityDTO.writer}' eq '${member.id}'}"> --%>
			<%-- <c:if test="${'${replyDTO.writer}' eq '${member.id}'}"> --%>
				<td>
					<span class="glyphicon glyphicon-pencil replyUpdateBtn"></span>
					<span class="glyphicon glyphicon-remove replyDeleteBtn"></span>
				</td>
			<%-- </c:if> --%>
			
		</tr>
	</c:forEach>
</table>
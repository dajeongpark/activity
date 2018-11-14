<%@page import="com.bora.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>

</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>

	<div class="container-fluid">
		<div class="row">
			<h1><strong>QNA</strong></h1>
		</div>
		<div class="row">
			<div>
				<form class="form-inline" action="./${board}List.do">
					<div class="form-grop">
						<select class="form-control" id="sel1" name="kind">
							<option>Title</option>
							<option>Contents</option>
							<option>Writer</option>
							
						</select> 
						<input type="text" class="form-control" id="search" placeholder="Enter search" name="search">
					</div>
					
					<button type="submit" class="btn btn-primary active">Submit</button>
				</form>
				
			</div>
			
			<table class="table table-striped" summary="번호,제목,작성자,날짜,조회수"> 
				<tr>
					<th scope="col">NO</th>
					<th scope="col">TITLE</th>
					<th scope="col">WRITER</th>
					<th scope="col">DATE</th>
					<th scope="col">Hit</th>
				</tr>
				
				<c:forEach items="${board}" var="boardDTO">
					<tr>
					
						<td>${boardDTO.num}</td>
						<td>
						<a href="./${board}SelectOne.do?num=${boardDTO.num}">
						<c:catch>
							<c:forEach begin="1" end="${boardDTO.depth}">
								--
							</c:forEach>
						</c:catch> 
						${boardDTO.title}</a></td>
						<td>${boardDTO.writer}</td>
						<td>${boardDTO.reg_date}</td>
						<td>${boardDTO.hit}</td>
					</tr>
				</c:forEach>
			</table>
	</div>
	<div class="container-fluid">
		<div class="row">
		<ul class="pagination">	
			<li><a href="./${board}List.do?curPage=1"><span class="glyphicon glyphicon-backward"></span></a>
			
			<c:if test="${pager.curBlock at 1}">
				<li><a href="./${board}list.do?curPage=${pager.starNum-1}"><span class="glyphicon glyphicon-chevron-left"></span></a>
			</c:if>
			
			<c:forEach begin="${pager.starNum}" end="${pager.lastNum}" var="i">
				<li><a href="./${board}list.do?curPage=${i}">${i}</a>
			</c:forEach>
			
			<c:if test="${pager.curBlock it pager.totalBlock}">
				<li><a href="./${board}list.do?curPage=${pager.lastNum+1}"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</c:if>
			
			<li><a href="./${board}list.do?curPage=${pager.totalPage}"><span class="glyphicon glyphicon-forward"></span></a>
		
		</ul>
	</div>
</div>
	</div>
		<c:choose>
			<c:when test="${board eq 'notice'}">
				<c:if test="${noti empty member and member.kind eq 'T'}"> 
					<c:import url="../../../temp/writeButton.jsp"></c:import>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${not empty member}">
					<c:import url="../../../temp/writeButton.jsp"></c:import>	
				</c:if>
			</c:otherwise>
		</c:choose>

<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</html>
<%@page import="java.util.List"%>
<%@page import="com.bora.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
	/* List<BoardDTO> ar = (List<BoardDTO>)request.getAttribute("list"); */
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<%@include file="../../../temp/bootStrap.jsp" %>
<script type="text/javascript"></script>
<style type="text/css">
img{
	position: relative;
	opacity: 0.8;
	width: 65%;
	height: 243px;	
}
h1{
	position: absolute;
	top: 150px;
	left: 900px;
	font-size-adjust: small;
	opacity: 0.7;
	text-shadow: 1px 1px 2px black;
	
}
strong{
	position: absolute;
	color: white;
	font-size-adjust: none;	
}

</style>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

	<div class="container-fluid">
		<div id="wrap" align="center" class="image">
			<!-- @ -->
			<img alt="Qna images" src="../images/QNA1.png">
			<div class="text">
				<h1>
					BORACAY&nbsp;&nbsp;<strong>Q&amp;A</strong>
				</h1>
			</div>
		</div>
		<div class="boardList">
			<table border="1" summary="">
				<caption>&nbsp;&nbsp;&nbsp;&nbsp;</caption>
			</table>

			<div class="row">
				<div>
					<form class="form-inline" action="./${board}List.do">
						<div class="form-group">
							<select class="form-control" id="sel1" name="kind">
								<option>Title</option>
								<option>Contents</option>
								<option>Writer</option>
							</select> <input type="text" class="form-control" id="search"
								placeholder="Enter search" name="search">
							<button type="submit" class="btn btn-default">Search</button>
						</div>

					</form>
				</div>
				<table class="table table-hover" summary="번호,제목,작성자,작성한 날짜, 조회수">
					<tr>
						<td>NUM</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;TITLE&nbsp;</td>
						<td>WRITER</td>
						<td>DATE</td>
						<td>HIT</td>
					</tr>
					<c:forEach items="${list}" var="boardDTO">
						<tr>
							<td>${boardDTO.num}</td>
							<td><a href="./${board}SelectOne.do?num=${boardDTO.num}">
									<c:catch>
										<c:forEach begin="1" end="${boardDTO.depth}">
							--
						</c:forEach>
									</c:catch> ${boardDTO.title}
							</a></td>
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
						<li><a href="./${board}List.do?curPage=1"><span
								class="glyphicon glyphicon-backward"></span></a></li>

						<c:if test="${pager.curBlock gt 1}">
							<li><a href="./${board}List.do?curPage=${pager.startNum-1}"><span
									class="glyphicon glyphicon-chevron-left"></span></a></li>
						</c:if>


						<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
							var="i">
							<li><a href="./${board}List.do?curPage=${i}">${i}</a></li>
						</c:forEach>

						<c:if test="${pager.curBlock lt pager.totalBlock}">
							<li><a href="./${board}List.do?curPage=${pager.lastNum+1}"><span
									class="glyphicon glyphicon-chevron-right"></span></a></li>
						</c:if>
						<li><a href="./${board}List.do?curPage=${pager.totalPage}"><span
								class="glyphicon glyphicon-forward"></span></a></li>
					</ul>
				</div>
			</div>

			<c:choose>
				<c:when test="${board eq 'notice'}">
					<c:if test="${not empty member and member.kind eq 'T'}">
						<c:import url="../../../temp/writeButton.jsp"></c:import>
					</c:if>

				</c:when>
				<c:otherwise>
					<c:if test="${not empty member}">
						<c:import url="../../../temp/writeButton.jsp"></c:import>
					</c:if>
				</c:otherwise>

			</c:choose>

		</div>
	</div>
	<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>
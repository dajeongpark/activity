<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
			<a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp"></a>
			
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">

			<ul class="nav navbar-nav navbar-center">
				<li><a href="${pageContext.request.contextPath}/notice/noticeList.do">NOTICE</a></li>
	        	<li><a href="${pageContext.request.contextPath}/activity/activityList.do">ACTIVITY</a></li>
				<li><a href="#portfolio">QNA</a></li>
			</ul>
			
			<c:choose>
				<c:when test="${not empty member}">
					<ul class="nav navbar-nav navbar-right">
						<li><a
							href="${pageContext.request.contextPath}/member/memberMypage.do"><span
								class="glyphicon glyphicon-user"></span> MyPage</a></li>
						<li><a
							href="${pageContext.request.contextPath}/member/memberLogout.do"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav navbar-right">
						<li><a
							href="${pageContext.request.contextPath}/member/memberJoin.do"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a
							href="${pageContext.request.contextPath}/member/memberLogin.do"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</ul>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</nav>




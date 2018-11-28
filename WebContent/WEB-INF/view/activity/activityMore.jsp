<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${list}" var="activityDTO">
	<c:if test="${activityDTO.area eq 's'}">
		<li class="areas2 s" id="s">
			<div class="imageBox">
				<img src="../upload/test.png" class="image">
				<div class="overlay" onclick="location.href='./activitySelectOne.do?num=${activityDTO.num}'" style="cursor:pointer;">
					<span class="areaBox">서울</span>
					<span><p></p>${activityDTO.title}<p></p></span>
					<span class="anchor">
						더보기 <span class="glyphicon glyphicon-triangle-right"></span>
					</span>
				</div>
			</div>
		</li>
	</c:if>
	<c:if test="${activityDTO.area eq 'gg'}">
		<li class="areas2 gg" id="gg">
			<div class="imageBox">
				<img src="../upload/test.png" class="image">
				<div class="overlay" onclick="location.href='./activitySelectOne.do?num=${activityDTO.num}'" style="cursor:pointer;">
					<span class="areaBox">경기</span>
					<span><p></p>${activityDTO.title}<p></p></span>
					<span class="anchor">
						더보기<span class="glyphicon glyphicon-triangle-right"></span>
					</span>
				</div>
			</div>
		</li>
	</c:if>
	<c:if test="${activityDTO.area eq 'gw'}">
		<li class="areas2 gw" id="gw">
			<div class="imageBox">
				<img src="../upload/test.png" class="image">
				<div class="overlay" onclick="location.href='./activitySelectOne.do?num=${activityDTO.num}'" style="cursor:pointer;">
					<span class="areaBox">강원</span>
					<span><p></p>${activityDTO.title}<p></p></span>
					<span class="anchor">
						더보기<span class="glyphicon glyphicon-triangle-right"></span>
					</span>
				</div>
			</div>
		</li>
	</c:if>
	<c:if test="${activityDTO.area eq 'e'}">
		<li class="areas2 e" id="e">
			<div class="imageBox">
				<img src="../upload/test.png" class="image">
				<div class="overlay" onclick="location.href='./activitySelectOne.do?num=${activityDTO.num}'" style="cursor:pointer;">
					<span class="areaBox">그 외 지역</span>
					<span><p></p>${activityDTO.title}<p></p></span>
					<span class="anchor">
						더보기<span class="glyphicon glyphicon-triangle-right"></span>
					</span>
				</div>
			</div>
		</li>
	</c:if>
</c:forEach>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
<style>
	.areas {
		list-style-type: none;
		margin: 0 auto;
		/* padding: 0; */
		overflow: hidden;
		background-color: lightblue;
	}
	.areas li {
		float: left;
	}
	.areas > li > a {
		display: block;
		color: white;
		text-align: center;
		padding: 20px 150px;
		text-decoration: none;
	}
	.areas li a:hover {
		background-color: #5CD1E5;
	}
	
	.images li {
		display: inline-block;
		padding: 20px;
		margin: 0 auto;
		margin-top: 30px;
		
	}
	.images {
		width: 100%;
		display: grid;
		margin: 0 auto;
		grid-template-columns: 500px 500px 500px;
		grid-gap: 30px;
	}
	
	.images li a:hover {
		opacity: 1;
	}
	.cover {
		color: white;
		font-size: 20px;
		position: absolute;
		top: 50%;
		left: 50%;
	}
	.btnBox {
		width: 50px;
		margin: auto;
	}

	
</style>

<script type="text/javascript">
	$(document).ready(function(){
		$(".areas1").click(function(){
			$(".areas2").hide();
			var a = $(this).attr('title');
			$("."+a).show(); //id("#"+a)로 show()하면 한 개만 뜸
		});
		$(".areas0").click(function(){
			$(".areas2").show();
		});
	});
</script>

</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>
<div class="container-fluid">
	<div class="row">
		
		<div class="tab">
			<ul class="areas">
				<li class="areas0" id="all_tab" title="all"><a href="#">전체보기</a></li>
				<li class="areas1" id="s_tab" title="s"><a href="#">서울</a></li>
				<li class="areas1" id="gg_tab" title="gg"><a href="#">경기</a></li>
				<li class="areas1" id="gw_tab" title="gw"><a href="#">강원</a></li>
				<li class="areas1" id="e_tab" title="e"><a href="#">그 외 지역</a></li>
			</ul>
		</div>
		
		<form class="form-inline">
			<div class="activityList">
				
				<ul class="images" style="list-style-type:none">
					<c:forEach items="${list}" var="activityDTO">
						<c:if test="${activityDTO.area eq 's'}">
							<li class="areas2 s" id="s"><a href="./activitySelectOne.do?num=${activityDTO.num}">${activityDTO.title}</a></li> <!-- title을 사진으로 바꿔야 함 -->
						</c:if>
						<c:if test="${activityDTO.area eq 'gg'}">
							<li class="areas2 gg" id="gg"><a href="./activitySelectOne.do?num=${activityDTO.num}">${activityDTO.title}</a></li> <!-- title을 사진으로 바꿔야 함 -->
						</c:if>
						<c:if test="${activityDTO.area eq 'gw'}">
							<li class="areas2 gw" id="gw"><a href="./activitySelectOne.do?num=${activityDTO.num}">${activityDTO.title}</a></li> <!-- title을 사진으로 바꿔야 함 -->
						</c:if>
						<c:if test="${activityDTO.area eq 'e'}">
							<li class="areas2 e" id="e"><a href="./activitySelectOne.do?num=${activityDTO.num}">${activityDTO.title}</a></li> <!-- title을 사진으로 바꿔야 함 -->
						</c:if>
					</c:forEach>
				</ul>
				
			</div>
		</form>
		
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="btnBox">
		<%-- <c:if test="${not empty member and member.kind eq '관리자'}"> --%>
			<a href="./activityWrite.do" class="btn btn-primary">WRITE</a>
		<%-- </c:if> --%>
		</div>
	</div>
</div>

<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
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
		display: grid;
		margin: 0 auto;
		grid-template-columns: 500px 500px 500px;
		grid-gap: 30px;
	}
	.images > image {
		padding: 20px;
		font-size: 150%;
	}
	
	.cover {
		position: absolute;
		top: 0;
		bottom: 0;
		right: 0;
		left: 0;
		height: 100%;
		width: 100%;
		opacity: 0;
		transition: .5s ease;
		background-color: black;
	}
	.image {
		opacity: 1;
	}
	.category {
		color: white;
		font-size: 20px;
		position: absolute;
		top: 50%;
		left: 50%;
		-webkit-transform: translate(-50%,-50%);
		-m
	}
	
	
	
	
	
	
	
</style>
</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>
<div class="container-fluid">
	<div class="row">
	
		<div class="tab">
			<ul class="areas">
				<li><a href="#">서울</a></li>
				<li><a href="#">경기</a></li>
				<li><a href="#">강원</a></li>
				<li><a href="#">그 외 지역</a></li>
			</ul>
		</div>
		
		<form class="form-inline">
			<div class="activityList">
				<ul class="images" style="list-style-type:none">
					<li class="image"><a href="#"><img src="https://dimgcdn.ybtour.co.kr/TN/88/88becd05117af13807ed42888469bc77.tn.410x280.jpg"></a>
						<div class="cover">
							<div class="category">area</div>
						</div>
						
						<!-- <span class="black" style="display:none; opacity: 0.8;"></span>
						<span class="cover" style="display:none; opacity: 1;">
							<span class="">area</span>
							<span class="name">surfing</span>
							<span class="anchor">more</span>
						</span> -->
					</li>
					<li class="image"><a href="#"><img src="https://dimgcdn.ybtour.co.kr/TN/c7/c73afdcd85db7b06d627dbc5e004e6f7.tn.410x280.jpg"></a></li>
					<li class="image"><a href="#"><img src="https://dimgcdn.ybtour.co.kr/TN/27/271380b653a4ff7e7634fe63f4bdeb78.tn.410x280.jpg"></a></li>
					<li class="image"><a href="#"><img src="../../../images/surf04.jpg"></a></li>
					<li class="image"><a href="#"><img src="../../../images/surf05.jpg"></a></li>
					<li class="image"><a href="#"><img src="../../../images/surf06.jpg"></a></li>
					<li class="image"><a href="#"><img src="../../../images/surf07.jpg"></a></li>
					<li class="image"><a href="#"><img src="../../../images/surf08.jpg"></a></li>
					<li class="image"><a href="#"><img src="../../../images/surf09.jpg"></a></li>
				</ul>
			</div>
		</form>
		
	</div>
</div>
<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
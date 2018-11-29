<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="../../../css/reset.css"> -->
<c:import url="../../../temp/bootStrap.jsp"></c:import>
<style>
/* *{margin:0; padding:0;} */

	.container-fluid {
   	  width: 100%;
      padding: 60px 50px;
  	}
	.areas {
		list-style-type: none;
		margin: 1% auto;
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
		display: inline;
		margin: 0 auto;
		/* margin-top: 30px; */
		
	}
	.images {
		width: 100%;
		height: 100%;
		margin: 2% auto;
		/* display: grid;
		grid-template-columns: 500px 500px 500px;
		grid-gap: 30px; */
	}
	
	
	.images li a:hover {
		opacity: 1;
	}
	
	
	.moreBtnBox {
		display: block;
		width: 150px;
		height: 80px;
		margin: 30px auto;
	}
	.writeBtnBox{
		display: block;
		width: 100px;
		height: 80px;
		margin-left: 7%;
		margin-top: 30px;
		float: left;
	}
	
	.imageBox {
	position: relative;
	width: 100%;
	height: 100%;
	max-width: 33%;
	max-height: 350px;
	overflow: hidden;
	float: left;
	/* padding: 0.4%; */
	}

	.image {
		display: block;
		width: inherit;
		height: inherit;
	}
	
	.overlay {
		position: absolute; 
		bottom: 0; 
		background: rgb(0, 0, 0);
		background: rgba(0, 0, 0, 0.8); /* Black see-through */
		color: white; 
		width: 100%;
		height: 100%;
		transition: .5s ease;
		opacity:0;
		font-size: 20px;
		text-align: center;
		cursor: pointer;
	}
	
	.imageBox:hover .overlay {
		opacity: 0.9;
	}
	
	.activityList {
		width: 100%;
		height: 100%;
		margin: 0 auto;
	}
	
	.glyphicon {
		size: 5px;
	}
	
	.areaBox {
		display: inline-block;
		width: 60px;
		height: 20px;
		border: 1px solid #5b5b5b;
		color: #fff;
		font-size: 12px;
		line-height: 18px;
		margin-top: 15%;
	}
	.titleBox {
		display: block;
		width: 100%;
		padding: 15px 0 29px 0;
		color: #f0f0f0;
		font-size: 21px;
		font-weight: lighter;
		text-align: center;
		line-height: 1.25em;
		margin-top: 40%;
	}
	.anchor {
		display: inline-block;
		padding: 0 2px;
		border-bottom: 1px solid #868686;
		font-size: 12px;
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
		
		var curPage=2;
		$("#more").click(function() {
			$.get("./activityMore.do?curPage="+curPage, function(data) {
				$("#images").append(data);
			});
			curPage++;
		});
		
		/* $(window).scroll(function() {
		    if($(window).scrollTop() == $(document).height() - $(window).height()) {
		           // ajax call get data from server and append to the div
		    }
		}); */
		
		
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
				
				<ul class="images" id="images" style="list-style-type:none">
					<c:forEach items="${list}" var="activityDTO" varStatus="i">
						<c:if test="${activityDTO.area eq 's'}">
							<li class="areas2 s" id="s">
								<div class="imageBox">
									<img src="../upload/${files[i.index].fname}" class="image">
									<div class="overlay" onclick="location.href='./activitySelectOne.do?num=${activityDTO.num}'">
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
									<img src="../upload/${files[i.index].fname}" class="image">
									<div class="overlay" onclick="location.href='./activitySelectOne.do?num=${activityDTO.num}'">
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
									<img src="../upload/${files[i.index].fname}" class="image">
									<div class="overlay" onclick="location.href='./activitySelectOne.do?num=${activityDTO.num}'">
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
									<img src="../upload/${files[i.index].fname}" class="image">
									<div class="overlay" onclick="location.href='./activitySelectOne.do?num=${activityDTO.num}'">
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
				</ul>
				
			</div>
		</form>
		
	</div>
</div>


	<div class="container-fluid">
		<div class="row">
		
		
		<c:if test="${not empty member and member.kind eq 'admin'}">
			<c:import url="../../../temp/writeButton.jsp"></c:import>
		</c:if>
		
		<div class="moreBtnBox">
			<button id="more" class="btn btn-primary">더보기</button>
		</div>
			
			
		</div>
	</div>
	



<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
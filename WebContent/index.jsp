<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="./temp/bootStrap.jsp"></jsp:include>
<style type="text/css">
	.md {
		width: 100%;
		height: 630px;
		color: white;
	}
	
	.name {
		display: block;
	    margin: 0 0 13px;
	    font-size: 20px;
	    line-height: 1.5;
	    font-weight: bold;
	    white-space: nowrap;
	    text-overflow: ellipsis;
	    word-break: break-all;
	    word-wrap: break-word;
	    overflow: hidden;		
	}
	
	.price {
		display: block;
    	font-size: 14px;
	}
	
	.img {
		transform: scale(1);
  		-webkit-transform: scale(1);
  		-moz-transform: scale(1);
  		-ms-transform: scale(1);
  		-o-transform: scale(1);
  		transition: all 0.3s ease-in-out;   /* 부드러운 모션을 위해 추가*/
	}
	
	.img:hover {
  		transform: scale(1.2);
  		-webkit-transform: scale(1.2);
  		-moz-transform: scale(1.2);
  		-ms-transform: scale(1.2);
  		-o-transform: scale(1.2);
	}
	
	.md_1 {
		width: 536px;
		height: 630px;
		float: left;
		position: relative;
		overflow:hidden;
	}
	
	.md_1 > .mdinfo {
		position: absolute;
   		left: 0;
    	bottom: 0;
    	width: 100%;
    	height: 101px;
    	padding: 20px;
	}
	
	.md_2 {
		width: 534px;
		height: 300px;
		float: right;
		position: relative;
		overflow:hidden;
	}
	
	.md_2 > .mdinfo {
		position: absolute;
   		left: 0;
    	bottom: 0;
    	width: 100%;
    	height: 101px;
    	padding: 20px;
	}
	
	.md_3 {
		width: 252px;
		height: 300px;
		margin-left: 30px;
		margin-top: 30px;
		float: left;
		position: relative;
		overflow:hidden;
	}
	
	.md_3 > .mdinfo {
		position: absolute;
   		left: 0;
    	bottom: 0;
    	width: 100%;
    	height: 99px;
    	padding: 20px;
	}
	
	.md_4 {
		width: 252px;
		height: 300px;
		margin-top: 30px;
		float: right;
		position: relative;
		overflow:hidden;
	}
	
	.md_4 > .mdinfo {
		position: absolute;
   		left: 0;
    	bottom: 0;
    	width: 100%;
    	height: 99px;
    	padding: 20px;
	}
</style>
</head>
<body>
<jsp:include page="./temp/header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
	  <div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <!-- <li data-target="#myCarousel" data-slide-to="2"></li> -->
	    </ol>
	
	    <!-- Wrapper for slides -->
	    <div class="carousel-inner">
	
	      <div class="item active">
	        <img src="./images/image1.jpg" alt="Los Angeles" style="width:100%; height: 500px;">
	        <div class="carousel-caption">
	          <h3>Los Angeles</h3>
	          <p>LA is always so much fun!</p>
	        </div>
	      </div>
	
	      <div class="item">
	        <img src="./images/image2.jpg" alt="Chicago" style="width:100%; height: 500px;">
	        <div class="carousel-caption">
	          <h3>Chicago</h3>
	          <p>Thank you, Chicago!</p>
	        </div>
	      </div>
	    
<!--  	      <div class="item">
	        <img src="ny.jpg" alt="New York" style="width:100%;">
	        <div class="carousel-caption">
	          <h3>New York</h3>
	          <p>We love the Big Apple!</p>
	        </div>
	      </div> -->
	    </div>
	
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right"></span>
	      <span class="sr-only">Next</span>
	    </a>
	  </div>
	</div><br>
	
	<div class="row">
		<h2>MD추천</h2>
		<div class="md">
			<div class="md_1">
				<img class="img" alt="" src="./images/md1.jpg">
				<div class="mdinfo">
					<span class="name">아찔한 원주 소금산 출렁다리와 제천 힐링 여행</span>
					<span class="price">22,900원~</span>
				</div>
			</div>
			<div class="md_2">
				<img class="img" alt="" src="./images/md2.png">
				<div class="mdinfo">
					<span class="name">♥ KTX ♥ 장사도 카멜리아+외도 보타니아+통영 케이블카 ♥</span>
					<span class="price">279,000원~</span>
				</div>
			</div>	
			<div class="md_3">
				<img class="img" alt="" src="./images/md3.png">
				<div class="mdinfo">
					<span class="name">명량! 한려수도(통영~남해~여수) 완!전!일!주!</span>
					<span class="price">334,000원~</span>
				</div>
			</div>
			<div class="md_4">
				<img class="img" alt="" src="./images/md4.png">
				<div class="mdinfo">
					<span class="name">천혜의 비경 백령도 (1박2일)</span>
					<span class="price">145,000원~</span>
				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="./temp/footer.jsp"></jsp:include>

</body>
</html>

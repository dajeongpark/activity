<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>
	
<div class="container-fluid box">
	<div class="row">
		<form id="frm" action="./activityWrite.do" method="post" enctype="multipart/form-data">
		
			<div class="form-group">
				<label for="title">TITLE: </label>
				<input type="text" class="form-control" id="title" placeholder="Enter Title : title(area)" name="title">
			</div>
			
			<div class="form-group dropdown">
				<label for="area">AREA: </label>
				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
					<div id="selectArea">
						지역 선택
						<span class="caret"></span>
					</div>
					<div class="areas s">
						서울
						<span class="caret"></span>
					</div>
					<div class="areas gg">
						경기
						<span class="caret"></span>
					</div>
					<div class="areas gw">
						강원
						<span class="caret"></span>
					</div>
					<div class="areas e">
						그 외 지역
						<span class="caret"></span>
					</div>
				</button>
				
				<ul class="dropdown-menu">
					<li><a tabindex="-1" href="#" id="s">서울</a></li>
					<li><a tabindex="-1" href="#" id="gg">경기</a></li>
					<li><a tabindex="-1" href="#" id="gw">강원</a></li>
					<li><a tabindex="-1" href="#" id="e">그 외 지역</a></li>
			    </ul>
			    
				<input type="hidden" value="" id="area" name="area">				
				
				<!-- <select class="selectpicker">
					<option>서울</option>
					<option>경기</option>
					<option>강원</option>
					<option>그 외 지역</option>
				</select> -->
			</div>
			
			<div class="form-group">
				<label for="price">PRICE: </label>
				<input type="text" class="form-control" id="price" placeholder="Enter Price" name="price">
			</div>
			
			<div class="form-group">
				<label for="contents">CONTENTS: </label>
				<textarea rows="25" cols="" class="form-control" id="contents" placeholder="Enter Contents" name="contents"></textarea>
			</div>
			
			<input type="button" id="add" value="File Add">				
			<div class="files" id="file">
				
			</div>
			
			<div class="btnBox">
				<input type="button" id="writeBtn" value="Write" class="btn btn-default">
			</div>
			
		</form>
	</div>
</div>
	
<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
<style type="text/css">
	.box {
		margin: 30px;
	}
	.btnBox {
		margin-top: 30px;
	}
	.del {
		color: red;
		cursor: pointer;
	}
</style>
<script type="text/javascript">
	
	$(function() {
		
		var count=1;
		var index=0;
		$("#add").click(function() {
			if(count<6){
				var r = '<div class="form-group" id="f'+index+'">';
				r = r+'<label for="file">File:</label>';
				r = r+'<input type="file" class="form-control" id="file" name="f'+index+'1">';
				r = r+'<span class="remove" title="'+index+'">X</span>';
				r = r+'</div>';
				var n=5;
					$("#file").append(r);
				count++;
				index++;
			}else{
				alert("파일 5개까지 업로드 가능");
			}
		});
		
		
		$(".del").click(function() {
			// /file/fileDelete.do
			var fnum = $(this).attr("id");
			var fname = $(this).attr("title");
			//alert
			$.post("../file/fileDelete.do", {fnum:fnum, fname:fname}, function(data) {
				data = data.trim();
				if(data=='1'){
					alert("File Delete Success");
					$("#"+fnum).parent().remove();
				}else{
					alert("File Delete Fail");
				}
			});
		});
		
		
		
		$(".areas").hide();
		
		$("#s").click(function() {
			$("#selectArea").hide();
			$(".areas").hide();	
			$(".s").show();
			$("#area").val("s");
		});
		$("#gg").click(function() {
			$("#selectArea").hide();
			$(".areas").hide();	
			$(".gg").show();
			$("#area").val("gg");
		});
		$("#gw").click(function() {
			$("#selectArea").hide();
			$(".areas").hide();	
			$(".gw").show();
			$("#area").val("gw");
		});
		$("#e").click(function() {
			$("#selectArea").hide();
			$(".areas").hide();	
			$(".e").show();
			$("#area").val("e");
		});
		
	});
	
</script>
</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>
	
<div class="container-fluid box">
	<div class="row">
		<form id="frm" action="./activityUpdate.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${activityDTO.num}">
			<div class="form-group">
				<label for="title">TITLE: </label>
				<input type="text" class="form-control" id="title" placeholder="Enter Title : title(area)" name="title" value="${activityDTO.title}">
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
			    
				<input type="hidden" value="${activityDTO.area}" id="area" name="area">				
				
			</div>
			
			<div class="form-group">
				<label for="onePrice">PRICE(per person): </label>
				<input type="text" class="form-control" id="onePrice" placeholder="Enter Price(per person)" name="onePrice" value="${activityDTO.onePrice}">
			</div>
			
			<div class="form-group">
				<label for="contents">CONTENTS: </label>
				<textarea rows="25" cols="" class="form-control" id="contents" placeholder="Enter Contents" name="contents">${activityDTO.contents}</textarea>
			</div>
			
			<input type="button" id="add" value="File Add">				
			<div class="files" id="file">
				
			</div>
			
			<c:forEach items="${files}" var="file" varStatus="i">
				<div class="form-group" id="p${file.fnum}">
					<span>${file.oname}</span>
					<span class="del" id="${file.fnum}" title="${file.fname}">X</span>
				</div>
			</c:forEach>
			
			<div class="btnBox">
				<button type="submit" id="updateBtn" class="btn btn-default">Update</button>
			</div>
			
		</form>
	</div>
</div>
	
<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
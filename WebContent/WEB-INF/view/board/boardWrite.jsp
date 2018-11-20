
<%@page import="java.util.ArrayList"%>
<%@page import="com.bora.notice.NoticeDTO"%>
<%@page import="com.bora.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String board = (String)request.getAttribute("board");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>Bootstrap Theme Company Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="../../../temp/bootStrap.jsp"></jsp:include>
<script src="https://cdn.ckeditor.com/4.10.1/standard/ckeditor.js">
	CKEDITOR.replace("contents");
</script>

<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			var title = $("#title").val();
			if(title!=''){
				$("#frm").submit();
			}else{
				alert("Title을 입력하세요");
			}
		});
		var count=1;
		var index=0;
		$('#add').click(function() {
			if(count<6){
				var r = '<div class="form-group" id="f'+index+">';
				r = r+'<label for="file">FILE:</label>';
				r = r+'<input type="file" class="form-control" id="file" name="f'+index+'">';
				r = r+'<span class="remove" title="'+index+'">X</span>';
				r = r+'</div>';
				$('#file').append(r);
				count++;
				index++;
			}else {
				alert("파일은 최대 5개까지 가능합니다")
			}
		});
		$("#file").on("click", ".remove", function() {
			var t = $(this).attr("title");
			$('#f'+t).remove();
			count--;
		});
	});
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<jsp:include page="../../../temp/header.jsp"></jsp:include>
<%-- <%k
	MemberDTO mdto = (MemberDTO)session.getAttribute("member");
%> --%>
<div class="container-fluid">
	<div class="row">
	  <form id="frm" action="./${board}Write.do" method="post" enctype="multipart/form-data"> 
	    <div class="form-group">
	      <label for="title">TITLE:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    <div class="form-group">
	      <label for="writer">WRITER:</label>
	      <input type="text" value="${member.id}" readonly="readonly" class="form-control" id="writer" placeholder="Enter writer" name="writer">
	    </div>
	    <div class="form-group">
	      <label for="contents">CONTENTS:</label>
	      <textarea rows="10" cols="" class="form-control" name="contents"></textarea>
	    </div>
<!-- 	    <div class="form-group">
	      <label for="file">FILE:</label>
	      <input type="file" class="form-control" id="file" name="f1">
	    </div> -->
	   	<input type="button" value="File add">
	   	<div class="files" id="file">
	   		
	   	</div>
	    <button type="button" id="btn" class="btn btn-default">WRITER</button>
 	 </form>
	</div>
</div>

<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>
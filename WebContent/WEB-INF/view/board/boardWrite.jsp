<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    String board =(String)request.getAttribute("board");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
<script src="https://cdn.ckeditor.com/4.10.1/standard/ckeditor.js">
	CKEDITOR.replace("contents");
</script>
<script type="text/javascript">
	$(function() {
		
		CKEDITOR.replace("contents");
		
		$("#btn").click(function() {
			var title = $("#title").val();
			if(title != ''){
				$("#frm").submit();
			}else {
				alert("Title을 입력");
			}
		});
		var count=1;
		var index=0;
		$('#add').click(function() {
			if(count<3){
				var r = '<div class="form-group" id="f'+index+">';
				r = r+'<label for="file">FILE:</label>';
				r = r+'<input type="file" class="form-control" id="file" name="f'+index+'">';
				r = r+'<span class="remove" title="'+index+'">X</span>';
				r = r+'</div>';
				$('#file').append(r);
				count++;
				index++;
			}else {
				alert("파일은 2개까지 가능합니다.")
			}
	
		$("#file").on("click", ".remove", function() {
			var t = $(this).attr("title");
			$("#f"+t).remove();
			count--;
		});
	});
		
</script>	

</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>
<div class="container-fluid">
 <div class="row">
	<form action="./${board}write.do" method="Post" enctype="multipart/form-data">
		
		<div class="form-grop">
			<label class="title">title: </label>
			<input type="text" class="form-control" id="title" placeholder="Enter title" name="title"> 
		</div>
		
		<div class="form-grop">
			<label class="writer">writer :</label>
			<input type="text" value="${member.id}" class="form-control" id="writer" placeholder="Enter writer" name="writer">
		</div>
				
		<div class="form-grop">
			<label class="contents">contents: </label>
			<input type="text" class="form-control" id="contents" placeholder="Enter contents" name="contents"> 
		</div>
	
		 
		<input type="button" value="File add">
		<div class="files" id="file"></div>
		<button type="button" id="btn" class="btn btn-default">WRITER</button>
	</form>
	</div>
</div>


<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>
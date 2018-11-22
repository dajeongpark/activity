<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
<script type="text/javascript">
$(function(){
	$(".del").click(function(){
		var fum=$(this).attr("id");
		var fname=$(this).attr("title");
		$.post("../file/fileDelete.do",{fnum:funum, fname:fname}, function(){
			data = data.trim();
			if(data=='1'){
				alert("Success");
				$('#p'+fnum).remove();
			}else{
				alert('Fail');
			}
		});
	});
});
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<c:import url="../../../temp/header.jsp"></c:import>

<div class="container-fluid">
	<div id="wrap" align="center">
	 <div class="row"> 
	 	<h1>${board}Update</h1>
	 </div>
	 
	 <div class="row">
	 	<form action="./${board}Update.do" method="post" enctype="multipart/form-data">
	 		<div class="form-group">
	 			<label for="title">Title :</label>
	 			<input type="text" value="${boardDTO.title}" class="form-control" id="title" placeholder="Enter Title" name="title">
	 		</div>
	 		
	 		<div class="form-group">
	 			<label for="writer">Writer :</label>
	 			<input type="text" class="form-control" value="${boardDTO.writer}" id="writer" placeholder="Enter Writer" name="writer">
	 		</div>
	 		
		 	<div class="form-group">
	 			<label for="contents">Contents:</label>
	 		<textarea rows="15" cols="" class="form-control" name="contents">${boardDTO.contents}</textarea>
	 		</div>
	 		
	 	<c:forEach items="${files}" var="file" varStatus="i">
	 		<div class="form-group" id="p${file.fnum}">
				<span>${file.oname}</span>	 		
	 			<span class="del" id="${file.fnum}" title="${file.fname}">X</span>
	 		</div>
	 	</c:forEach>
	 	
	<!--  <form action="./memberLogin.do">비밀번호도 추가했는데 안되면 뺴기
        Password: <input type="password" name="pwd" maxlength="8"> </form>-->
	 
	 <button type="submit" class="btn btn-default">upload</button>
	 </form>
	 </div>
	</div>
</div>


<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
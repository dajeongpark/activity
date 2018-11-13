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
function move(url){
	location.href=url;
}
function boardUpdateCheck(){
	var form=document.BoardUpdateForm;
	return true;
}

</script>
</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>

	<div class="container-fluid">
	 <div class="row">
	 	<h1>${board}UPDATE</h1>
	 </div>
	 <div class="row">
	 	<form action="./${board}Update.do" method="post" enctype="multipart/form-data">
	 		<div class="form-group">
	 			<label for="title">Title :</label>
	 			<input type="text" value="${boardDTO.title}" class="form-control" id="title" placeholder="Enter Title" name="title">
	 		</div>
	 		
	 		<div class="form-group">
	 			<label for="writer">Writer :</label>
	 			<input type="text" class="form-control" disabled="disabled" value="${boardDTO.writer}" id="writer" placeholder="Enter Writer" name="writer">
	 		</div>
	 		
		 	<div class="form-group">
	 			<label for="contents">Contents:</label>
	 		<textarea rows="25" cols="" class="form-control" name="contents">${boardDTO.contents}</textarea>
	 		</div>
	 	
	 	<c:forEach items="${files}" var="file" varStatus="i">
	 		<div class="form-group" id="p${file.fnum}">
	 			<span>${file.oname}</span>
	 			<span class="del" id="${file.fnum}" title="${file.fname}">X</span>
	 		</div>
	 	</c:forEach>
	 	
	 	<button type="submit" class="btn btn-default">목록으로</button>
	 	</form>
	 
	 </div>
	 
	 
	</div>



<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
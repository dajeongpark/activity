<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>

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
			<input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
		</div>
				
		<div class="form-grop">
			<label class="contents">contents: </label>
			<input type="text" class="form-control" id="contents" placeholder="Enter contents" name="contents">
		</div>

		<input type="button" class="btn btn-primary">
		</form>


	</div>
</div>


<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>

<%@page import="java.util.ArrayList"%>
<%@page import="com.bora.notice.NoticeDTO"%>
<%@page import="com.bora.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>Bootstrap Theme Company Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<c:import url="../../../temp/bootstrap.jsp"/>
<script type="text/javascript">
	$(function() {
		$(".del").click(function() {
			var fnum = $(this).attr("id");
			var fname = $(this).attr("title");
			$post("../file/fileDelete.do",{fnum:fnum, fname:fname}, function() {
				data = data.trim();
				if(data=='1'){
					alert("Success");
					$('#p'+fnum).remove();
				}else{
					alert("Fail");
				}
			});
		});
	});
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<c:import url="../../../temp/header.jsp"/>

<div class="container-fluid">
  <div class="row">
  	<h1>${board} Update</h1>
  </div>
	<div class="row">
	  <form action="./${board}Update.do" method="post" enctype="multipart/form-data"> 
	  	<input type="hidden" name="num" value="${dto.num}">
	    <div class="form-group">
	      <label for="title">TITLE:</label>
	      <input type="text" class="form-control" value="${dto.title}" id="title" placeholder="Enter title" name="title">
	    </div>
	    <div class="form-group">
	      <label for="writer">WRITER:</label>
	      <input type="text" class="form-control" disabled="disabled" value="${dto.writer}" id="writer" placeholder="Enter writer" name="writer">
	    </div>
	    <div class="form-group">
	      <label for="contents">CONTENTS:</label>
	      <textarea rows="10" cols="" class="form-control" name="contents">${dto.contents}</textarea>
	    </div>
	    
	    <c:forEach items="${files}" var="file" varStatus="i">
		    <div class="form-group" id="p${file.fnum}">
		      <span>${file.oname}</span>
		      <span class="del" id="${file.fnum}" title="${file.fname}">X</span>
		    </div>
	    </c:forEach>
	    
	    <button type="submit" class="btn btn-default">WRITER</button>
 	 </form>
	</div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
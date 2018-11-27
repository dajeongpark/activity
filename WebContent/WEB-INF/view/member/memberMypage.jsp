<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"/>
<script type="text/javascript">
	$(function() {
		$("#del").click(function() {
			if(confirm("회원 탈퇴를 하시겠습니까?")){
				location.replace("./memberDelete.do")
			}else {
				return false;
			}
		});
	});
</script>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

<div class="container-fluid">
	<div class="row">
	  <form id="frm" class="form-horizontal" action="./memberUpdate.do" method="post">
	  	<h2>회원 정보</h2>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="id">ID:</label>
	      <div class="col-sm-10">
	        <p class="form-control-static">${member.id}</p>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="id">NAME:</label>
	      <div class="col-sm-10">
	        <p class="form-control-static">${member.name}</p>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="id">BIRTH:</label>
	      <div class="col-sm-10">
	        <p class="form-control-static">${member.birth}</p>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="id">PHONE:</label>
	      <div class="col-sm-10">
	        <p class="form-control-static">${member.phone}</p>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="id">E-MAIL:</label>
	      <div class="col-sm-10">
	        <p class="form-control-static">${member.email}@${member.domain}</p>
	      </div>
	    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <a href="./memberUpdate.do" class="btn btn-default">회원 정보 수정</a>
        <input type="button" id="del" class="btn btn-default" value="회원 탈퇴">
		<!-- <a href="./memberDelete.do" class="btn btn-default">회원 탈퇴</a> -->
      </div>
    </div>
  </form>
  </div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
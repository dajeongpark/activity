<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"/>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

<div class="container-fluid">
	<div class="row">
	  <form class="form-horizontal" action="./memberUpdate.do" method="post">
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
        <a href="./memberUpdate.do" class="btn btn-default">UPDATE</a>
		<a href="./memberDelete.do" class="btn btn-default">DELETE</a>
      </div>
    </div>
  </form>
  </div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
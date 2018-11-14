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
		<form action="./memberUpdate.do" method="post" >
		    <div class="form-group">
		      <label for="id">ID:</label>
		      <input type="text" value="${member.id}" readonly="readonly" class="form-control" id="id" placeholder="Enter Id" name="id">
		    </div>
		    <div class="form-group">
		      <label for="pw">PASSWORD:</label>
		      <input type="password" value="${member.pw}" class="form-control" id="pw" placeholder="Enter Password" name="pw">
		    </div>
		    <div class="form-group">
		      <label for="name">NAME:</label>
		      <input type="text" value="${member.name}" class="form-control" id="name" placeholder="Enter Name" name="name">
		    </div>
		    <div class="form-group">
		      <label for="email">EMAIL:</label>
		      <input type="email" value="${member.email}" class="form-control" id="email" placeholder="Enter E-Mail" name="email">
		    </div>
		    <div class="form-group">
		      <label for="phone">PHONE:</label>
		      <input type="text" value="${member.phone}" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
		    </div>
		    <div class="form-group">
		      <label for="birth">BIRTH:</label>
		      <input type="date" value="${member.birth}" class="form-control" id="birth" placeholder="Enter Birth" name="birth">
		    </div>
		    
		    <button type="submit" class="btn btn-default">UPDATE</button>
		 </form>		
	</div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
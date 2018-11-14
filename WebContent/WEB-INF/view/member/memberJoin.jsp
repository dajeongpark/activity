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
		
		$("#id").change();(function() {
			$("#idCheck").val('f');
		});
		
		$("#join").click(function() {
			var check = $("#idCheck").val();
			if(check=='s'){
				alert("OK");
			}else{
				alert("아이디 중복 체크가 필요합니다");
			}
		});
		
		$("#btn").click(function() {
			var id = document.frm.id.value;
			window.open("./memberCheckId.do?id="+id, "CheckID","width=500, height=200, top=300, left=500");
		});	
		
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("input").keyup(function() {
			var pw1=$("#pw1").val();
			var pw2=$("#pw2").val();
			if(pw1!=""||pw2!=""){
				if(pw1==pw2){
					$("#alert-success").show();
					$("#alert-danger").hide();
				}else{
					$("#alert-success").hide();
					$("#alert-danger").show();
				}
			}
		});		
		
	});
</script>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

<div class="container-fluid">
	<div class="row">
		<form name="frm" action="./memberJoin.do" method="post">
		<input type="hidden" value="f" name="idCheck" id="idCheck">
				<div class="form-group">
			      <label for="id">ID:</label>
			      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
			      <input type="button" id="btn" class="btn btn-default" value="중복확인">
			    </div>
			    <div class="form-group">
			      <label for="pw">Password:</label>
			      <input type="password" class="form-control" id="pw1" placeholder="Enter pw">
			    </div>
			    <div class="form-group">
			      <label for="pw">Password:</label>
			      <input type="password" class="form-control" id="pw2" placeholder="Enter pw" name="pw">
			    </div>
			    <div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
				<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
			    <div class="form-group">
			      <label for="name">Name:</label>
	              <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	    	    </div>
	            <div class="form-group">
	              <label for="email">E-Mail:</label>
	              <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
	            </div>
	            <div class="form-group">
	              <label for="phone">Phone:</label>
	              <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
	            </div>
	            <div class="form-group">
	              <label for="birth">Birth:</label>
	              <input type="date" class="form-control" id="birth" placeholder="Enter birth" name="birth">
	            </div>
	            <div class="form-group">
	              <label for="kind">Kind:</label>
	              <p>admin: <input type="radio" class="form-control" id="kind" name="kind" value="admin"></p>
	              <p>user: <input type="radio" class="form-control" id="kind" name="kind" value="user" checked="checked"></p>
	            </div>
			 <input type="submit" id="join" class="btn btn-default" value="JOIN">
 		</form>
	</div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
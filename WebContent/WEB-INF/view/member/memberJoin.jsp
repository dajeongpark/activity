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
		
		$("#btn").click(function() {
			var id = document.frm.id.value;
			if(id!=""){
				window.open("./memberCheckId.do?id="+id, "CheckID","width=500, height=200, top=300, left=500");		
			}else {
				alert("아이디를 입력하세요");
			}
		});
		
		$(".phone").on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g,""));
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
		
		$("#emailSelect").change(function() {
			$("#emailSelect option:selected").each(function() {
				if($(this).val()=='1'){
					$("#domain").val("");
					$("#domain").attr("readonly",false);
				}else {
					$("#domain").val($(this).text());
					$("#domain").attr("readonly",true);
				}
			});
		});


		$("#join").click(function() {
			var check = $("#idCheck").val();
			if(check!='s'){
				alert("아이디 중복체크를 해주세요.");
				return false;
			}else if($("#pw1").val()==''){
				alert("비밀번호를 입력하세요");
				$("#pw1").focus();
				return false;
			}else if($("#pw1").val()!=$("#pw2").val()){
				alert("비밀번호가 일치하지 않습니다");
				$("#pw2").focus();
				return false;
			}else if($("#name").val()==''){
				alert("성함을 입력하세요");
				$("#name").focus();
				return false;
			}else if($("#email").val()==''){
				alert("이메일을 입력하세요");
				$("#email").focus();
				return false;
			}else if($("#domain").val()==''){
				alert("이메일을 입력하세요");
				$("#domain").focus();
				return false;
			}else if($("#phone2").val()==''){
				alert("연락처를 입력하세요");
				$("#phone2").focus();
				return false;
			}else {
				$("#frm").submit();
			}				
			
		});
		
	});
</script>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

<div class="container-fluid">
	<div class="row">
	<h2>회원가입</h2>
		<form id="frm" name="frm" action="./memberJoin.do" method="post">
		<input type="hidden" value="f" name="idCheck" id="idCheck">
				<div class="form-group">
			      <label for="id">ID:</label>
			      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
			      <input type="button" id="btn" class="btn btn-default" value="중복확인">
			    </div>
			    <div class="form-group">
			      <label for="pw">PASSWORD:</label>
			      <input type="password" class="form-control" id="pw1" placeholder="Enter pw">
			    </div>
			    <div class="form-group">
			      <label for="pw">PASSWORD:</label>
			      <input type="password" class="form-control" id="pw2" placeholder="Enter pw" name="pw">
			    </div>
			    <div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
				<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
			    <div class="form-group">
			      <label for="name">NAME:</label>
	              <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	    	    </div>
	    	    
	    	    <div class="form-group">
	              <label for="birth">BIRTH:</label>
	              <input type="date" class="form-control" id="birth" placeholder="Enter birth" name="birth">
	            </div>
	    	    
	    	    <label for="phone">PHONE:</label>
	            <div class="form-inline">
	              <select name="phone1" class="form-control" id="phone1">
	              	<option value="010" selected>010</option>
	              	<option value="011">011</option>
	              	<option value="012">012</option>
	              	<option value="013">013</option>
	              </select> 
	              -
	              <input type="text" class="phone form-control" id="phone2" name="phone2" maxlength="4">
	              -
	              <input type="text" class="phone form-control" id="phone3" name="phone3" maxlength="4">
	            </div><br>
	            
	            <label for="email">E-MAIL:</label>
	            <div class="form-inline">
	              <input type="text" id="email" class="form-control" placeholder="Enter email" name="email">@<input type="text" id="domain" class="form-control"name="domain">
	              <select name="emailSelect" class="form-control" id="emailSelect">
	              	<option value="1" selected>직접입력</option>
	              	<option value="naver.com">naver.com</option>
	              	<option value="gmail.com">gmail.com</option>
	              	<option value="nate.com">nate.com</option>
	              	<option value="daum.net">daum.net</option>
	              </select>
	            </div><br>
	            
	            <div class="form-group">
	              <label for="kind">KIND:</label>
	              <p>관리자: <input type="radio" id="kind" name="kind" value="admin">  일반회원: <input type="radio" id="kind" name="kind" value="user" checked="checked"></p>
	            </div>
			 <input type="button" id="join" class="btn btn-default" value="JOIN">
 		</form>
	</div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
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
		
		$(document).ready(function(){ 
		    $("input#phone").blur(function(){
		    	var num = $("#phone").val();
		    	blur(num)
		    });
		    $("input#phone").click(function(){
		    	var num = $("#phone").val();
		    	focus(num);
		    });
		});
		function focus(num) {
			num = num.replace(/[^0-9]/g, '');
			$("#phone").val(num);
		}
		function blur(num) {
			num = num.replace(/[^0-9]/g, '');
			var tmp = '';
			tmp += num.substr(0, 3);
			tmp += '-';
			tmp += num.substr(3, 4);
			tmp += '-';
			tmp += num.substr(7);
			$("#phone").val(tmp);
		}
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
			}else if($("#phone").val()==''){
				alert("연락처를 입력하세요");
				$("#phone").focus();
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
		<form id="frm" name="frm" action="./memberJoin.do" method="post">
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
	            
	            <label for="email">E-Mail:</label>
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
			 <input type="button" id="join" class="btn btn-default" value="JOIN">
 		</form>
	</div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
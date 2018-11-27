<%@page import="com.bora.member.MemberDAO"%>
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
		
		$(document).ready(function() {
			$("#phone1 option").each(function() {
				if($(this).val()=="${member.phone1}"){
					$(this).attr("selected", "selected");
				}
			});
		});
		

		$(".phone").on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g,""));
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
		
				
		$("#update").click(function() {
			if($("#pw1").val()==''){
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
<body onload="init()">
<c:import url="../../../temp/header.jsp"/>

<div class="container-fluid">
	<div class="row">
	<h2>회원 정보 수정</h2>
		<form id="frm" name="frm" action="./memberUpdate.do" method="post" >
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
		      <label for="birth">BIRTH:</label>
		      <input type="date" value="${member.birth}" readonly="readonly" class="form-control" id="birth" placeholder="Enter Birth" name="birth">
		    </div>
		    
		    <label for="phone">PHONE:</label>
		    <div class="form-inline">
		      <select name="phone1" class="form-control" id="phone1">
	              	<option value="010">010</option>
	              	<option value="011">011</option>
	              	<option value="012">012</option>
	              	<option value="013">013</option>
	          </select> 
		      -
		      <input type="text" value="${member.phone2}" class="phone form-control" id="phone2" name="phone2" maxlength="4">
		      -
		      <input type="text" value="${member.phone3}" class="phone form-control" id="phone3" name="phone3" maxlength="4">
		    </div><br>
		    
  	        <label for="email">E-MAIL:</label>
		    <div class="form-inline">
		      <input type="text" value="${member.email}" class="form-control" id="email" placeholder="Enter E-Mail" name="email">@<input type="text" value="${member.domain}" id="domain" class="form-control"name="domain">
		      <select name="emailSelect" class="form-control" id="emailSelect">
				 <option value="1" selected>직접입력</option>
	             <option value="naver.com">naver.com</option>
	             <option value="gmail.com">gmail.com</option>
	             <option value="nate.com">nate.com</option>
	             <option value="daum.net">daum.net</option>
	          </select>
		    </div><br>
		    
			<input type="button" id="update" class="btn btn-default" value="수정">
			<input type="button" class="btn btn-default" value="취소" onclick="javascript:window.location='./memberMypage.do'">
		</form>		
	</div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
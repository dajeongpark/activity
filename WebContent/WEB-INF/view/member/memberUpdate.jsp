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
		    
  	        <label for="email">E-MAIL:</label>
		    <div class="form-inline">
		      <input type="text" value="${member.email}" class="form-control" id="email" placeholder="Enter E-Mail" name="email">@<input type="text" id="domain" class="form-control"name="domain">
		      <select name="emailSelect" class="form-control" id="emailSelect">
	             <option value="1" selected>직접입력</option>
	             <option value="naver.com">naver.com</option>
	             <option value="gmail.com">gmail.com</option>
	             <option value="nate.com">nate.com</option>
	             <option value="daum.net">daum.net</option>
	          </select>
		    </div><br>
		    
		    <div class="form-group">
		      <label for="phone">PHONE:</label>
		      <input type="text" value="${member.phone}" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
		    </div>
		    <div class="form-group">
		      <label for="birth">BIRTH:</label>
		      <input type="date" value="${member.birth}" class="form-control" id="birth" placeholder="Enter Birth" name="birth">
		    </div>
			
			<input type="button" id="update" class="btn btn-default" value="UPDATE">
		    
		    <!-- <button type="submit" class="btn btn-default">UPDATE</button> -->
		 </form>		
	</div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>
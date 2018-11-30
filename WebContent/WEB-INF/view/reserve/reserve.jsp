<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
<style type="text/css">
	#person1, #totalPrice {
		color: blue;
	}
	.box {
		margin-top: -20px;
		margin-bottom: 20px;
	}
	.btns {
		display: block;
		margin: 0 auto;
	}
</style>

<script type="text/javascript">
	
	/* function closeReserve() {
		self.close();
	} */
	
	$(document).ready(function() {
		$("#closeBtn").click(function() {
			//opener.document.frm.selectDate.value='${selectDate}';
			self.close();
		});
		
		
		$("#reserveBtn").click(function() {
			var num = ${param.num};
			var selectDate = $("#selectDate").val();
			var person = $("#person").val();
			var title = '${param.title}';
			var onePrice = ${param.onePrice};
			
			$.ajax({
				type: "get",
				url: "./reserveWrite.do",
				data: {num:num, selectDate:selectDate, person:person, title:title, onePrice:onePrice},
				success: function(result) {
					result = result.trim();
					if(result>0){
						alert("Reserve Success");
					}else{
						alert("Reserve Fail");
					}
					self.close();
				}
			}); 
		});
		
		$("#person").change(function() {
			var person = $("#person").val();
			$("#person1").html(person);
		}).keyup(function() {
			var person = $("#person").val();
			$("#person1").html(person);
		}).change(function() {
			var person = $("#person").val(); // why "#person1" isn't working?
			var onePrice = ${param.onePrice};
			var totalPrice = eval("person * onePrice");
			$("#totalPrice").html(totalPrice);
		});
		
		
		$("#paymentBtn").click(function() {
			var num = ${param.num};
			var selectDate = $("#selectDate").val();
			var person = $("#person").val();
			var title = '${param.title}';
			var onePrice = ${param.onePrice};
			location.href="../order/orderPage.do?num="+num+"&selectDate="+selectDate+"&person"+person+"&title"+title+"&onePrice"+onePrice;
			
			/* $.ajax({
				type: "get",
				url: "../order/orderPage.do",
				data: {num:num, selectDate:selectDate, person:person, title:title, onePrice:onePrice},
				success: function(result) {
					result = result.trim();
					if(result>0){
						alert("예약되었습니다. 결제 페이지로 이동");
					}else{
						alert("Reserve Fail");
					}
					self.close();
				}
			});  */
		});
		
		
		
	});
	
</script>

</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import> <!-- 허전해보여서 header, footer 넣음ㅋㅋ  나중에 빼고 새로 디자인하기 -->
	
	<div class="container-fluid box">
		<form id="frm" action="./reserveWrite.do" accept-charset="utf-8" name="reserveView" method="get">
			<input type="hidden" name="num" value="${param.num}">
			
			
			<div class="container-fluid">
				<h3>${param.title}</h3>
			</div>
				
			<div class="container-fluid">
				<div class="panel panel-info">
					<div class="panel-heading">날짜 선택</div>
					<div class="panel-body">
						<input type="date" name="date" id="selectDate">
					</div>
				</div>
			</div>
			
			<div class="container-fluid">
					<div class="panel panel-info">
						<div class="panel-heading">인원수</div>
						<div class="panel-body">
							 <input type="number" class="person" id="person" name="person" min="1" max="100"> 명
						</div>
					</div>
			</div>
			
			<div class="container-fluid">
					<div class="panel panel-info">
						<div class="panel-heading">가격</div>
						<div class="panel-body">
							${param.onePrice}원(1인) X <span id="person1"></span>명 = 총 <span id="totalPrice"></span>원
						</div>
					</div>
			</div>
			
			<div class="btns">
				<%-- <c:if test="${!empty result}">
					<h3>날짜입력받음</h3> --%>
					<div class="container-fluid">
						<input type="button" class="closeBtn btn-primary" id="closeBtn" value="창 닫기">
						<input type="button" class="reserveBtn btn-primary" id="reserveBtn" value="예약">
						<input type="button" class="paymentBtn btn-primary" id="paymentBtn" value="결제 페이지로 이동">
					</div>
				<%-- </c:if>
				<c:if test="${empty result}">
					<h3>날짜입력안받음</h3>
				</c:if> --%>
			</div>
			
		</form>
	</div>
	
<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
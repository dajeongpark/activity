<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.bora.order.OrderDAO"%>
<%@page import="com.bora.order.OrderDTO"%>
<%@page import="com.bora.reserve.ReserveDTO"%>
<%@page import="com.bora.reserve.ReserveDAO"%>
<%@page import="com.bora.member.MemberDTO"%>
<%@page import="com.bora.member.MemberDAO"%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <c:import url="../../../temp/bootStrap.jsp"></c:import>
	<c:import url="../../../css/sub.css"></c:import>

<script type="text/javascript">
	$(document).ready(function(){
		$("#confirm").click(function(){
			var result = 0;
			var isTest = 1;
			if(isTest == 1){
				$("#frm").submit();
				result = 1;
			}else {
				result=0;
			}
		});
		
		$('#cancle').click(function(){
			self.close();
		});
	});
	
	</script>
	
</head>

<body>
    <c:import url="../../../temp/header.jsp"></c:import>

    <div class="container-fluid">
        <div class="row">
        <div class="contentWrap">
        <form action="./orderResult.do" id="frm" method="post">
        	<input type="hidden" name="num" value="${member.num}">
        	<input type="hidden" name="email" value="${member.email}">
        	<input type="hidden" name="phone" value="${member.phone}"> 
        	<input type="hidden" name="selectDate" value="${reserve.selectDate}">
        	<input type="hidden" name="title" value="${reserve.title}">
        	<input type="hidden" name="person" value="${reserve.person}">
        	<input type="hidden" name="onePrice" value="${reserve.onePrice}">
        	<input type="hidden" name="totalPrice" value="${reserve.onePrice*reserve.person}">
        	
            <div class="mWt48p">
                <div class="left_box">
                    <h1 class="pageTitle">이용규칙 확인하기</h1>
                    <div class="gray_whiteBox b_round2">해당날짜에 1자리 남아있습니다.</div>
                    <div class="date_check">
                        <h3 class="boxTitle"><!-- <span id="region">지역</span> --><span id="date">예약날짜</span></h3>
                        <div class="no_grayBox"><span id="reserveDate">${reserve.selectDate}</span><br><span id="reserveTime">12:00</span></div>
                    </div>
                 	<div class="memInfo">
                 		<div class="name"><span class="label">대표자명</span> : ${member.name}</div>
                 		<div class="name"><span class="label">E-Mail</span> : ${member.email}</div>
                 		<div class="name"><span class="label">연락처</span> : ${member.phone}</div>
                 	</div>
                    <!-- <div class="g_line"></div>
                    <div class="notes">
                        <h3 class="boxTitle">주의할 사항</h3>
                    </div> -->
                </div>
            </div>
            <div class="mWt48p">
                <div class="payment_box">
                    <div class="gray_whiteBox">
                        <!-- <div class="thumbnail">
                            <img src="">
                        </div> -->
                        <h3 class="boxTitle">${reserve.title}</h3>
                        <!-- <div class="rate">
                            <span>별점표시</span>
                            <span>후기<span id="review_num">00</span>개</span>
                        </div> -->
                        <div class="g_line"></div>
                        <div class="guest">게스트 <span id="guestNum">${reserve.person}</span>명</div>
                        <div class="reserveDate">
                            <span>${reserve.selectDate}</span> <span>12:00</span>
                        </div>
                        <div class="g_line"></div>
                        <div class="Price">
                            <div class="cal">
                                <span class="currency">$</span>
                                <span class="onePrice">${reserve.onePrice}</span>
                                <span class="multi">X</span>	
                                <span class="member">${reserve.person}</span>
                            </div>
                            <div class="resultPrice">
                                <span class="currency">$</span>
                                <span class="onePrice">${reserve.onePrice}</span>
                            </div>
                            <!-- <br>
                            <div class="fees">
                                <span class="currency">$</span>
                                <span class="onePrice">3.25</span>
                            </div> -->
                        </div>
                        <div class="g_line"></div>
                        <div class="totalPriceBox">
                            <div class="">총 합계(<span class="currency">$</span>)</div>
                            <div class="finalCheck">
                                <span class="currency">$</span>
                                <span class="totalPrice">${reserve.onePrice*reserve.person}</span>
                            </div>
                        </div>
                        <div class="g_line"></div>
                        <div class="cancelGuide">
                            <h3 class="boxTitle">
                                <span class="cancel_policy">유연-취소무료</span>
                            </h3>
                            <div class="cancel_content">
                                48시간 이내에 취소하면 전액이 환불됩니다.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="btnBox">
            <input type="button" id="cancle" value="취소">
            <input type="button" id="confirm" value="확인">
        </div>
        </div>
        </div>
    </div>
    <c:import url="../../../temp/footer.jsp"></c:import>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <c:import url="../../temp/bootStrap.jsp"></c:import>
	<c:import url="../../css/sub.css"></c:import>
</head>

<body>
    <c:import url="../../temp/header.jsp"></c:import>

    <div class="container-fluid">
        <div class="row">
            <div class="mWt48p">
                <div class="left_box">
                    <h1 class="pageTitle">이용규칙 확인하기</h1>
                    <div class="gray_whiteBox">해당날짜에 1자리 남아있습니다.</div>
                    <div class="date_check">
                        <h3 class="boxTitle"><span id="region">지역</span><span id="date">예약날짜</span></h3>
                        <div class="no_grayBox"><span id="reserveDate">11월30일</span><br><span id="reserveTime">12:00</span></div>
                    </div>
                    <div class="g_line"></div>
                    <div class="notes">
                        <h3 class="boxTitle">주의할 사항</h3>
                    </div>
                </div>
            </div>
            <div class="mWt48p">
                <div class="payment_box">
                    <div class="gray_whiteBox">
                        <div class="thumbnail">
                            <img src="">
                        </div>
                        <h3 class="boxTitle">패러글라이딩</h3>
                        <div class="rate">
                            <span>별점표시</span>
                            <span>후기<span id="review_num">00</span>개</span>
                        </div>
                        <div class="g_line"></div>
                        <div class="guest">게스트 <span id="guestNum"></span>명</div>
                        <div class="reserveDate">
                            <span>11월30일</span><br><span>12:00</span>
                        </div>
                        <div class="g_line"></div>
                        <div class="Price">
                            <div class="cal">
                                <span class="currency">$</span>
                                <span class="onePrice">25</span>
                                <span class="multi">X</span>
                                <span class="member">1</span>
                            </div>
                            <div class="resultPrice">
                                <span class="currency">$</span>
                                <span class="onePrice">25</span>
                            </div>
                            <br>
                            <div class="fees">
                                <span class="currency">$</span>
                                <span class="onePrice">3.25</span>
                            </div>
                        </div>
                        <div class="g_line"></div>
                        <div class="totalPriceBox">
                            <div class="">총 합계(<span class="currency">$</span>)</div>
                            <div class="finalCheck">
                                <span class="currency">$</span>
                                <span class="totalPrice">28.25</span>
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
        </div>
    </div>
    <c:import url="../../../temp/footer.jsp"></c:import>

</body>

</html>
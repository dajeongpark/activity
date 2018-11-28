<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <c:import url="../../../temp/bootStrap.jsp"></c:import>
	<c:import url="../../../css/sub.css"></c:import>
</head>

<body>
    <c:import url="../../../temp/header.jsp"></c:import>

    <div class="container-fluid">
        <div class="row">
            <div class="mWt48p">
                <div class="left_box">
                    <h1 class="pageTitle">카드정보 등록</h1>
                    <form action="./paymentProcess.jsp" method="post">
                    	<table>
                    		<tr>
                    			<td class="col">카드번호</td>
                    			<td>
	                    			<input type="text" id="" name="cardNum1">
			                    	<input type="password" id="" name="cardNum2">
			                    	<input type="password" id="" name="cardNum3">
			                    	<input type="text" id="" name="cardNum4">
                    			</td>
                    		</tr>
                    		<tr>
                    			<td class="col">cvc</td>
                    			<td>
			                    	<input type="password" id="" name="cvc">
			                    </td>
                    		</tr>
                    		<tr>
                    			<td class="col">month/year</td>
                    			<td>
	                    			<input type="text" id="" name="month">
	                    			<input type="text" id="" name="year">
	                    		</td>
                    		</tr>
                    		<tr>
                    			<td class="col">명의</td>
                    			<td>
	                    			<input type="text" id="" name="name">
	                    		</td>
                    		</tr>
                    		<tr>
                    			<td class="col">카드사</td>
                    			<td>
	                    			<input type="radio" name="kind" id="visa"><label for="visa">VISA</label>
	                    			<input type="radio" name="kind" id="master"><label for="master">MASTER</label>
	                    			<input type="radio" name="kind" id="jcb"><label for="jcb">JCB</label>
	                    			<input type="radio" name="kind" id="americanExpress"><label for="amricanExpress">AMERICAN EXPRESS</label>
	                    		</td>
                    		</tr>
                    	</table>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <c:import url="../../../temp/footer.jsp"></c:import>

</body>

</html>
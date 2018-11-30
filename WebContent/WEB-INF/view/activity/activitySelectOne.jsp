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
	.box {
		margin-top: 50px;
	}
	table {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 90%;
		margin: 0 auto;
	}
	.contentsTable td, th {
		border: 1px solid #dddddd;
		text-align: center;
		padding: 8px;
	}
	.contentsTable tr:nth-child(odd) { /* nth-last-child(even) */
		background-color: #dddddd;
	}
	.replyWriteTable tr:first-child {
		background-color: white;
	}
	.replyTable tr:nth-child(odd) {
		background-color: #dddddd;
	}
	
	
	.btnBox {
		display: block;
		margin: 30px auto;
	}
	
	
	.second {
		display: block;
		margin-top: 30px;
	}
	
	
	.replyWriteTable td, th {
		border: none;
		text-align: center;
		padding: 8px;
	}
	.replySpace {
		border-top: 2px solid #dddddd;
		border-bottom: 2px solid #dddddd;
	}
	.commentBox {
		margin: 25px;
	}
	
	
	.replyTable td, th {
		border: none;
		text-align: center;
		padding: 8px;
	}
	.replyTable {
		margin-bottom: 60px;
	}
	.replyTable tr:last-child {
		border-bottom: 2px solid #dddddd;
	}
	.contents {
		width: 300px;
	}
	
</style>

<script type="text/javascript">
	
	function openReserve() {
		var title=encodeURI('${activityDTO.title}');
		window.open("../reserve/reserve.do?num=${activityDTO.num}&title="+title+"&onePrice=${activityDTO.onePrice}", "", "width=500, height=500, left=400, top=200");
		// activity디렉터리에 있는 페이지에서 요청보내는거라서 path가 activity/activity/로 시작함
		// 그래서 ../로 한 디렉터리 올라가줘야함 (and then current directory : view)
	}
	/* window.onload=funtion(){ // It's not working for some reason :(
		var btn = document.getElementById("btn");
		btn.addEventListener("click", function() {
			window.open("./reserve.do", "", "width=500, height=500, left=400, top=200");
		});
	} */
	
	$(function() {
		var curPage=1;
		$("#commentBtn").click(function() {
			$.post("./replyWrite.do?curPage="+curPage, function(data) {
				alert("clicked");
				$(".replyTable").html(data);
			});
			curPage++;
		});
	});
	
	function deleteFunction() {
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href='./activityDelete.do?num=${activityDTO.num}'
		}else{
			
		}
	}
	
	
	
</script>

</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>
	
	<div class="container-fluid box">
		
		<div class="row">
			<input type="hidden" name="idx" value="${param.num}">
			<table class="contentsTable">
				<tr> <td>TITLE</td> </tr>
				<tr> <td>${activityDTO.title}</td> </tr>
				<tr> <td>CONTENTS</td> </tr>
				<tr>
					<td>
						<c:forEach items="${files}" var="fileDTO">
							<img src="../upload/${fileDTO.fname}"><br>
						</c:forEach>
						${firstFile}
						<br>${activityDTO.contents}<br>
						<div class="btnBox">
							<button onclick="openReserve()" class="btn btn-primary">예약하기</button>
							<button onclick="location.href='./activityList.do'" class="btn btn-primary">목록으로 돌아가기</button>
							
							<%-- <c:if test="${not empty member and member.kind eq '관리자'}"> --%>
							<c:import url="../../../temp/updateDeleteButton.jsp"></c:import>
							<%-- </c:if> --%>
							
						</div>
						
						<div class="row second">
							
							<table class="replyWriteTable">
								<tr class="replySpace">
									<td colspan=3>
										<form class="form-horizontal" action="#" id="frm" method="post">
											<form class="form-inline">
												<div class="commentBox">
													<label class="control-label col-sm-2">Comment</label>
													<div class="col-sm-7">
														<input type="text" class="form-control" id="contents" placeholder="Enter Comment" name="contents" autocomplete="off">
													</div>
													<input type="button" id="commentBtn" class="btn btn-default" value="댓글 달기">
												</div>
											</form>
										</form>
									</td>
								</tr>
							</table>
							
							<table class="replyTable">
								<c:forEach items="${comments}" var="replyDTO">
									<tr> <td>${replyDTO.writer}</td> <td>${replyDTO.contents}</td> <td>${replyDTO.reg_date}</td> </tr>
								</c:forEach>
							</table>
							
						</div>
								
					</td>
				</tr>
			</table>
			
		</div>
	</div>
	
	
	
	
	
<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>
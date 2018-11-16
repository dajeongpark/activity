<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 삭제</title>
<jsp:include page="../../../temp/bootStrap.jsp"></jsp:include>

</head>
<body>
<jsp:include page="../../../temp/header.jsp"></jsp:include>

	<div class="container">
		<h1>${board}Delete</h1>

		<form class="form-horizontal" action="./${board}Delete.do" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="boardPw">pw check: </label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="boardPw" id="boardPw"
						placeholder="boardPw">
				</div>
			</div>

			<div class="form-group text-center">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">삭제</button>

				</div>
			</div>
		</form>
	</div>
	
<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>
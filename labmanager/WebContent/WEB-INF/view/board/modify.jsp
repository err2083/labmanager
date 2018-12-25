<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form role="form" method="post">
	<input type='hidden' name='bno' value="${board.bno}">
</form>
<div>
	<div>
		<label>BNO</label>
		<input type="text" name="bno" value="${board.bno}" readonly="readonly">
	</div>
	<div>
		<label>제목</label>
		<input type="text" name="title" value="${board.title}">
	</div>
	<div>
		<label>내용</label>
		<textarea rows="3" name="content">${board.content}</textarea>
	</div>
	<div>
		<label>작성자</label>
		<input type="text" name="writer" value="${board.title}" readonly="readonly">
	</div>
</div>
<!-- box-body -->
<div>
	<button type="submit" class="btn btn-warning">CANCLE</button>
	<button type="submit" class="btn btn-primary">SAVE</button>
</div>
<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");
	console.log(formObj);
	
	$(".btn-warning").on("clock",funtion(){
		self.location = "/board/listAll";
	});
	
	$(".btn-primary").on("clock",funtion(){
		formObj.submit();
	});
})
</script>
</body>
</html>
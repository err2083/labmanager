<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="C:/Users/user/Downloads/jquery-3.2.1.min.js"></script>
</head>
<body>
<form role="form" method="post" action="modifyPage">
	<input type='hidden' name='bno' value="${boardDatatype.bno}">
	<input type='hidden' name='page' value="${cri.page}">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">
</form>
<div>
	<div>
		<label>제목</label>
		<input type="text" name="title" value="${boardDatatype.title}" readonly="readonly">
	</div>
	<div>
		<label>내용</label>
		<textarea rows="3" name="content" readonly="readonly">${boardDatatype.content}</textarea>
	</div>
	<div>
		<label>작성자</label>
		<input type="text" name="writer" value="${boardDatatype.title}" readonly="readonly">
	</div>
</div>
<!-- box-body -->
<div>
	<button type="submit" class="btn btn-warning">수정하기</button>
	<button type="submit" class="btn btn-danger">삭제하기</button>
	<button type="submit" class="btn btn-primary">목록</button>
</div>
<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");
	console.log(formObj);
	
	$(".btn-warning").on("click",funtion(){
		formObj.attr("action","/board/modifyPage");
		formObj.attr("method","get");
		formObj.submit();
	});
	
	$(".btn-danger").on("click",funtion(){
		formObj.attr("action","/board/removePage");
		formObj.submit();
	});
	
	$(".btn-primary").on("click",funtion(){
		formObj.attr("method","get");
		formObj.attr("action","/board/listPage");
		formObj.submit();
	});
})
</script>
</body>
</html>
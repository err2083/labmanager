<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	var result = '${msg}';
	
	if(result == 'SUCCESS'){
		alter("처리가 완료 되었습니다.");
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>날짜</td>
		<td>조회수</td>
	<tr>
	<c:forEach items="${list}" var="board">
	<tr>
		<td>${board.bno}</td>
		<td><a href='/labmanager/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)
		 }&bno=${board.bno}'>${board.title}</a></td>
		<td>${board.writer}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}"/></td>
		<td>${board.viewcnt}</td>
	<tr>
	</c:forEach>
</table>
<p><a href="register">글작성</a></p>
<p><a href="/labmanager/main/hello">메인으로 가기</a></p>
</body>
</html>
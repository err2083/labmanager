<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기 페이지</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form:form action="/labmanager/board/register" method="POST" modelAttribute="board">
		<table>
			<tr>
				<td>제목:</td>
				<td><form:input path="title"/></td>
			</tr>
			<tr>
				<td>내용:</td>
				<td><form:textarea path="content"/></td>
			</tr>
		</table>
		<input type="submit" value="register">
	</form:form>
</table>
</body>
</html>
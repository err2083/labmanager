<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form:form action="/labmanager/user/login" method="POST" modelAttribute="user">
		<table>
			<tr>
				<td>아이디:</td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><form:password path="password"/></td>
			</tr>
		</table>
		<input type="submit" value="login">
	</form:form>
</body>
</html>
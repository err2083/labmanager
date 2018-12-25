<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정페이지</title>
</head>
<body>
	<form:form action="/labmanager/user/modify" method="POST" modelAttribute="user">
		<table>
			<tr>
				<td>아이디:</td>
				<td>${user.id}
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><form:input path="email1"/>@<form:input path="email2"/></td>
			</tr>
			<tr>
				<td>연구분야:</td>
				<td><form:input path="study"/></td>
			</tr>
			<tr>
				<td>관심분야:</td>
				<td><form:input path="hope"/></td>
			</tr>
		</table>
		<input type="submit" value="modify">
	</form:form>
</body>
</html>
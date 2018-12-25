<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 회원보기</title>
</head>
<body>
	
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>이름</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이메일</td>
		<td>권한</td>
		<td>보기</td>
	<tr>
	<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.name}</td>
			<td>${user.id}</td>
			<td>${user.password}</td>
			<td>${user.email1} @ ${user.email1}</td>
			<td>${user.role.role}</td>
			<td> <a href="selectOne?id=${user.id}">X</a></td>
		</tr>
	</c:forEach>
</table>	
	<a href="/labmanager/main/hello">메인으로 가기</a>
</body>
</html>
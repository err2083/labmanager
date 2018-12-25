<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 한명보는 페이지</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>이름</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이메일</td>
		<td>연구분야</td>
		<td>희망분야</td>
		<td>권한</td>
	</tr>
	<tr>
		<td>${user.name}</td>
		<td>${user.id}</td>
		<td>${user.password}</td>
		<td>${user.email1} @ ${user.email2}</td>
		<td>${user.study}</td>
		<td>${user.hope}</td>
		<td>
			<c:choose>
				<c:when test="${user.role} = YET">
					<input type="radio" name="yet" checked="checked">yet
				</c:when>
				<c:otherwise>
					<input type="radio" name="yet">yet
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${userRole} = STUDENT">
					<input type="radio" name="yet" checked="checked">student
				</c:when>
				<c:otherwise>
					<input type="radio" name="yet">student
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>	
	<a href="selectAll">돌아가기</a>
</body>
</html>
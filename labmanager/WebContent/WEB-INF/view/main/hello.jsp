<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 페이지</title>
<script type="text/javascript">
	alter('test');
</script>
</head>
<body>
	<a href="<c:url value="/user/loginform"/>">로그인</a> <br>
	<a href="<c:url value="/user/joinform"/>">회원가입</a> <br>
	<a href="<c:url value="/user/modifyform"/>">회원정보수정</a> <br>
	<a href="<c:url value="/user/logout"/>">로그아웃</a> <br>
	<a href="<c:url value="/user/withdraw"/>">회원탈퇴</a> <br>
	<a href="<c:url value="/user/selectAll"/>">전체회원보기</a> <br>
	<a href="<c:url value="/board/listPage"/>">게시글보기</a> <br>
	<table>
		<tr>
			<td><c:out value="${sessionScope.user.name}" escapeXml="false"> 손님</c:out></td>
			<td><c:out value="${sessionScope.user.id}" escapeXml="false"> 로그인</c:out></td>
		</tr>
	</table>
</body>
</html>

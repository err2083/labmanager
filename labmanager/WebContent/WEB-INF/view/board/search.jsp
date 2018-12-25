<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="C:/Users/user/Downloads/jquery-3.2.1.min.js"></script>
<script>
	var result = '${msg}';
	
	if(result == 'SUCCESS'){
		alter("처리가 완료 되었습니다.");
	}
	
	$(document).ready(function(){
		$('#searchBtn').on(
				"click",function(event){
					self.location = "board/search"
					+ '${pageMaker.makeQuery(1)}'
					+ "&searchType="
					+ $("select option:selected").val()
					+ "&keyword=" + $('#keywordInput').val();
				});
		$('#newBtn').on("click",function(evt){
			self.location = "register";
		});
	});
</script>
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

<div>
	<select name="searchType">
		<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
		<option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>Title</option>
		<option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}"/>>Content</option>
		<option value="w" <c:out value="${cri.searchType eq 'w'?'selected':''}"/>>Writer</option>
		<option value="tc" <c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>Title or Content</option>
		<option value="cw" <c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>Content or Writer</option>
		<option value="tcw" <c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>Title or Content or Writer</option>
	</select>
	<input type="text" name='keyword' id="keywordInput" value='${cri.keyword}'>
	<button id='searchBtn'>Search</button>
	<button id='newBtn'>New Board</button>
</div>

<div>
	<ul>
		<c:if test="${pageMaker.prev}">
			<li><a href="listPage${pageMaker.makeSearch(pageMaker.startPage-1) }">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li <c:out value="${pageMaker.cri.page == idx?'class = active':''}"/>>
			<a href="listPage${pageMaker.makeSearch(idx)}">${idx}</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="listPage${pageMaker.makeSearch(pageMaker.endPage+1)}">&raquo;</a></li>
		</c:if>
	</ul>
</div>
</body>
</html>
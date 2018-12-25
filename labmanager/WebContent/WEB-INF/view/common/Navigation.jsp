<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/include.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="orMain.jsp"><img
			src="<c:url value="/img/MainMark.jpg"/>" width="250" height="150"></a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fa fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="manager.html">회원관리</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="orMain.jsp">소개</a>
				</li>
				<li>
					<ul>
						<li class="nav-item"><a class="nav-link">블로그1</a></li>
						<li class="nav-item"><a class="nav-link" href="#">블로그2</a></li>
						<li class="nav-item"><a class="nav-link" href="#"
							onclick="window.open('/labmanager/user/joinform')">블로그3</a></li>
					</ul>
				</li>
				<li class="nav-item"><a class="nav-link" href="orBoard.jsp">게시판</a>
				</li>
				<li class="nav-itemother"><a class="nav-link" href="#"
					onclick="window.open('orLoginForm.jsp','Login','width=350 height=100')">로그인</a></li>
				<li class="nav-itemother"><a class="nav-link" href="#"
					onclick="window.open('orJoinForm.jsp','Join','width=400 height=400')">회원가입</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
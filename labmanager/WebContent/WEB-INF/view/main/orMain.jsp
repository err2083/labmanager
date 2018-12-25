<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<!--
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>유비쿼터스에 오신걸 환영합니다.</title>
		-->
<!-- Bootstrap core CSS -->
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template -->
<link href="<c:url value="/css/clean-blog.min.css"/>" rel="stylesheet"
	type="text/css">

<!-- Custom fonts for this template -->
<link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

</head>
<body>
	<jsp:include page="/WEB-INF/view/common/Navigation.jsp" flush="true" />
	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('img/home-bg.jpg')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="site-heading">
					<h1>연구실 소개</h1>
					<span class="subheading">머신러닝, 웹, 아두이노 ...</span>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="post-preview">
					<h2 class="post-title">첫번째 타이틀</h2>
					<h3 class="post-subtitle">내용</h3>
					<p class="post-meta">...</p>
				</div>
				<hr>
				<div class="post-preview">
					<h2 class="post-title">두번째 타이틀</h2>
					<h3 class="post-subtitle">내용</h3>
					<p class="post-meta">...</p>
				</div>
				<hr>
				<div class="post-preview">
					<h2 class="post-title">세번째 타이틀</h2>
					<h3 class="post-subtitle">내용</h3>
					<p class="post-meta">...</p>
				</div>
				<hr>
				<div class="post-preview">
					<h2 class="post-title">네번째 타이틀</h2>
					<h3 class="post-subtitle">내용</h3>
					<p class="post-meta">...</p>
				</div>
				<hr>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/common/Footer.jsp" flush="true"></jsp:include>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/clean-blog.min.js"></script>

</body>
</html>
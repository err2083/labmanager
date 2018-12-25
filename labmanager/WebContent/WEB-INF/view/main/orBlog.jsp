<%@include file="/WEB-INF/view/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>OOO 블로그</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <script src="<c:url value="/js/html5shiv.js"/>"></script>
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css">
    <!-- <link rel="stylesheet" href="/css/ie8.css"/>
    <link rel="stylesheet" href="/css/ie9.css"/> -->
</head>
<body>
<div id="header">
    <div class="top">
        <div id="logo">
            <span class="image avatar48"><img src="img/avatar.jpg" alt=""/></span>
            <h1 id="title">이름</h1>
            <p>부가설명</p>
        </div>
        <nav id="nav">
            <ul>
                <li><a href="#top" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">첫번째 페이지</span></a>
                </li>
                <li><a href="#portfolio" id="portfolio-link" class="skel-layers-ignoreHref"><span class="icon fa-th">두번째 페이지</span></a>
                </li>
                <li><a href="#about" id="about-link" class="skel-layers-ignoreHref"><span class="icon fa-user">세번째 페이지</span></a></li>
                <li><a href="#contact" id="contact-link" class="skel-layers-ignoreHref"><span class="icon fa-envelope">Contact 페이지</span></a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="bottom">
        <ul class="icons">
            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
            <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
        </ul>
    </div>
</div>

<div id="main">
    <section id="top" class="one dark cover">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="post-preview">
                            <h2 class="post-title">
                                첫번째 타이틀
                            </h2>
                            <h3 class="post-subtitle">
                                서브 타이틀
                            </h3>
                        <p class="post-meta">
                            게시날짜
                        </p>
                    </div>
                    <hr>
                </div>
                </div>
            </div>
    </section>

    <!-- Portfolio -->
    <section id="portfolio" class="two">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="post-preview">
                        <a href="post.html">
                            <h2 class="post-title">
                                두번째 타이틀
                            </h2>
                            <h3 class="post-subtitle">
                                서브 타이틀
                            </h3>
                        </a>
                        <p class="post-meta">
                            게시날짜
                        </p>
                    </div>
                    <hr>
                </div>
            </div>
            </div>
    </section>

    <section id="about" class="three">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="post-preview">
                        <a href="post.html">
                            <h2 class="post-title">
                                세번째 타이틀
                            </h2>
                            <h3 class="post-subtitle">
                                서브 타이틀
                            </h3>
                        </a>
                        <p class="post-meta">
                            게시날짜
                        </p>
                    </div>
                    <hr>
                </div>
            </div>
            </div>
    </section>
    
    <!-- Contact -->
    <section id="contact" class="four">
        <div class="container">
            <header>
                <h2>Contact 페이지</h2>
            </header>

            <form method="post" action="#">
                <div class="row">
                    <div class="6u 12u$(mobile)"><input type="text" name="name" placeholder="Name"/></div>
                    <div class="6u$ 12u$(mobile)"><input type="text" name="email" placeholder="Email"/></div>
                    <div class="12u$">
                        <textarea name="message" placeholder="Message"></textarea>
                    </div>
                    <div class="12u$">
                        <input type="submit" value="Send Message"/>
                    </div>
                </div>
            </form>

        </div>
    </section>

</div>

<!-- Footer -->
<div id="footer">

    <!-- Copyright -->
    <ul class="copyright text-muted">
        <li>&copy; Footer</li>
        <li>Design: <a href="http://html5up.net">링크</a></li>
    </ul>

</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/jquery.scrollzer.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!--[if lte IE 8]>
<script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="assets/js/main.js"></script>

</body>
</html>
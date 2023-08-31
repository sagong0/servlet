<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>모바일 로그인 페이지</title>
</head>
<script>
	function login(){
		
	}
</script>
<body>
<header>
<%@ include file="./top.jsp" %>
</header><!-- 메뉴 또는 로그인  -->

<main><!-- banner, 입력.......모든 웹을 구성 -->
<form name="f" method="post" action="./mlogin.do">
	<section>
		<p>Member-Login</p>
		아이디 : <input type="text" name="mid" required="required"><br>
		패스워드 : <input type="password" name="mpass" required="required"><br>
		<button type="submit">Login!</button>
	</section>
</form>
</main>
<footer>	<!-- copyright -->
<%@ include file="./copyright.jsp" %>
</footer>
</body>
<script>
/***/
var id = "<%=user_id%>";
var nm = "<%=user_nm%>";
if(id != "" || nm!=""){
	location.href="./index2.jsp";
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String shopping_id = "";
String shopping_name = "";
	try{
		shopping_id = session.getAttribute("userid").toString();
		shopping_name = session.getAttribute("username").toString();
		session.invalidate();
	}
	catch(NullPointerException e){
	}
	
%>
<meta charset="UTF-8">
<script>
window.onload = function(){
	alert("로그아웃 되셧슨비다.");
	location.href="./login.jsp";
}
</script>

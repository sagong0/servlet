<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 문자열로 getAttribute 변환
	/*
	변환 방식 : (String), toString(), String.valueOf()
	*/
	String url = request.getAttribute("dbfile").toString();
	//out.print('alert') 이방식도 가능.
%>    
 <script>
 alert("정상적으로 첨부파일이 저장 완료 되었습니다.");
 </script>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시물 확인</title>
</head>
<body>
<a href="<%=url%>">[첨부파일]</a>
</body>
</html>
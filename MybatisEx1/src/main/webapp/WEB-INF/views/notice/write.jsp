<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
</head>
<body>
	<h1>공지사항 등록</h1>
	<form action="/notice/regist.do" method="post">
		제목 : <input type="text" name="subject"><br>
		내용 : <textarea rows="" cols="" name="content"></textarea><br>
		<input type="submit" value="작성">
		<input type="reset" value="취소">
	</form>
</body>
</html>
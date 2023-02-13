<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<h1>에러 발생</h1>
	<c:if test="${msg ne null }">
		<h2>${msg }</h2>
	</c:if>
	<c:if test="${msg eq null }">
		<h2>Null발생!!</h2>
	</c:if>
</body>
</html>
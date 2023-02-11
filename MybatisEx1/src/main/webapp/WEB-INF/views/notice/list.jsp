<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
}

:link {
	text-decoration: none;
}

:visited {
	color: gold;
}
</style>
</head>
<body>
	<h1>공지사항 목록</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${nList }" var="notice" varStatus="status">
			<tr>
				<!-- 번호는 시퀀스를 사용해서 중간에 비는번호가 발생 -->
				<%-- <td>${notice.noticeNo }</td> --%>
				<!-- 1번부터 쭉 작성해줌 -->
				<td>${status.count }</td>
				<td><a href="/notice/detail.do?notice-no=${notice.noticeNo }">${notice.noticeSubject }</a></td>
				<td>${notice.noticeWriter }</td>
				<td>${notice.noticeDate }</td>
				<td>${notice.viewCount }</td>
			</tr>
		</c:forEach>
		<tr>
			<form action="#" method="post">
			<td><select>
					<option>제목</option>
					<option>내용</option>
					<option>작성자</option>
			</select></td>
			<td colspan="3"><input style="width: 100%; box-sizing: border-box;" type="text"></td>
			<td><input type="submit" value="검색"></td>
			</form>
		</tr>
		<tr>
			<td colspan="5" align="center">${pageNavi }</td>
		</tr>
	</table>
</body>
</html>
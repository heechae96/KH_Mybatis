<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 조회</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>공지사항 상세 조회</h1>
	<h3>제목 : ${notice.noticeSubject }</h3>
	<p>
		<strong>내용 : </strong>${notice.noticeContent }</p>
	작성자 : ${notice.noticeWriter }
	<br> 작성일 : ${notice.noticeDate }
	<br> 조회수 : ${notice.viewCount }
	<br>
	<br>
	<br>
	<a href="/notice/list.do">목록으로</a>
	<a href="/notice/modify.do?notice-no=${notice.noticeNo }">수정하기</a>
	<!-- <a href="javascript:void(0)" onclick="deleteCheck()">삭제하기</a> -->
	<form action="/notice/remove.do" method="post">
		<input type="hidden" name="notice-no" value="${notice.noticeNo }">
		<input type="submit" value="삭제하기" onclick="return deleteChk()">
	</form>
	<script>
		function deleteChk() {
			if (confirm("정말로 삭제하시겠습니까?")) {
				return true;
			} else {
				return false;
			}
		}
		/* function deleteCheck() {
			// 기본 이벤트 제거
			event.preventDefault();
			if(confirm("정말로 삭제하시겠습니까?")){
				console.log("삭제 완료");
				location.href = "/notice/remove.do?notice-no=";
			}else{
				console.log("삭제 취소");
			}
		} */
	</script>
</body>
</html>
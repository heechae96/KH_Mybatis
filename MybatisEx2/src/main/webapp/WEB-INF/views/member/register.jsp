<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
#registerTable {
	margin: auto;
}
</style>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp" />
	<h1>회원가입</h1>
	<form action="/member/register.do" method="post">
		<table id="registerTable">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="member-id" required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="member-pw" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="member-name" required></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input name="member-age" type="text"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="member-email" type="text"></td>
			</tr>
			<tr>
				<td>폰번호</td>
				<td><input name="member-phone" type="text"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input name="member-addr" type="text"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>남<input name="member-gender" type="radio" value="M">
					여<input name="member-gender" type="radio" value="F"></td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input name="member-hobby" type="text"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="submit" value="제출"> 
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
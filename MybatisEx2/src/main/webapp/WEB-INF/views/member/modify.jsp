<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../common/menuBar.jsp" />
	<form action="/member/modify.do" method="post">
		<h1 style="margin: 10px 0px">정보 수정</h1>
		<table class="table">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="member-id" class="form-control"
					value="${mOne.memberId }" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="member-pw"
					class="form-control" value="${mOne.memberPw }" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="member-name" class="form-control"
					value="${mOne.memberName }" readonly></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input name="member-age" class="form-control"
					value="${mOne.memberAge }" type="text" readonly></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="member-email" class="form-control"
					value="${mOne.memberEmail }" type="text"></td>
			</tr>
			<tr>
				<td>폰번호</td>
				<td><input name="member-phone" class="form-control"
					value="${mOne.memberPhone }" type="text"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input name="member-addr" class="form-control"
					value="${mOne.memberAddr }" type="text"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>남<input name="member-gender" type="radio" value="M" <c:if test="${mOne.memberGender eq 'M' }">checked</c:if>>
					여<input name="member-gender" type="radio" value="F" <c:if test="${mOne.memberGender eq 'F' }">checked</c:if>></td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input name="member-hobby" class="form-control"
					value="${mOne.memberHobby }" type="text"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					class="btn btn-xs btn-success" value="제출"> <a type="reset"
					class="btn btn-xs btn-warning">뒤로</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
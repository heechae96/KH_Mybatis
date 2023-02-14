<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
	text-align: center;
}

.menu {
	/* td요소처럼 보이게 해줌 */
	display: table-cell;
	width: 20vw;
	height: 50px;
	text-align: center;
	vertical-align: middle;
	font-size: 20px;
	background-color: #60C6FE;
	color: black;
}

.menu:hover {
	background-color: #568DE5;
	cursor: pointer;
}

.mainTable {
	float: right;
	table-collapse: collapse;
}

.login-area {
	height: 80px;
}

:link, :visited {
	text-decoration: none;
	color: black;
}

a:hover {
	font-size: large;
}
</style>
</head>
<body>
	<h1>Welcome to MybatisWeb</h1>
	<br>
	<div class="login-area">
		<c:if test="${sessionScope.member eq null }">
			<form action="/member/login.do" method="post">
				<table class="mainTable">
					<tr>
						<td>아이디 :</td>
						<td><input type="text" name="member-id"></td>
						<td rowspan="2"><button style="height: 60px">로그인</button></td>
						<td rowspan="2"><button type="button" onclick="goRegister()" style="height: 60px">회원가입</button></td>
					</tr>
					<tr>
						<td>비밀번호 :</td>
						<td><input type="password" name="member-pw"></td>
					</tr>
				</table>
			</form>
		</c:if>
		<!-- sessionScope는 생략 가능 -->
		<c:if test="${member ne null }">
			<table class="mainTable">
				<tr>
					<td><b>${member.memberName }</b>님 환영합니다!!</td>
				</tr>
				<tr>
					<td><a href="/member/logout.do">로그아웃</a></td>
				</tr>
			</table>
		</c:if>
	</div>
	<div>
		<div class="menu" onclick="javascript:location.href='/'">HOME</div>
		<div class="menu" onclick="moveMemberList()">멤버목록</div>
		<div class="menu" onclick="">강좌목록</div>
		<div class="menu" onclick="">게시판</div>
		<div class="menu" onclick="">ETC</div>
	</div>
	<script type="text/javascript">
		function moveMemberList() {
			location.href = "/member/list.do";
		}
		
		function goRegister() {
			location.href = "/member/register.do";
		}
	</script>
</body>
</html>
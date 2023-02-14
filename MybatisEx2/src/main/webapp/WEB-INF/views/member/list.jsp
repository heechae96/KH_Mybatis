<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맴버 목록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style type="text/css">
	main{
		width: 70vw;
		margin: auto;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<h1>멤버 목록</h1>
	<main>
		<div>
			<table class="table table-hover table-condensed">
				<colgroup>
					<col width="80" align="center">
					<col width="200">
					<col width="200">
					<col width="300">
					<col width="100">
					<col width="100">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>회원ID</th>
						<th>이름</th>
						<th>주소</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mList }" var="member" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${member.memberId }</td>
							<td>${member.memberName }</td>
							<td>${member.memberAddr }</td>
							<td><c:if
									test="${sessionScope.member.memberId eq member.memberId }">
									<a class="btn btn-xs btn-warning" onclick="checkMod()">UPDATE</a>
								</c:if></td>
							<td><c:if
									test="${sessionScope.member.memberId eq member.memberId }">
									<a class="btn btn-xs btn-danger" onclick="checkDel()">DELETE</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<td colspan="6" align="center">
						${pageNavi }
					</td>
				</tfoot>
			</table>
		</div>
	</main>
	<script type="text/javascript">
		function checkDel() {
			if (confirm("정말로 삭제하시겠습니까?")) {
				location.href = "/member/delete.do";
			} else {
				return false;
			}
		}
		function checkMod() {
			if (confirm("정말로 수정하시겠습니까?")) {
				location.href = "/member/modify.do"
			} else {
				return false;
			}
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
</head>
<body>
	<h1>Index Page</h1>
	<h1><spring:message code="hi" var="h"></spring:message></h1>
	<h3>${h}</h3>
	<img src="/images/iu1.jpg">
		<sec:authorize access="!isAuthenticated()">
			<a href="/member/add">회원가입</a>
			<a href="/member/login">로그인</a>		
			<a href="/oauth2/authorization/kakao">Kakao Login</a>	
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="Principal" var="user"/>
			<h3><spring:message code="welcome" arguments="${user.name}"></spring:message></h3>
			<h3><spring:message code="welcome2" arguments="${user.id},${user.name}" argumentSeparator=","></spring:message></h3>
			<form action="/member/logout" method="post" id="frmLogout">
				<sec:csrfInput/>
				<button id="logout">Logout</button>
			</form>
			<a href="/member/mypage">마이페이지</a>	
		</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">
			<a href="/admin">Admin</a>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
			<a href="/manager">Manager</a>

		</sec:authorize>
		
	<a href="/qna/list?page=1">QnA</a>
	<div>
		
		<img src="/file/qna/0ec2d593-8c67-41da-857c-834ffe3955d2_iu2.jpg">
		<img src="/file/notice/lightIcon.png">
		<a href="/fileDown/qna?fileNum=2">QnaDown</a>
		<a href="/fileDown/notice?fileNum=2">NoticeDown</a>
	</div>

	<button id="btn">Click</button>
	<button class="buttons">BTN1</button>
	<button class="buttons">BTN2</button>
	<button class="buttons">BTN3</button>

	<div id="test">
		
	</div>
	<script src="/js/test.js"></script>
	<script type="text/javascript">
		$("#logout").click(function() {
			$("#frmLogout").submit();
		})
	</script>
</body>
</html>
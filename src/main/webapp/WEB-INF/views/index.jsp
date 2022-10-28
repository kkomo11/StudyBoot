<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	<c:choose>
		<c:when test="${member eq null}">
			<a href="/member/add">회원가입</a>
			<a href="/member/login">로그인</a>	
		</c:when>
		<c:otherwise>
			<h3><spring:message code="welcome" arguments="${member.name}"></spring:message></h3>
			<h3><spring:message code="welcome2" arguments="${member.id},${member.name}" argumentSeparator=","></spring:message></h3>
			<a href="/member/logout">로그아웃</a>
			<c:forEach items="${member.roleVOs}" var="roleVO">
				<div>${roleVO.roleName}</div>
			</c:forEach>		
		</c:otherwise>
	</c:choose>
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
</body>
</html>
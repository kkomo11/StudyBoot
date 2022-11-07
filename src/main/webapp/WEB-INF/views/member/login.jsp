<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/boot.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<section class="container" style="width: 60%;">
		<form action="/member/login" method="post">
			${param.message}
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="input-group mb-3">
				<span class="input-group-text">Id</span>
				<input type="text" class="form-control" id="id" name="id" value="${cookie.userID.value}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Password</span>
				<input type="password" class="form-control" id="pw" name="pw" value="admin1" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			
			<div>
				<span>아이디저장</span>
				<input type="checkbox" name="rememberMe">
			</div>
			
			<button class="btn btn-primary" type="submit">LogIn</button>
		</form>
	</section>
	
</body>
</html>
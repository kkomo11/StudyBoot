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
	<h1>Join Page</h1>
	
	<section class="container" style="width: 60%;">
		<form action="add" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text">Id</span>
				<input type="text" class="form-control" id="id" name="id" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Password</span>
				<input type="password" class="form-control" id="pw" name="pw" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Name</span>
				<input type="text" class="form-control" id="name" name="name" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Email</span>
				<input type="text" class="form-control" id="email" name="email" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			
			<button class="btn btn-primary" type="submit">JOIN</button>
		</form>
	</section>
</body>
</html>
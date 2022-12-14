<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<c:import url="../temp/boot.jsp"></c:import>
			<title>Insert title here</title>
			<script defer src="/js/memberAdd.js"></script>
			<script defer src="/js/util.js"></script>
		</head>
<body>
	<h1>Join Page</h1>
	
	<section class="container" style="width: 60%;">
		<form action="add" method="post" id="frmJoin">
			<div class="input-group mb-3">
				<span class="input-group-text">Id</span>
				<input type="text" class="form-control" id="id" name="id" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<div id="check_id"></div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Password</span>
				<input type="password" class="form-control" id="pw" name="pw" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<div id="check_pw"></div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">RePassword</span>
				<input type="password" class="form-control" id="pw2" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<div id="check_pw2"></div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Name</span>
				<input type="text" class="form-control" id="name" name="name" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<div id="check_name"></div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Email</span>
				<input type="text" class="form-control" id="email" name="email" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<div id="check_email"></div>
			
			<button class="btn btn-primary" type="button" id="btnJoin">JOIN</button>
		</form>
		<div>
			<button type="button" id="test">Test</button>
			<button type="button" id="test2">Test2</button>
			<button type="button" id="test3">Test3</button>
		</div>
		<div>
			<div>
				ALL <input type="checkbox" id="all">
			</div>

			<div>
				??????1 <input type="checkbox" class="check">
				<div>?????? 1</div>
			</div>
			
			<div>
				??????2 <input type="checkbox" class="check">
				<div>?????? 2</div>
			</div>

			<div>
				??????3 <input type="checkbox" class="check">
				<div>?????? 3</div>
			</div>
		</div>

		<div>
			<select id="s1">
				<option value="">1</option>
				<option value="">2</option>
			</select>
			<button type="button" id="s1Add">Add</button>
		</div>
	</section>
</body>
</html>
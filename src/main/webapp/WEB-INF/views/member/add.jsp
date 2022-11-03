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
		<form:form modelAttribute="memberVO" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text">Id</span>
				<form:input path="id" cssClass="form-control" id="id"/>
				<form:errors path="id"></form:errors>
			</div>
			<div id="check_id"></div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Password</span>
				<form:password path="pw" cssClass="form-control" id="pw"/>
			</div>
			<div id="check_pw"></div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">RePassword</span>
				<form:password path="pw2" cssClass="form-control" id="pw2"/>
			</div>
			<div id="check_pw2"></div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Name</span>
				<form:input path="name" cssClass="form-control" id="name"/>
			</div>
			<div id="check_name"></div>
			
			<div class="input-group mb-3">
				<span class="input-group-text">Email</span>
				<form:input path="email" cssClass="form-control" id="email"/>
			</div>
			<div id="check_email"></div>
			
			<button class="btn btn-primary" type="submit" id="btnJoin">JOIN</button>
		</form:form>
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
				동의1 <input type="checkbox" class="check">
				<div>약관 1</div>
			</div>
			
			<div>
				동의2 <input type="checkbox" class="check">
				<div>약관 2</div>
			</div>

			<div>
				동의3 <input type="checkbox" class="check">
				<div>약관 3</div>
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
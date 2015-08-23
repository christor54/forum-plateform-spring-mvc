<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myStyle.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forum Plateform</title>
</head>
<body>

	<div class="container">
		<jsp:include page="menu.jsp"></jsp:include>

		
			<div class="well">
	
				<h3>Forums</h3>
				
				<c:forEach items="${forums}" var="forum">
					<form action="${pageContext.request.contextPath}/goToForumPage" >
						<input type="hidden" name="forumId" value="${forum.id}" >
					 	<input class="btn btn-default btn-forum" type="submit" name="${forum}" value="${forum.title}"/>
					</form>
				</c:forEach>
<%-- 				<a href="goToForumPage/${forum.id}">${forum.title}</a> --%>
				<h3>Add a forum</h3>
				
				<form:form class="form-horizontal " action="${pageContext.request.contextPath}/addForum" method="post" commandName="forum">
					<p> Enter forum title :</p>
					<form:errors class=" "path="title"/>
					<form:input class="form-control" type="text" name="title" path="title"/> 
					<br>
					<p> Enter forum description :</p>
<%-- 					<form:input class="form-control" type="textarea" rows="3" name="description" path="description"/> <form:errors path="description"/> --%>
					<div class="has-error"><form:errors path="description" class="has-error"/></div>
					<textarea class="form-control" rows="3" name="description" path="description"></textarea>
					
					<br> 
					<input class="btn btn-primary" type="submit" value="Add Forum"/>
				</form:form>
				
				
			</div>
	</div>
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script src="/js/checked-list.js"></script>
</body>
</html>
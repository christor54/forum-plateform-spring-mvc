<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<div class="container">
		<h2 class="form-signin-heading">Please sign in</h2>
		<form:form class="form-horizontal " action="${pageContext.request.contextPath}/tryToLogin" method="post" commandName="person"> 
			
			<div class="form-group">
				<label for="usernameRegister"  class="col-sm-2 control-label">username :</label>
				<div class="col-sm-3">
					<form:input class="form-control" type="text" name="username" path="username"/> <form:errors path="username"/>
			 
				</div>
			</div>
			<div class="form-group">
				<label for="passwordRegister"  class="col-sm-2 control-label">password :</label>
				<div class="col-sm-3">
					 <form:input  class="form-control" type="password" name="password" path="password"/> <form:errors path="password" />
				</div>
			</div>
			<div class="form-group">
	    		<div class="col-sm-offset-2 col-sm-10">
			 		<input class="btn" type="submit" value=" Log in"/>
				</div>
	  		</div>
		
		</form:form>
	</div>	
</body>
</html>
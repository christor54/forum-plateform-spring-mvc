<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal " action="login.do" method="post" >
			<h2 class="form-signin-heading">Please sign in</h2>
			
	<%-- 		<div class="alert alert-danger"><span class="glyphicon glyphicon-alert"></span><strong> ${message}</strong></div> --%>
			
			<div class="form-group">
				<label for="usernameRegister"  class="col-sm-2 control-label">username :</label>
				<div class="col-sm-3">
			 		<input id="usernameRegister" class="form-control" type="text" name="usernameIn" />
				</div>
			</div>
			<div class="form-group">
				<label for="passwordRegister"  class="col-sm-2 control-label">password :</label>
				<div class="col-sm-3">
					<input id ="passwordRegister" class="form-control" type="password" name="passwordIn" /> 
				</div>
			</div>
			<div class="form-group">
	    		<div class="col-sm-offset-2 col-sm-10">
			 		<input class="btn" type="submit"  value="submit">
				</div>
	  		</div>
		</form>
	</div>
</body>
</html>
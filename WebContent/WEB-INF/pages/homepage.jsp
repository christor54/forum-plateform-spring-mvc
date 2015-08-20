<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet" href="/OrderPizza/css/PizzaStore.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza Store</title>
</head>
<body>

	<div class="container">
		<jsp:include page="menu.jsp"></jsp:include>

		<form action="addPizza.do">
			<div class="well">

				<h3>Size</h3>
				<select name="size" class="form-control  ">
					<c:forEach items="${pizzaSizes}" var="pizzaSize">
						<option value="${pizzaSize.id}">${pizzaSize}</option>
					</c:forEach>
				</select>


				<h3>Toppings</h3>

				<ul id="check-list-box" class="list-group checked-list-box">
					<c:forEach items="${pizzaToppings}" var="topping">
						<li class="list-group-item"><label class='labelcb'> 
						<input	type="checkbox" name="toppings" value="${topping.id}">
								${topping}
						</label></li>
					</c:forEach>
				</ul>
				<br />
				<input class="submit btn btn-primary col-xs-12"  type="submit" id="get-checked-data" value="Add	pizza to orders"></input>

				
				<br>
				<br>
				<p>you current order, total :</p>
				<c:if test="${not empty order.pizzas }">
				
					<ul class="list-group">
						<c:forEach items="${order.pizzas}" var="pizza">
							<li class="list-group-item"><p class="text-left">${pizza} </p> <p class="text-right">10 $</p></li>
						</c:forEach>
					</ul>
				</c:if>
				
				<form action="submitOrder.do">
				
					<input disabled="disabled" type="submit" class="submit col-xs-12" value="Submit order" />
				
				</form>
			</div>
		</form>
	</div>
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script src="/js/checked-list.js"></script>
</body>
</html>
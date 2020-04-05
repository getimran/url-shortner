<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<head>
<link href="css/main.css" rel="stylesheet">
<title>URL Shortner</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">URL Shortner</a>
			</div>
			<!--     <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul> -->

		</div>
	</nav>
	<c:if test="${not empty errorMessage}">
		<div class="container">
			<font color="red">${errorMessage}</font> <br />
		</div>
	</c:if>

	<div class="container">

		<br />
		<form action="/short" method="post">
			<div class="form-group">
				<label for="email">Short URL:</label> <input type="url" name="url"
					class="form-control" id="url" placeholder="Paste your url here">
			</div>
			 <button style="align-self: center;" type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

	<c:if test="${not empty shortenUrl}">
		<div class="container">
			<br />
			<h3>Shorten URL</h3>
			<c:if test="${empty errorMessage}">
				<a href="/goto/${shortenData.urlKey}" target="_blank">${shortenUrl}</a>
			</c:if>

		</div>
	</c:if>

<!-- Footer -->
<footer id="footer">

  <!-- Copyright -->
  <h3>© 2020 Copyright:
    <a href="mailto:mailmeinfo.imran@gmail.com"> Imran</a>
  </h3>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>
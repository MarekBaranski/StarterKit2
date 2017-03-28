<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Error 403</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Error</h1>
				<p>${errorMessage}</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="col-md-7 col-md-offset-7">
			<p>
				<a href="/webstore" class="btn btn-default"> <span
					class="glyphicon glyphicon-homen" /></span> Home
				</a>
			</p>
		</div>
	</section>
</body>
</html>

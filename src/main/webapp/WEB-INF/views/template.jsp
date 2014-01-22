<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<title>jblogger</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/resources/css/main.css" />
		<script src="http://code.jquery.com/jquery-2.0.3.js"></script>
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	</head>
	<body>
		<tiles:insertAttribute name="header" />
		
		<div class="container">
			<div class="row">
				<section class="col-lg-8">
					<tiles:insertAttribute name="body" />
				</section>
				<tiles:insertAttribute name="sidebar" />
			</div>
		</div>
	</body>
</html>
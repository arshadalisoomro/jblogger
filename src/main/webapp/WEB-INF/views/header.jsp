<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="navbar navbar-fixed-top" role="banner">
	<div class="container">
		<div class="navbar-header">
			<a href="/" class="navbar-brand">JContacts</a>
		</div>
		<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		    <ul class="nav navbar-nav">
		    	<li><a href="/posts">Articles</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		    <sec:authorize access="isAuthenticated()"> 
		    	<li>
		    		<a href="/j_spring_security_logout">Hi, <sec:authentication property="principal.username" />. Logout!</a>
		    	</li>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<li>
					<a href="/spring_security_login">Hi, Guest. Login!</a>
				</li>
			</sec:authorize>
			</ul>
		</nav>
	</div>
</div>
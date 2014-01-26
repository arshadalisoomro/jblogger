<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a href="/" class="navbar-brand">Contacts</a>
		</div>
		<a href="/posts">pOsTs</a>
		<sec:authorize access="isAuthenticated()"> 
			Welcome, <sec:authentication property="principal.username" />
		</sec:authorize>
	</div>
</div>
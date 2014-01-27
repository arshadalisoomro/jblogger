<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<article>
	<header class="page-header">
		<h1><c:out value="${post.title}" />&nbsp;<time datetime="${post.published}" class="small">Published on <fmt:formatDate value="${post.published}" /></time></h1>
	</header>
	
	<ul class="list-unstyled">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/posts/${post.id}/edit" class="btn btn-info btn-large">Edit post</a></li>
			<li><c:import url="/WEB-INF/views/post/partials/deleteForm.jsp" /></li>
		</sec:authorize>
		<li><a href="/posts">&laquo; Back</a></li>
		<li><a href="#comments"><span class="glyphicon glyphicon-star-empty"></span>&nbsp;${fn:length(post.comments)} Comments</a></li>
	</ul>
	
	<div class="flowline-sml">
		<c:out value="${post.body}" escapeXml="false" />
	</div>
	
	<footer>
		<%@ include file="/WEB-INF/views/post/partials/comments.jsp" %>
	</footer>
</article>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="page-header">
	<h1><c:out value="${post.title}" />&nbsp;<time datetime="${post.published}" class="small">Published on <fmt:formatDate value="${post.published}" /></time></h1>
</div>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="/posts/${post.id}/edit" class="btn btn-info btn-large">Edit post</a>
	<c:import url="/WEB-INF/views/post/partials/deleteForm.jsp" />
</sec:authorize>

<a href="/posts">&laquo; Back</a><br />
<a href="#comments"><span class="glyphicon glyphicon-star-empty"></span>&nbsp;${fn:length(post.comments)} Comments</a>

<c:out value="${post.body}" escapeXml="false" />

<section id="comments">
	<sec:authorize access="hasAnyRole('USER','ADMIN')">
		<a href="/posts/${post.id}/comments/new" class="btn btn-default">
			<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;Add a comment
		</a>
	</sec:authorize>
	<sec:authorize access="!hasAnyRole('USER','ADMIN')">
		<a href="/spring_security_login">
			<span class="glyphicon glyphicon-star-empty"></span>&nbsp;Log in to add a comment!
		</a>
	</sec:authorize>
	
	<c:forEach items="${post.comments}" var="comment">
		<article>
			${comment.body} by ${comment.username}
		</article>
	</c:forEach>
</section>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="page-header">
	<h1><c:out value="${post.title}" />&nbsp;<time datetime="${post.published}" class="small">Published on <fmt:formatDate value="${post.published}" /></time></h1>
</div>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="/posts/${post.id}/edit" class="btn btn-info btn-large">Edit post</a>
	<c:import url="/WEB-INF/views/post/partials/deleteForm.jsp" />
</sec:authorize>

<a href="/posts">&laquo; Back</a>
<a href="#comments">Comments</a>

<c:out value="${post.body}" escapeXml="false" />

<section id="comments">
	<a href="/posts/${post.id}/comments/new" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;Add a comment</a>
	<c:forEach items="${post.comments}" var="comment">
		<article>
			${comment.body} by ${comment.user.login}
		</article>
	</c:forEach>
</section>
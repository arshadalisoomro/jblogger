<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="page-header">
	<h1>New Comment</h1>
</div>

<a href="/posts">&laquo; Cancel and return to post</a>

<div class="flowline-med">
	<c:import url="/WEB-INF/views/comment/partials/form.jsp">
		<c:param name="post" value="${post}" />
		<c:param name="formMethod" value="post" />
		<c:param name="formAction" value="/posts/${post.id}/comments" />
		<c:param name="formButtonLabel" value="Post comment" />
	</c:import>
</div>
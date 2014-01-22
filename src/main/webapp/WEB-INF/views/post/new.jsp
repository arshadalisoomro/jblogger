<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="page-header">
	<h1>New post</h1>
</div>

<a href="/posts">&laquo; Back</a>

<div class="flowline-med">
	<c:import url="/WEB-INF/views/post/partials/form.jsp">
		<c:param name="post" value="${post}" />
		<c:param name="formMethod" value="post" />
		<c:param name="formAction" value="/posts" />
		<c:param name="formButtonLabel" value="Create" />
	</c:import>
</div>
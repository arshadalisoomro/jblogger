<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page-header">
	<h1>New post</h1>
</div>

<div class="flowline-med">

	<c:import url="/WEB-INF/views/post/partials/form.jsp">
		<c:param name="post" value="${post}" />
		<c:param name="formMethod" value="put" />
		<c:param name="formAction" value="/posts/${post.id}" />
		<c:param name="formButtonLabel" value="Update" />
	</c:import>

</div>

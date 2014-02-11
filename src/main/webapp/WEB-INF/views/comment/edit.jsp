<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section>
	<header class="page-header">
		<h1>Edit Your Comment</h1>
	</header>
	
	<a href="/posts/${post.id}">&laquo; Cancel and return to post</a>
	
	<div class="flowline-med">
		<c:import url="/WEB-INF/views/comment/partials/form.jsp">
			<c:param name="formMethod" value="put" />
			<c:param name="formAction" value="/posts/${post.id}/comments/${comment.id}" />
			<c:param name="formButtonLabel" value="edit comment" />
		</c:import>
	</div>
</section>
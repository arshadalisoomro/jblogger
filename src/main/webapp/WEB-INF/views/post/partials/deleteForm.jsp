<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form:form method="delete" action="/post/${post.id}" commandName="post" role="form">
	<button type="submit" class="btn btn-link" data-toggle="modal" data-target="#modal">
		<span class="glyphicon glyphicon-trash"></span>&nbsp;Delete
	</button>
</form:form>

<c:import url="/WEB-INF/views/partials/modal.jsp">
	<c:param name="modalTitle" value="Delete Contact?" />
	<c:param name="modalBody" value="Are you sure you want to delete post (${post.title})?" />
</c:import>

<script>
	$('.confirm').click(function () {
		$('form').submit();
	});
</script>
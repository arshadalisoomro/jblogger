<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url value="new" var="newContactUrl" />

<section>
	<header class="page-header">
		<h1>Blog Posts <span class="small">(paginated in reverse chronological order)</span></h1>
	</header>
	
	<sec:authorize access="hasRole('ADMIN')">
		<a href="<c:url value="posts/new" />" class="btn btn-primary">New post</a>
	</sec:authorize>

	<ul class="pagination">
		<c:if test="${pager.older != null}">
			<li><a href="/posts?page=${pager.older}">&laquo; Older</a></li>
		</c:if>
		<c:if test="${pager.newer != null}">
			<li><a href="/posts?page=${pager.newer}">Newer &raquo;</a></li>
		</c:if>
	</ul>
	
	<div class="clearfix">
		<c:forEach items="${pager.posts}" var="post">
			<c:url value="posts/${post.id}" var="postUrl" />
			<article>
				<header>
					<h2>${post.title}&nbsp;<time datetime="${post.published}" class="small">Published on <fmt:formatDate value="${post.published}" /></time></h2>
				</header>
				${post.bodySummary}
				<br />
				<a href="${postUrl}">Read article <span class="glyphicon glyphicon-chevron-right"></span></a>
			</article>
		</c:forEach>
	</div>
</section>

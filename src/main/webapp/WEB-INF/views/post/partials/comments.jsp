
<sec:authorize access="isAuthenticated()">
	<c:set var="username">
		<sec:authentication property="principal.username" />
	</c:set>
</sec:authorize>

<section id="comments">
	<header>
		<h3>Comments</h3>
	</header>
	<sec:authorize access="hasAnyRole('USER','ADMIN')">
		<a href="/posts/${post.id}/comments/new" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;Add a comment
		</a>
	</sec:authorize>
	<sec:authorize access="!hasAnyRole('USER','ADMIN')">
		<a href="/spring_security_login">
			<span class="glyphicon glyphicon-star-empty"></span>&nbsp;Log in to add a comment!
		</a>
	</sec:authorize>
	<c:if test="${post.comments != null}">
		<ul class="list-group flowline-med">
			<c:forEach items="${post.comments}" var="comment">
				<li class="list-group-item">
					<article>
						<p>${comment.id}) ${comment.body}&nbsp;<strong>by ${comment.username}</strong></p>
						<c:if test="${comment.username == username}">
							<a href="/posts/${post.id}/comments/${comment.id}/edit">
								<span class="glyphicon glyphicon-edit"></span>&nbsp;Your article! Edit?
							</a>
						</c:if>
					</article>
				</li>
			</c:forEach>
		</ul>
	</c:if>
</section>
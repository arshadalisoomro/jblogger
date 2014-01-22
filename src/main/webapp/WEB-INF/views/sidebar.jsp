<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="col-lg-4">
	<div class="page-header">
		<span class="h1">Recent</span>
	</div>
	
	<ul>
		<c:forEach items="${recentPosts}" var="p">
			<li>
				<a href="/posts/${p.id}">${p.title}</a>
			</li>
		</c:forEach>
	</ul>
	
</aside>
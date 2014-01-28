<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="pull-right">
	<h2>Recent Articles</h2>
	<ul class="list-unstyled">
		<c:forEach items="${recentPosts}" var="p" varStatus="counter">
			<li>
				${p.title} &nbsp;<time datetime="${p.published}" class="small">(<fmt:formatDate value="${p.published}" />)</time>
				<p>${p.bodySummary}</p>
					
				<a href="/posts/${p.id}">Read it&nbsp;<span class="glyphicon glyphicon-chevron-right"></span></a>
			</li>
		</c:forEach>
	</ul>
</div>
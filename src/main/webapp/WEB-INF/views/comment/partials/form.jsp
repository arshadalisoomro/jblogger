<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="formMethod" value="${empty param.formMethod ? 'post' : param.formMethod}" />
<c:set var="formAction" value="${empty param.formAction ? '/' : param.formAction}" />
<c:set var="formButtonLabel" value="${empty param.formButtonLabel ? 'Save' : param.formButtonLabel}" />

<c:if test="${!empty errors}">
	<div class="alert alert-danger">
		<strong>Uh oh,</strong> Something's wrong!
	</div>
</c:if>

<form:form method="${formMethod}" action="${formAction}" commandName="comment" class="form-horizontal" role="form">
	<form:hidden path="id" />
	<c:if test="${comment.id != null}">
		<form:hidden path="post" />
	</c:if>
	
	<div class="form-group">
		<form:label path="body" cssClass="col-sm-2 control-label">Your comment</form:label>
		<div class="col-sm-10">
			<form:textarea path="body" cssClass="form-control" rows="10" />
			<form:errors path="body" cssClass="control-label" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary btn-large"><c:out value="${formButtonLabel}" /></button>
		</div>
	</div>

</form:form>
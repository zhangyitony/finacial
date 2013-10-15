
<%@ page import="test.Post" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-post" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list post">
			
				<g:if test="${postInstance?.acount}">
				<li class="fieldcontain">
					<span id="acount-label" class="property-label"><g:message code="post.acount.label" default="Acount" /></span>
					
						<span class="property-value" aria-labelledby="acount-label"><g:link controller="acount" action="show" id="${postInstance?.acount?.id}">${postInstance?.acount?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.authoritys}">
				<li class="fieldcontain">
					<span id="authoritys-label" class="property-label"><g:message code="post.authoritys.label" default="Authoritys" /></span>
					
						<g:each in="${postInstance.authoritys}" var="a">
						<span class="property-value" aria-labelledby="authoritys-label"><g:link controller="authority" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.operater}">
				<li class="fieldcontain">
					<span id="operater-label" class="property-label"><g:message code="post.operater.label" default="Operater" /></span>
					
						<span class="property-value" aria-labelledby="operater-label"><g:fieldValue bean="${postInstance}" field="operater"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.postName}">
				<li class="fieldcontain">
					<span id="postName-label" class="property-label"><g:message code="post.postName.label" default="Post Name" /></span>
					
						<span class="property-value" aria-labelledby="postName-label"><g:fieldValue bean="${postInstance}" field="postName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.role}">
				<li class="fieldcontain">
					<span id="role-label" class="property-label"><g:message code="post.role.label" default="Role" /></span>
					
						<span class="property-value" aria-labelledby="role-label"><g:link controller="role" action="show" id="${postInstance?.role?.id}">${postInstance?.role?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.unit}">
				<li class="fieldcontain">
					<span id="unit-label" class="property-label"><g:message code="post.unit.label" default="Unit" /></span>
					
						<span class="property-value" aria-labelledby="unit-label"><g:fieldValue bean="${postInstance}" field="unit"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${postInstance?.id}" />
					<g:link class="edit" action="edit" id="${postInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

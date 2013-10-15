
<%@ page import="test.Acount" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'acount.label', default: 'Acount')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-acount" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-acount" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list acount">
			
				<g:if test="${acountInstance?.acountName}">
				<li class="fieldcontain">
					<span id="acountName-label" class="property-label"><g:message code="acount.acountName.label" default="Acount Name" /></span>
					
						<span class="property-value" aria-labelledby="acountName-label"><g:fieldValue bean="${acountInstance}" field="acountName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acountInstance?.parentAcount}">
				<li class="fieldcontain">
					<span id="parentAcount-label" class="property-label"><g:message code="acount.parentAcount.label" default="Parent Acount" /></span>
					
						<span class="property-value" aria-labelledby="parentAcount-label"><g:fieldValue bean="${acountInstance}" field="parentAcount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acountInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="acount.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${acountInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acountInstance?.posts}">
				<li class="fieldcontain">
					<span id="posts-label" class="property-label"><g:message code="acount.posts.label" default="Posts" /></span>
					
						<g:each in="${acountInstance.posts}" var="p">
						<span class="property-value" aria-labelledby="posts-label"><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${acountInstance?.id}" />
					<g:link class="edit" action="edit" id="${acountInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

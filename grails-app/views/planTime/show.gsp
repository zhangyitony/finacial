
<%@ page import="test.PlanTime" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'planTime.label', default: 'PlanTime')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-planTime" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-planTime" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list planTime">
			
				<g:if test="${planTimeInstance?.acountId}">
				<li class="fieldcontain">
					<span id="acountId-label" class="property-label"><g:message code="planTime.acountId.label" default="Acount Id" /></span>
					
						<span class="property-value" aria-labelledby="acountId-label"><g:fieldValue bean="${planTimeInstance}" field="acountId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${planTimeInstance?.planTime}">
				<li class="fieldcontain">
					<span id="planTime-label" class="property-label"><g:message code="planTime.planTime.label" default="Plan Time" /></span>
					
						<span class="property-value" aria-labelledby="planTime-label"><g:formatDate date="${planTimeInstance?.planTime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${planTimeInstance?.tableId}">
				<li class="fieldcontain">
					<span id="tableId-label" class="property-label"><g:message code="planTime.tableId.label" default="Table Id" /></span>
					
						<span class="property-value" aria-labelledby="tableId-label"><g:fieldValue bean="${planTimeInstance}" field="tableId"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${planTimeInstance?.id}" />
					<g:link class="edit" action="edit" id="${planTimeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

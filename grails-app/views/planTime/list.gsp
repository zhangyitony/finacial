
<%@ page import="test.PlanTime" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'planTime.label', default: 'PlanTime')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-planTime" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-planTime" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="acountId" title="${message(code: 'planTime.acountId.label', default: 'Acount Id')}" />
					
						<g:sortableColumn property="planTime" title="${message(code: 'planTime.planTime.label', default: 'Plan Time')}" />
					
						<g:sortableColumn property="tableId" title="${message(code: 'planTime.tableId.label', default: 'Table Id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${planTimeInstanceList}" status="i" var="planTimeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${planTimeInstance.id}">${fieldValue(bean: planTimeInstance, field: "acountId")}</g:link></td>
					
						<td><g:formatDate date="${planTimeInstance.planTime}" /></td>
					
						<td>${fieldValue(bean: planTimeInstance, field: "tableId")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${planTimeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

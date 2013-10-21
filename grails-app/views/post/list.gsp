
<%@ page import="test.Post" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/baseAdmin/adminIndex')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-post" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="post.acount.label" default="Acount" /></th>
					
						<g:sortableColumn property="no" title="${message(code: 'post.no.label', default: 'No')}" />
					
						<g:sortableColumn property="operater" title="${message(code: 'post.operater.label', default: 'Operater')}" />
					
						<g:sortableColumn property="parentPost" title="${message(code: 'post.parentPost.label', default: 'Parent Post')}" />
					
						<g:sortableColumn property="postName" title="${message(code: 'post.postName.label', default: 'Post Name')}" />
					
						<th><g:message code="post.role.label" default="Role" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${postInstanceList}" status="i" var="postInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${postInstance.id}">${fieldValue(bean: postInstance, field: "acount")}</g:link></td>
					
						<td>${fieldValue(bean: postInstance, field: "no")}</td>
					
						<td>${fieldValue(bean: postInstance, field: "operater")}</td>
					
						<td>${fieldValue(bean: postInstance, field: "parentPost")}</td>
					
						<td>${fieldValue(bean: postInstance, field: "postName")}</td>
					
						<td>${fieldValue(bean: postInstance, field: "role")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${postInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

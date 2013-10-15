<%@ page import="test.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'acount', 'error')} required">
	<label for="acount">
		<g:message code="post.acount.label" default="Acount" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="acount" name="acount.id" from="${test.Acount.list()}" optionKey="id" required="" value="${postInstance?.acount?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'authoritys', 'error')} ">
	<label for="authoritys">
		<g:message code="post.authoritys.label" default="Authoritys" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${postInstance?.authoritys?}" var="a">
    <li><g:link controller="authority" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="authority" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'authority.label', default: 'Authority')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'operater', 'error')} ">
	<label for="operater">
		<g:message code="post.operater.label" default="Operater" />
		
	</label>
	<g:textField name="operater" value="${postInstance?.operater}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'postName', 'error')} ">
	<label for="postName">
		<g:message code="post.postName.label" default="Post Name" />
		
	</label>
	<g:textField name="postName" value="${postInstance?.postName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="post.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="role" name="role.id" from="${test.Role.list()}" optionKey="id" required="" value="${postInstance?.role?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'unit', 'error')} ">
	<label for="unit">
		<g:message code="post.unit.label" default="Unit" />
		
	</label>
	<g:textField name="unit" value="${postInstance?.unit}"/>
</div>


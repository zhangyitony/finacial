<%@ page import="test.Role" %>



<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="role.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${roleInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="role.posts.label" default="Posts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${roleInstance?.posts?}" var="p">
    <li><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="post" action="create" params="['role.id': roleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'post.label', default: 'Post')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'registrations', 'error')} ">
	<label for="registrations">
		<g:message code="role.registrations.label" default="Registrations" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${roleInstance?.registrations?}" var="r">
    <li><g:link controller="registration" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registration" action="create" params="['role.id': roleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registration.label', default: 'Registration')])}</g:link>
</li>
</ul>

</div>


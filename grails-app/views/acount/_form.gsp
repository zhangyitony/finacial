<%@ page import="test.Acount" %>



<div class="fieldcontain ${hasErrors(bean: acountInstance, field: 'acountName', 'error')} ">
	<label for="acountName">
		<g:message code="acount.acountName.label" default="Acount Name" />
		
	</label>
	<g:textField name="acountName" value="${acountInstance?.acountName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acountInstance, field: 'parentAcount', 'error')} required">
	<label for="parentAcount">
		<g:message code="acount.parentAcount.label" default="Parent Acount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="parentAcount" type="number" value="${acountInstance.parentAcount}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: acountInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="acount.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${acountInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acountInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="acount.posts.label" default="Posts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${acountInstance?.posts?}" var="p">
    <li><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="post" action="create" params="['acount.id': acountInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'post.label', default: 'Post')])}</g:link>
</li>
</ul>

</div>


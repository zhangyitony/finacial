<%@ page import="test.Authority" %>



<div class="fieldcontain ${hasErrors(bean: authorityInstance, field: 'authority', 'error')} required">
	<label for="authority">
		<g:message code="authority.authority.label" default="Authority" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="authority" type="number" value="${authorityInstance.authority}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorityInstance, field: 'form', 'error')} required">
	<label for="form">
		<g:message code="authority.form.label" default="Form" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="form" name="form.id" from="${test.Form.list()}" optionKey="id" required="" value="${authorityInstance?.form?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorityInstance, field: 'post', 'error')} required">
	<label for="post">
		<g:message code="authority.post.label" default="Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="post" name="post.id" from="${test.Post.list()}" optionKey="id" required="" value="${authorityInstance?.post?.id}" class="many-to-one"/>
</div>


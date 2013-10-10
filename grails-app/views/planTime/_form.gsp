<%@ page import="test.PlanTime" %>



<div class="fieldcontain ${hasErrors(bean: planTimeInstance, field: 'acountId', 'error')} required">
	<label for="acountId">
		<g:message code="planTime.acountId.label" default="Acount Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="acountId" type="number" value="${planTimeInstance.acountId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: planTimeInstance, field: 'planTime', 'error')} required">
	<label for="planTime">
		<g:message code="planTime.planTime.label" default="Plan Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="planTime" precision="day"  value="${planTimeInstance?.planTime}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: planTimeInstance, field: 'tableId', 'error')} required">
	<label for="tableId">
		<g:message code="planTime.tableId.label" default="Table Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tableId" type="number" value="${planTimeInstance.tableId}" required=""/>
</div>


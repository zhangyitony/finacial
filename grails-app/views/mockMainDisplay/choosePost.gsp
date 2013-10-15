<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  
  <g:form method = "post" action ="setAcountPost" >
	   
	   <g:select name="select" from="${postList}" optionValue="postName" />
	   <br>
<%--		<g:actionSubmit value="选择"  class = "setAcountPost"/>--%>
<input type = "submit" value = "选择">
	</g:form>
	

<%--	<g:each in="${postList}" status="i" var="post">--%>
<%--		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">--%>
<%--		--%>
<%--			<td><a href="/test/MockMain/showmain?post='${fieldValue(bean: post, field: "postName")}'&postid=">${fieldValue(bean: post, field: "postName")}</a></td>--%>
<%--		--%>
<%--		--%>
<%--		</tr>--%>
<%--	</g:each>--%>
  </div>
</body>
</html>
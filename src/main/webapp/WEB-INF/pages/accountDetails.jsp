<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<spring:url value="/mybankingapp" var="url" htmlEscape="true"/>
<div class="container">
	<form:form id="form" modelAttribute="client" method="post" action="${url}" class="form-signin">
	     <div class="form-group">
		</div>
	</form:form>
	<div class="col-md-5">
		${cont.iban}<br><br>
		${cont.balanta}
	</div>
</div>

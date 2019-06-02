<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:useBean id="client" class="com.bzzz.sda.BankingApp.model.Client" scope="session"></jsp:useBean>
${user}
<spring:url value="/quiz" var="url" htmlEscape="true"/>
<div class="container">
	<form:form id="form" modelAttribute="client" method="post" action="${url}" class="form-signin">
	     <div class="form-group">
			<form:button class="btn btn-lg btn-primary btn-block">Start quiz</form:button>
		</div>
	</form:form>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/accountDetails" var="login" htmlEscape="true"/>

<div class="container">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h2 class="form-signin-heading">Sign In</h2>

        <form:form id="form" modelAttribute="client" method="post" action="${login}" class="form-signin">
            <div class="form-group">
                <span>${message}</span>
                <form:label path="username">Username:</form:label>
                <form:input path="username" class="form-control"/><br><br>
                <form:label path="parola">Parola:</form:label>
                <form:password path="parola" class="form-control"/><br><br>
                <form:button class="btn btn-lg btn-primary btn-block">Login</form:button>
            </div>
        </form:form>
    </div>

    <div class="col-sm-4"></div>
</div>
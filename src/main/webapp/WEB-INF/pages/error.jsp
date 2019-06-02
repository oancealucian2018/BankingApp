<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/login" var="url" htmlEscape="true"/>

<h1>Error Page</h1>
  <p>Oouupss! Something went wrong ...</p>

    <p> Failed URL: ${url} </p>
    <p> Exception:  ${exception.message} </p>
<a href="${url}"> Go to login page</a> 
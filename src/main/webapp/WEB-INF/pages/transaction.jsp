<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/transaction" var="url" htmlEscape="true"/>

${cont.iban}
${cont.balanta}
<form:form id="form" modelAttribute="transaction" method="post" action="${url}" class="form-signin">
<div class="container">
    <table class="table table-striped">
         <tr>
             <td><form:label path="tip">Tip tranzactie</form:label></td>
             <td><form:select path="tip">
                    <form:option value="NONE" label="--- Select ---"/>
                    <form:options items="${transactionTypes}" />
                 </form:select>
             </td>
         </tr>
         <tr>
             <td><form:label path="suma">Suma:</form:label></td>
             <td><form:input path="suma" class="form-control"/></td>
         </tr>
         <tr>
             <td colspan="6"><input type="submit" name="action" value="Submit" class="btn btn-success" /></td>
         </tr>
     </table>
</div>
</form:form>
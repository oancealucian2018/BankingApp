<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <table class="table table-bordered table-striped">
         <thead>
             <tr>
                 <th>IBAN</th>
                 <th>BALANTA</th>
             </tr>
         </thead>
         <tbody>
             <tr>
                 <td>${cont.iban}</td>
                 <td>${cont.balanta}</td>
             </tr>
             <tr>
                 <td>

                 </td>
                 <td>
                     <form:form id="form" modelAttribute="cont" method="post" action="/initTransaction" class="form-signin">
                        <input type="submit" name="action" value="Initiere tranzactie" class="btn btn-success" />
                     </form:form>
                 </td>
             </tr>
         </tbody>
     </table>
</div>

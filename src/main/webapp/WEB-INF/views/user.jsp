<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<label> Selectionez Ville </label>
<select>
    <c:forEach items="${ villes }" var="ville">
    	<option> <c:out value="${ ville.nomVille }" /> </option>
    </c:forEach>
</select>
<br>
<label> Selectionez Domaine </label>
<select>
    <c:forEach items="${ domaines }" var="domaine">
    	<option> <c:out value="${ domaine.nomDomaine }" /> </option>
    </c:forEach>
</select>
<br>
<label> Selectionez Domaine </label>
<input type="text" nom = "name"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<c:forEach var="avocat" items="${listAvocat}">
	<c:out value="${avocat.nomAvocat}"></c:out><br/>
	<c:out value="${avocat.prenomAvocat}"></c:out><br/>
</c:forEach>
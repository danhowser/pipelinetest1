<%@include file="inclure.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg"%>
<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder"/>
<c:url value="/chercher" var="pagedLink">
	<c:param name="p" value="~"/>
</c:url>
<div class="row">
	<div class="col-lg-1"></div>
	<div class="col-lg-7">
<c:forEach var="avocat" items="${pagedListHolder.pageList}" >
        	   <div style=" border: 2px solid black; border-radius: 3px; margin: 1px;">
        	     <div class="avocat-info">
        		    <h2 class="avocat-titre">${avocat.nomAvocat} ${avocat.prenomAvocat}</h2><br>
        		    <h3 class="avocat-au">${avocat.telCabinet}</h3><br>
        		    <h3 class="avocat-au">${avocat.adresseAvocat}</h3><br>
        		    <p class="avocat-dec">${avocat.description}</p><br>
        		    <a href="detailAv" class="btn btn-info">Detail</a>
        		    <br>
        		    <br>
        		    <br>
        		 </div>
        		   
        		</div>
</c:forEach> 
</div>
              <div class="col-lg-3">
              		trouver un avocat
              </div>
</div>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}"/>
   		</div>


    <script src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.prettyPhoto.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.isotope.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.raty.js"/>"></script>
    <script src="<c:url value="/resources/js/main.js"/>"></script>
    <script src="<c:url value="/resources/js/wow.min.js"/>"></script>

</body>
</html>
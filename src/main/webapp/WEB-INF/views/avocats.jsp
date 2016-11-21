<%@include file="inclure.jsp" %>
<style>
	body{
		background-color: rgb(250,250,250);
	}
</style>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg"%>
<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder"/>
<c:url value="/chercher" var="pagedLink">
	<c:param name="p" value="~"/>
</c:url>
<nav class="navbar navbar-inverse nav1" role="banner" style="padding: 0; ">
<div class="container" style="width: 100%; padding: 0; ">
	<div class="row boite" id="idnav" style="width: 100%; margin: 0; background-color: #151515; border-radius: 0;">
        	<f:form class="form-inline search-container form-inputs" action="chercher" method="get" >
        	<div class="form-group col-md-3 col-lg-3 col-xs-12 col-sm-12" style="margin: 3px 0 3px 0; padding: 5px;">
			<input type="text" name="nom" class="form-control" placeholder="Avocat" style="width: 100%; height:46px; font-size: 15px; background-color: rgb(240,240,240);"/>
			</div>
        	<div class="form-group col-md-3 col-lg-3 col-xs-12 col-sm-12" style="margin: 3px 0 3px 0; padding: 5px;">
  			<select name="ville" class="form-control selectpicker" data-live-search="true" data-title="Choisir Ville" data-style="input-lg">
    			<c:forEach var="ville" items="${villeList}" >
        			<option> <c:out value="${ville.nomVille}"></c:out></option>
   				</c:forEach>
			</select>
			</div>
			<div class="form-group col-md-3 col-lg-3 col-xs-12 col-sm-12" style="margin: 3px 0 3px 0; padding: 5px;">
			<select name="domaine" class="form-control selectpicker" data-live-search="true" data-title="Choisir Domaine" data-style="input-lg" >
    			<c:forEach var="domaine" items="${domaineList}" >
        			<option> <c:out value="${domaine.nomDomaine}"></c:out></option>
   				</c:forEach>
			</select> 
			</div>
			<div class="form-group col-md-3 col-lg-3 col-xs-12 col-sm-12" style="margin: 3px 0 3px 0 ;padding: 5px;">
			<input type="submit" class="btn bouton" value="chercher" style="width: 100%; height:46px; font-family: vollkorn; font-size: 20px;"/>     
			</div>             
			</f:form>           
	</div>
</div>
</nav>
<div class="row">
	<div class="col-lg-1"></div>
	<div class="col-lg-7">
		<c:forEach var="avocat" items="${pagedListHolder.pageList}" >
        	   <div style="border-radius: 3px; padding: 10px; box-shadow: 4px 4px 10px #151515; margin: 10px; padding-right: 0; background-color: white;">
        	   		<div class="row">
        	   		<div class="col-lg-3 col-sm-3"><img src="photoAvocat?idAvocat=${avocat.idAvocat}" width="130" height="130" class="img-thumbnail"></div>
        	   		<div class="col-lg-9 col-sm-9" >
        	   			<div class="row listAv">
        		    		<div class="col-lg-6 col-sm-6"><h2 class="h3" style="margin-top: 2px; margin-bottom: 2px; padding: 2px;">${avocat.nomAvocat} ${avocat.prenomAvocat}</h2></div>
        		    		<div class="col-lg-3 col-sm-2"></div>
        		    		<div class="col-lg-3 col-sm-4"><a href="detailAvocat?id=${avocat.idAvocat}" class="btn bouton"> En savoir plus </a></div>
        		    	</div>
        		    	<div class="row" style="padding: 10px;">
        		    		<p>${fn:substring(avocat.description, 0, 75)} ...</p>
        		    	</div>
        		    	<div class="row">
        		    		<div class="col-lg-5"> 
        		    			<c:forEach var="domaine" items="${avocat.listDomaine}" end="1">
        							<div style="background-color: rgba(197,45,47,0.1); margin: 2px; padding: 5px;"><c:out value="${domaine.nomDomaine}"></c:out></div>
   								</c:forEach>
   									<div style=" margin: 2px; padding: 5px;"><a href="#"><i class="fa fa-plus-circle" aria-hidden="true"></i>
   									Plus de domaines</a></div>
   							</div>
   							<div class="col-lg-1"></div> 
   							<div class="col-lg-6"> 
        		    			<div style="margin-bottom: 4px"><strong>${avocat.ville.nomVille}</strong></div>
        		    			<div>${fn:substring(avocat.adresseAvocat, 0, 75)}</div>
   							</div>
        		    	</div>
        		    </div>
        		    </div>
        		</div>
		</c:forEach> 
		<center><tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}"/></center>
	</div>
	<div class="col-lg-3" id="map" style="margin-top: 10px; margin-left: 0;">
		
	</div>
</div>

<%@include file="inclure2.jsp" %>
<script>
$(document).ready(function(){
	var targetPos = $('#idnav').offset().top;
	console.log(targetPos);
	$(window).scroll(function(){
		var scrollPos = $(this).scrollTop();
		if(scrollPos >= targetPos){
			$('#idnav').addClass('fixed-nav');
		}else{
			$('#idnav').removeClass('fixed-nav');
		}
	});
});
</script>
<script>
        var markerLat, markerLong;
       
        markerLat = [
                     <c:forEach var="avocat" items="${pagedListHolder.pageList}" >
                         <c:out value="${avocat.latitude}"/>,
                     </c:forEach>
                 ];
                 markerLong = [
					<c:forEach var="avocat" items="${pagedListHolder.pageList}" >
						<c:out value="${avocat.longitude}"/>,
					</c:forEach>
                 ];

        function initMap() {
            var map;
            var initlatlng = new google.maps.LatLng(markerLat[0],markerLong[0]);
            var mapOptions = {
                zoom: 6,
                center: new google.maps.LatLng(33.957030069982316,-6.844482421875),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            map = new google.maps.Map(document.getElementById('map'), mapOptions);
            var infowindow = new google.maps.InfoWindow(); 
            var marker, i;

            for (i = 0; i < markerLat.length; i++) {
                marker = new google.maps.Marker({
                    position: new google.maps.LatLng(markerLat[i], markerLong[i]),
                    map: map
                });

                google.maps.event.addListener(marker, 'click', (function(marker, i) {
                    return function() {
                        infowindow.setContent(markers[i]);
                        infowindow.open(map, marker);
                    }
                })(marker, i));
            }
        }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAuB7gvDQqj3k6eDJLyLmDf2_sXl3fgcaw&signed_in=true&callback=initMap"
        async defer></script>
</body>
</html>
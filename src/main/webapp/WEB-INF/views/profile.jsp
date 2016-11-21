<%@include file="inclure.jsp" %>

<div id="prof-nom">
	<H1 class="nomprof" style="font-family: vollkorn; font-size: 30px; padding: 12px; font-weight: normal; box-shadow: 0px 2px 1px grey;" >Maître  <c:out value="${avocat.prenomAvocat}"/> <c:out value="${avocat.nomAvocat}"/></H1>
</div>
<div class="container-fluid" style="margin-top: 15px">
	<div class="row" style="margin-right: 0">
		<div class="col-md-1"></div>
		<div class="col-md-6" style="margin-right: 60px;">
		  <div class="row" style="border-bottom: 1px solid #DDDDDD; padding-bottom: 12px;">
			<div class="col-md-3"><img src="photoAvocat?idAvocat=${avocat.idAvocat}" width="140" height="140" class="img-thumbnail"></div>
			<div class="col-md-5">
				<c:forEach var="domaine" items="${avocat.listDomaine}">
        			<div style="background-color: #F5F5F5; margin: 2px; padding: 5px;"><c:out value="${domaine.nomDomaine}"></c:out></div>
   				</c:forEach>
			</div>
			<div class="col-md-4">
				<div class="row"><div class="col-md-12" style="margin-bottom: 3px;"><a href="#" class="btn bouton btnContact" > Contacter par email </a></div></div>
				<div class="row"><div class="col-md-12"><a href="#" class="btn bouton btnContact"> Contacter par Téléphone </a></div></div>
			</div>
		  </div>
		  <div class="row" style="margin-top: 14px; height: 30px">
		  	<div class="read-more">
		  		${avocat.description} 
		  	</div>
		  </div>
		</div>
		<div class="col-md-4 thumbnail lamap" style="width: 420px"><div id="map" style="height: 450px;width: 100%"></div></div>
		<div class="col-md-1"></div>
	</div>
</div>


<script>
        var markerLat, markerLong;
       
        markerLat = [
                         <c:out value="${avocat.latitude}"/>
                 ];
                 markerLong = [
						<c:out value="${avocat.longitude}"/>
                 ];

        function initMap() {
            var map;
            var initlatlng = new google.maps.LatLng(markerLat[0],markerLong[0]);
            var mapOptions = {
                zoom: 14,
                center: new google.maps.LatLng(markerLat[0],markerLong[0]),
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
		
			var readMoreHtml = $(".read-more").html();
			console.log(readMoreHtml);
			var lessText = readMoreHtml.substr(0,200);
			if(readMoreHtml.length > 200 ){
				$(".read-more").html(lessText+" ...").append("<br><a href='' class='read-more-link' ><div class='plus' style='margin: 2px'>Afficher plus</div></a>");
			}else{
				$(".read-more").html(readMoreHtml);
			}
			$("body").on("click", ".read-more-link", function(event){
				event.preventDefault();
				$(this).parent(".read-more").html(readMoreHtml).append("<br><a href='' class='show-less-link'><div class='plus'>Afficher moins</div> </a> ");
			
			});
		
			$("body").on("click", ".show-less-link", function(event){
				event.preventDefault();
				$(this).parent(".read-more").html(lessText+" ...").append("<br><a href='' class='read-more-link'><div class='plus'>Afficher plus</div> </a> ");
			
			});
			});
		</script>

</body>
</html>
<%@include file="inclure2.jsp" %>
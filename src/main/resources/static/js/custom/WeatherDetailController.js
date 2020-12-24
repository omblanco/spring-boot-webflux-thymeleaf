        "use strict";
        
        let map;
        
        function initMap() {
        
         var lat = document.getElementById('lat').value;
         var lng = document.getElementById('lng').value;
         
         var north = document.getElementById('north').value;
         var east = document.getElementById('east').value;
         var south = document.getElementById('south').value;
         var west = document.getElementById('west').value;
        
          var location = new google.maps.LatLng(lat, lng);
          var mapCanvas = document.getElementById('map');
          map = new google.maps.Map(mapCanvas, {
            center: location,
            zoom: 8
          });
          
          
          $.ajax({
                method: "GET",
                url:CONTEXT_PATH + "api/v1.0/geonames/weather?north=" + north + "&east=" + east + 
                "&south=" + south + "&west= " + west + "&lat=" + lat + "&lng=" + lng
          }).done(function(markers) {

                var markerImage = 'marker.png';
                markers.weatherObservations.forEach(function(observation) {
                    var marker = new google.maps.Marker({
                         position:  new google.maps.LatLng(observation.lat, observation.lng),
                         map: map,
                         animation: google.maps.Animation.DROP
                    });
                    
                    var templateContent = "<div class='info-window'>" + 
                       "<h4>" + observation.stationName +"</h4>" +
                       "<div class='info-content'>" +
                          "<p>Nubes: " + observation.clouds  + "</p>" +
                          "<p>Temperatura: " + observation.temperature  + "</p>" +
                          "<p>Viento: " + observation.windSpeed  + "</p>" +
                          "<p>Humedad: " + observation.humidity  + "</p>" +
                          "<p>Condición: " + observation.weatherCondition  + "</p>" +
                       "</div>" +
                       "</div>";

                    var infowindow = new google.maps.InfoWindow({
                         content: templateContent,
                         maxWidth: 400
                    });

                    marker.addListener('click', function () {
                         infowindow.open(map, marker);
                    });

                    google.maps.event.addDomListener(window, 'load', initMap);
            });
          });
        }
        
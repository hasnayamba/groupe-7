// On initialise la latitude et la longitude du Niamey (centre de la carte)
var lat = 13.521389;
var lon = 2.105278;
function initMap() {
	// Créer l'objet "macarte" et l'insèrer dans l'élément HTML qui a l'ID "map"
    macarte = L.map('map').setView([lat, lon], 11);
    
    // Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
    L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
    // Il est toujours bien de laisser le lien vers la source des données
    attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
    minZoom: 1,
    maxZoom: 20
    }).addTo(macarte);
   //L.marker([44.7675,11.3375]).addTo(macarte);
    //var marker = L.marker([44.7675,11.3375]).addTo(macarte);

}
window.onload = function(){
	// Fonction d'initialisation qui s'exécute lorsque le DOM est chargé
    initMap(); 
    
	function charger(){
    
    // on lance une requête AJAX
    $.get('index.php',function(data){
        var markers = JSON.parse(data);
        //console.log(JSON.parse(data));
        for(var i = 0; i< markers.length; i++){
            //console.log([markers[i][0], markers[i][1]]);
            L.marker([markers[i]['latitude'], markers[i]['longitude']]).addTo(macarte);
        }
       }); 
      
    }

    setInterval(charger,1000);
    
   
};

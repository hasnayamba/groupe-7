<?php 
//header(('Context-Type:application/json'));

/*
$tab=array();
$tab["succes"]=true;
$tab["message"]="jcoucou tu a bien dormir";
echo json_encode($tab);

//echo "salu";
// connextion a la bases de donné:
$dsn = 'mysql:host=localhost;dbname=tcheto;port=3306;charset=utf8';
$nom="hama";
$prenom="barhamou";

try {
    $pdo = new PDO($dsn,'root','07111989');
    //echo"connexion ressuis";
    $sql='INSERT INTO tcheto(nomUser, prenomUser) VALUES($nom, $prenom)';
 
    $pdo->exec($ql);
    //do->close();

}
catch (PDOException $exception) {
    exit('Erreur de connexion à la base de données');
}
// ajout d'element a la base de donnée:
// On ajoute une entrée dans la table jeux_video

if (!empty($_POST["Latitude"])){
    echo "la latitude recue est $Latitude";
}

if (!empty($_GET[""])){
    //echo "je viens de recevoir une requette de type get";
    // impaire pour lat et paire pour long
    $tab["lat"]=13.521389;
    $tab["lon"]=2.105278;
    echo "bonjour";
    //echo json_encode($tab);
}
*/
if (!empty($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) == 'xmlhttprequest') {
    // on effectue un traitement spécifique pour l'ajax
    $dsn = 'mysql:host=localhost;dbname=tcheto;port=3306;charset=utf8';

    try {
    $pdo = new PDO($dsn,'root','07111989');
    $sql='select longitude,latitude from SOS';
    $resultats=$pdo->query($sql);
    $donnee=$resultats->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($donnee);

    
    //echo"connexion ressuis";
    //$markers = [[13.521389,2.105278],[13.51366,2.1098],[13.532736,2.197897],[14.145,7.23139]];
   
    //echo json_encode($markers);

    }
    catch (PDOException $exception) {
    exit('Erreur de connexion à la base de données');
    }  

    
} 
else {
    // on effectue un traitement spécifique au chargement classique
    if (!empty($_GET["latitude"]) && !empty($_GET["latitude"])){
        //echo "je viens de recevoir une requette de type get";
        // impaire pour lat et paire pour long
        $tab["lat"]=13.521389;
        $tab["lon"]=2.105278;
        echo "bonjour";
        //echo json_encode($tab);
    }
    echo "pas de ajax";
}
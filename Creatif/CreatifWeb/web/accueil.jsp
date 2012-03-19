<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.Client"%>

<!doctype html>
<html lang="fr">
    <head>
        <title>Accueil - Créat'If</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="content-language" content="fr">
        <link rel="stylesheet" type="text/css" href="style.css" /> 
    </head>
    <body>
        <div class="content">
            <h1>Créat'If - Accueil</h1>
            
            <h2>Bonjour, <%= ((Client)session.getAttribute("leClient")).getPrenom() %> !</h2>

            <a href="Controleur?action=creerGalerie" class="button">Créer une galerie</a>
            <a href="Controleur?action=afficher" class="button">Afficher le catalogue</a>

            <div class="message">${message}</div>
        </div>
    </body>
</html>

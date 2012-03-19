<%-- 
    Document   : accueil.jsp
    Created on : 6 mars 2012, 16:54:05
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.Client"%>

<!doctype html>

<html lang="fr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil - Créat'If</title>
    </head>
    <body>
        <h1>Bonjour, <%= ((Client)session.getAttribute("leClient")).getPrenom() %></h1>

        <a href="Controleur?action=creerGalerie">Créer une galerie</a>
        <a href="Controleur?action=afficher">Afficher le catalogue</a>

    </body>
</html>

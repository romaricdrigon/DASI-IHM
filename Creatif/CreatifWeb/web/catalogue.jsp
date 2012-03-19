<%-- 
    Document   : index
    Created on : 6 mars 2012, 16:36:21
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modele.Oeuvre"%>
<%@page import="modele.Peinture"%>
<%@page import="modele.Sculpture"%>

<!doctype html>

<html lang="fr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue - Créat'If</title>
    </head>
    <body>
        <a href="index.jsp">Accueil</a>
        
        <h1>Catalogue</h1>

        Peintures :
        <ul>
         <%
            List<Peinture> lesPeintures = (List<Peinture>) request.getAttribute("lesPeintures");

            for (Peinture unePeinture : lesPeintures) {
         %>
            <li><%= unePeinture.getNom() %> - <%= unePeinture.getArtiste().getPrenom() + unePeinture.getArtiste().getNom() %> - <%= unePeinture.getCarac() %> - <%= unePeinture.getPrix() %></li>
         <%
            }
         %>
        </ul>
        
        Sculptures :
        <ul>
         <%
            List<Sculpture> lesSculptures = (List<Sculpture>) request.getAttribute("lesSculptures");

            for (Sculpture uneSculpture : lesSculptures) {
         %>
            <li><%= uneSculpture.getNom() %> - <%= uneSculpture.getArtiste().getPrenom() + uneSculpture.getArtiste().getNom() %> - <%= uneSculpture.getCarac() %> - <%= uneSculpture.getPrix() %></li>
         <%
            }
         %>
        </ul>       


    </body>
</html>

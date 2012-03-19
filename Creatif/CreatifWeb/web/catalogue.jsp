<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modele.Oeuvre"%>
<%@page import="modele.Peinture"%>
<%@page import="modele.Sculpture"%>

<!doctype html>
<html lang="fr">
    <head>
        <title>Catalogue - Créat'If</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="content-language" content="fr">
        <link rel="stylesheet" type="text/css" href="style.css" /> 
    </head>
    <body>
        <div class="content">
            <div class="accueil"><a href="accueil.jsp">Accueil</a></div>
            
            <h1>Détail du catalogue</h1>

            <h3>Peintures</h3>
            <table border="0" width="900">
                <thead>
                    <tr>
                        <th>Oeuvre</th>
                        <th>Artiste</th>
                        <th>Caractéristiques</th>
                        <th>Prix</th>
                    </tr>
                </thead>
                <tbody>
                 <%
                    List<Peinture> lesPeintures = (List<Peinture>) request.getAttribute("lesPeintures");

                    for (Peinture unePeinture : lesPeintures) {
                 %>
                    <tr>
                        <td><%= unePeinture.getNom() %></td>
                        <td><%= unePeinture.getArtiste().getPrenom() + " " + unePeinture.getArtiste().getNom() %></td>
                        <td><%= unePeinture.getCarac() %></td>
                        <td><%= unePeinture.getPrix() %> €</td>
                    </tr>
                 <%
                    }
                 %>
                </tbody>
            </table>

            <h3>Sculptures</h3>
            <table border="0" width="900">
                <thead>
                    <tr>
                        <th>Oeuvre</th>
                        <th>Artiste</th>
                        <th>Caractéristiques</th>
                        <th>Prix</th>
                    </tr>
                </thead>
                <tbody>
                 <%
                    List<Sculpture> lesSculptures = (List<Sculpture>) request.getAttribute("lesSculptures");

                    for (Sculpture uneSculpture : lesSculptures) {
                 %>
                   <tr>
                        <td><%= uneSculpture.getNom() %></td>
                        <td><%= uneSculpture.getArtiste().getPrenom() + " " + uneSculpture.getArtiste().getNom() %></td>
                        <td><%= uneSculpture.getCarac() %></td>
                        <td><%= uneSculpture.getPrix() %> €</td>
                   </tr>             
                 <%
                    }
                 %>
                </tbody>
            </table>       
        </div>
    </body>
</html>

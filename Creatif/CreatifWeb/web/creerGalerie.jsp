<%-- 
    Document   : creerGalerie
    Created on : 13 mars 2012, 16:31:36
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modele.Artiste"%>
<%@page import="modele.Oeuvre"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Créer une galerie 2/2 - Créat'If</title>
    </head>
    <body>
        <a href="index.jsp">Accueil</a>

        <% 
        if ( session == null || session.getAttribute("connecte") == null) {
            return;
           }
        %>
        <h1>Création de galerie</h1>

        <div>
            Nom de l'artiste :
            <form action="Controleur" method="get">
                <select name="artiste">
                    <option value="-1">Tous</option>
                    <%                        
                        List<Artiste> lesArtistes = (List<Artiste>) session.getAttribute("TousLesArtistes");

                        for (Artiste unArtiste : lesArtistes) {
                    %>
                        <option value="<%= unArtiste.getIdArtiste() %>"><%= unArtiste.getNom() %></option>
                    <%
                        }
                    %>
                </select>
                <input type="hidden" value="preparerArtiste" name="action" />
                <input type="submit" value="Rechercher" />
            </form>
         </div>

         <div>
             Liste des oeuvres :

             <ul>
             <%
                 if (request.getAttribute("lesOeuvres") != null) {
                    List<Oeuvre> lesOeuvres = (List<Oeuvre>) request.getAttribute("lesOeuvres");

                    for (Oeuvre uneOeuvre : lesOeuvres) {
             %>
                <li><%= uneOeuvre.getNom() %></li>
             <%
                    }
                }
             %>
             </ul>
             
         </div>
    </body>
</html>

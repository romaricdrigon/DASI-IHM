<%-- 
    Document   : index
    Created on : 6 mars 2012, 16:36:21
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modele.Oeuvre"%>

<!doctype html>

<html lang="fr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Récapitulatif de la commande - Créat'If</title>
    </head>
    <body>
        <a href="index.jsp">Accueil</a>
        
        <h1>Récapitulatif</h1>

        <ul>
         <%
            List<Oeuvre> lesOeuvres = (List<Oeuvre>) request.getAttribute("recapCommande");

            for (Oeuvre uneOeuvre : lesOeuvres) {
         %>
            <li><%= uneOeuvre.getNom() %> - <%= uneOeuvre.getArtiste().getPrenom() + uneOeuvre.getArtiste().getNom() %> - <%= uneOeuvre.getCarac() %> - <%= uneOeuvre.getPrix() %></li>
         <%
            }
         %>
        </ul>
        
        <div>
            Prix total : ${prixTotal}
        </div>
        
        <a href="Controleur?action=dateSaisie">Annuler la commande</a>
        <a href="Controleur?action=validerCommande">Confirmer la commande</a>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modele.Oeuvre"%>

<!doctype html>
<html lang="fr">
    <head>
        <title>Récapitulatif de la commande - Créat'If</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="content-language" content="fr">
        <link rel="stylesheet" type="text/css" href="style.css" /> 
    </head>
    <body>
        <div class="content">
            <div class="accueil">Accueil</div>
        
            <h1>Récapitulatif</h1>

            <ul>
             <%
                List<Oeuvre> lesOeuvres = (List<Oeuvre>) session.getAttribute("panier");

                for (Oeuvre uneOeuvre : lesOeuvres) {
             %>
                    <li><%= uneOeuvre.getNom() %> - <%= uneOeuvre.getArtiste().getPrenom() + " " +  uneOeuvre.getArtiste().getNom() %> - <%= uneOeuvre.getCarac() %> - <%= uneOeuvre.getPrix() %> €</li>
             <%
                }
             %>
            </ul>

            <div>
                Prix total : ${prixTotal} €
            </div>

            <div class="footer">
                <a href="Controleur?action=dateSaisie" class="button">Annuler la commande</a>
                <a href="Controleur?action=validerCommande" class="button">Confirmer la commande</a>
            </div>
         </div>           
    </body>
</html>

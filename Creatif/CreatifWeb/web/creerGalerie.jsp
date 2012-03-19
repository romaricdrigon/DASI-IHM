<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modele.Artiste"%>
<%@page import="modele.Oeuvre"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<!doctype html>
<html lang="fr">
    <head>
        <title>Créer une galerie 2/2 - Créat'If</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="content-language" content="fr">
        <link rel="stylesheet" type="text/css" href="style.css" /> 
    </head>
    <body>
        <div class="content">
            <div class="accueil"><a href="accueil.jsp">Accueil</a></div>
            
            <h1>Création de la galerie</h1>

            <div class="column">
                <div class="block">
                    Nom de l'artiste :
                    <form action="Controleur" method="get">
                        <select name="artiste">
                            <option value="-1">Tous</option>
                            <%                        
                                List<Artiste> lesArtistes = (List<Artiste>) session.getAttribute("TousLesArtistes");

                                for (Artiste unArtiste : lesArtistes) {
                            %>
                                <option value="<%= unArtiste.getIdArtiste() %>"><%= unArtiste.getNom() + " " + unArtiste.getPrenom() %></option>
                            <%
                                }
                            %>
                        </select><br />
                        <select name="comparaisonPrix">
                            <option value="-1"></option>
                            <option value="inf"><</option>
                            <option value="eg">=</option>
                            <option value="sup">></option>
                        </select>
                        <input type="text" value="" name="prixOeuvre" size="5"/>
                        <input type="hidden" value="preparerArtiste" name="action" />
                        <input type="submit" value="Rechercher" />
                    </form>
                 </div>

                <div class="block">
                    Nom de l'oeuvre :
                    <form action="Controleur" method="get">
                        <input type="text" value="" name="nomOeuvre" size="50" />
                        <input type="hidden" value="rechercherOeuvre" name="action" />
                        <input type="submit" value="Rechercher" />
                    </form>
                 </div>

                 <div class="block">
                     <!-- on a pas de photo pour notre artiste ! -->
                     <%
                        if (session.getAttribute("lArtiste") != null) {
                            Artiste unArtiste = (Artiste) session.getAttribute("lArtiste");
                     %>
                     <div>
                         <b><%= unArtiste.getNom() + " " + unArtiste.getPrenom() %></b><br />
                         <i><%= unArtiste.getBiographie() %></i>
                     </div>
                     <%
                        }
                     %>
                 </div>
            </div>

            <div class="column">
                 <div class="block">
                     <h4>Panier</h4>

                     <form action="Controleur" method="get">
                         <select name="oeuvresASupprimer" multiple style="width: 300px">
                         <%
                            List<Oeuvre> lePanier = (List<Oeuvre>) session.getAttribute("panier");

                            for (Oeuvre uneOeuvre : lePanier) {
                         %>
                                <option value="<%= uneOeuvre.getOeuvreId() %>"><%= uneOeuvre.getNom() %></option>
                         <%
                            }
                         %>
                         </select>
                     </form>
                     <input type="hidden" value="supprimerPanier" name="action" />
                     <input type="submit" value="Supprimer" />
                 </div>

                 <div class="block">
                     <h4>Liste des oeuvres</h4>

                     <form action="Controleur" method="get">
                         <select name="oeuvresAAjouter" multiple style="width: 300px">
                         <%
                             if (session.getAttribute("lesOeuvres") != null) {
                                List<Oeuvre> lesOeuvres = (List<Oeuvre>) session.getAttribute("lesOeuvres");

                                for (Oeuvre uneOeuvre : lesOeuvres) {
                         %>
                            <option value="<%= uneOeuvre.getOeuvreId() %>"><%= uneOeuvre.getNom() %> - <%= uneOeuvre.getPrix() %> €</option>
                         <%
                                }
                            }
                         %>
                         </select>
                        <input type="hidden" value="ajouterPanier" name="action" />
                        <input type="submit" value="Ajouter" />
                     </form>
                 </div>
            </div>

            <br clear="left" />

             <div class="footer">
                 <div class="message">${erreurPanier}</div>
                 <center><a href="Controleur?action=commander" class="button">Valider la commande</a></center>
             </div>
         
        </div>
    </body>
</html>

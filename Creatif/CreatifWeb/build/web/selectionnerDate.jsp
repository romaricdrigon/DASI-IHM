<%-- 
    Document   : selectionnerDate
    Created on : 13 mars 2012, 16:48:08
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Créer une galerie 1/2 - Créat'If</title>
    </head>
    <body>
        <h1>Sélection des dates de réservation</h1>

        <form action="Controleur">
            <input type="text" name="dateDebut" value="" />
            <input type="text" name="dateFin" value="" />
            <input type="submit" name="action" value="creer" />
        </form>

        <p>${erreurDate}</p>
    </body>
</html>

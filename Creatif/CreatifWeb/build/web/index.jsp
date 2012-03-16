<%-- 
    Document   : index
    Created on : 6 mars 2012, 16:36:21
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>

<html lang="fr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Créat'If</title>
    </head>
    <body>
        <h1>Connexion</h1>

        Code Client :
        <form action="Controleur" method="get">
            <input type="text" name="codeClient" value="" size="10" />
            <input type="hidden" value="login" name="action" />
            <input type="submit" value="Ok" name="buttonOk" />
        </form>

        <p>${erreur}</p>
    </body>
</html>

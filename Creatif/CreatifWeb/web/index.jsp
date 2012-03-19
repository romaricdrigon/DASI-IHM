<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="fr">
    <head>
        <title>Login - Créat'If</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="content-language" content="fr">
        <link rel="stylesheet" type="text/css" href="style.css" /> 
    </head>
    <body>
        <div class="content">
            <h1>Connexion</h1>

            Code Client :
            <form action="Controleur" method="get">
                <input type="text" name="codeClient" value="" size="10" />
                <input type="hidden" value="login" name="action" />
                <input type="submit" value="Se connecter" />
            </form>

            <div class="message">${erreur}</div>
        </div>
    </body>
</html>

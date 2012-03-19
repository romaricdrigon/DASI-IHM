<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="fr">
    <head>
        <title>Créer une galerie 1/2 - Créat'If</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="content-language" content="fr">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" type="text/css" href="jquery-ui.css" />
        <script type="text/javascript" src="jquery.min.js" />
        <script type="text/javascript" src="jquery-ui.min.js" />
    </head>
    <body>
        <script>
            // un peu de jQuery UI pour les choxi de la date
            $(function() {
		$('#dateDebut').datepicker({
                    dateFormat: 'dd/mm/yyyy',
                    autoSize: true,
                    closeText: 'Fermer',
                    currentText: "Aujourd'hui",
                    minDate: new Date(),
                    altField: '#dateFin'
                });
                
		$('#dateDebut').datepicker({
                    dateFormat: 'dd/mm/yyyy',
                    autoSize: true,
                    closeText: 'Fermer',
                    currentText: "Aujourd'hui",
                    minDate: new Date()
                });
            });
	</script>
        <div class="content">
            <div class="accueil">Accueil</div>
            
            <h1>Sélection des dates de réservation</h1>

            <form action="Controleur">
                Date de début :
                <input type="text" name="dateDebut" id="dateDebut" value="" />
                Date de fin :
                <input type="text" name="dateFin" id="dateFin" value="" />
                <input type="hidden" name="action" value="dateSaisie" />
                <input type="submit" value="Suivant" />
            </form>

            <div class="message">${erreurDate}</div>
        </div>
    </body>
</html>

package action;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Client;
import modele.Comparaison;
import modele.Galerie;
import modele.Oeuvre;

/**
 *
 * @author Administrateur
 */
public class CommanderAction extends Action {
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // enregistrer la commande = créer la galerie
        
        // on créé déjà le bon objet
        Galerie uneGalerie = new Galerie((Date)req.getSession().getAttribute("dateDebutCorrecte"), (Date)req.getSession().getAttribute("dateFinCorrecte"));
        
        // puis le commit
        service.creerGalerie(uneGalerie, (Client)req.getSession().getAttribute("leClient"), (List)req.getSession().getAttribute("panier"));

        return "accueil.jsp";
    }
}

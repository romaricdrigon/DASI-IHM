package action;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Comparaison;
import modele.Oeuvre;
import modele.Peinture;
import modele.Sculpture;

/**
 *
 * @author Administrateur
 */
public class AfficherCatalogueAction extends Action {
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // on vérifie si l'utilisateur est bien connecté
        if (req.getSession() == null || req.getSession().getAttribute("connecte") == null) {
            return "-1";
        }
        
        // on va récupérer les différentes listes, les mettres en attributs de la requête que l'on ré-envoie
        
        // les peintures
        List<Peinture> lesPeintures = service.rechercherToutesPeintures();
        req.setAttribute("lesPeintures", lesPeintures);
        
        // les sculptures
        List<Sculpture> lesSculptures = service.rechercherToutesSculptures();
        req.setAttribute("lesSculptures", lesSculptures);

        return "catalogue.jsp";
    }
}

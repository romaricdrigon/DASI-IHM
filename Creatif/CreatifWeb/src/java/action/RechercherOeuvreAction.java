package action;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Comparaison;
import modele.Oeuvre;

/**
 *
 * @author Administrateur
 */
public class RechercherOeuvreAction extends Action {
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // on vérifie si l'utilisateur est bien connecté
        if (req.getSession() == null || req.getSession().getAttribute("connecte") == null) {
            return "-1";
        }
        
        // on récupère les paramètres
        String nomOeuvre = req.getParameter("nomOeuvre");
        
        // on recherche les oeuvres correspondantes
        List<Oeuvre> lesOeuvres = service.rechercherOeuvreParNomDate(nomOeuvre, (Date)req.getSession().getAttribute("dateDebutCorrecte"), (Date)req.getSession().getAttribute("dateFinCorrecte"));
        req.getSession().setAttribute("lesOeuvres", lesOeuvres);   

        return "creerGalerie.jsp";
    }
}

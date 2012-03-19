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
        // on récupère les paramètres
        String nomOeuvre = req.getParameter("nomOeuvre");
        
        // on recherche les oeuvres correspondantes
        List<Oeuvre> lesOeuvres = service.rechercherOeuvreParNomDate(nomOeuvre, (Date)req.getSession().getAttribute("dateDebutCorrecte"), (Date)req.getSession().getAttribute("dateFinCorrecte"));
        req.setAttribute("lesOeuvres", lesOeuvres);   

        return "creerGalerie.jsp";
    }
}

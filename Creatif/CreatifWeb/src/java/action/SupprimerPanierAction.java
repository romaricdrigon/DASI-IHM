package action;

import java.util.Arrays;
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
public class SupprimerPanierAction extends Action {
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // on récupère les ids des oeuvres à supprimer du panier
        // c'est un select multiple, il peut en avoir une ou plusieurs
        String[] idsDesOeuvres = req.getParameterValues("oeuvresASupprimer");
        
        // on récupère le panier, puis va le parcourir
        List<Oeuvre> panier = (List) req.getSession().getAttribute("panier");
        
        // on supprime les oeuvres correspondantes du panier
        // imbriquer les boucles dans ce sens est plus optimisé pour un petit panier
        for (String unId : idsDesOeuvres) {
            for (Oeuvre uneOeuvre : panier) {
                if (uneOeuvre.getOeuvreId() == Integer.parseInt(unId)) {
                    panier.remove(uneOeuvre);
                    break;
                }
            }
        }
        
        // on remet tout ça dans le  tableau de session
        req.getSession().setAttribute("panier", panier);

        return "creerGalerie.jsp";
    }
}

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
public class AjouterPanierAction extends Action {
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // on récupère les ids des oeuvres
        // c'est un select multiple, il peut en avoir une ou plusieurs
        String[] idsDesOeuvres = req.getParameterValues("oeuvresAAjouter");
        
        // on récupère les objets Oeuvre
        List<Oeuvre> lesOeuvres = null;
        for (String idOeuvre : idsDesOeuvres) {
            try {
                int iOeuvre = Integer.parseInt(idOeuvre);
                lesOeuvres.add(service.rechercherOeuvreParId(iOeuvre));
            } catch (NumberFormatException e) {
                req.setAttribute("erreurPanier", "N° d'oeuvre incorrect");
            } catch (Exception e) {
                req.setAttribute("erreurPanier", "Oeuvre introuvable");
            }
        }
        
        // on met tout ça dans le panier, tableau de session
        List<Oeuvre> panier = (List) req.getSession().getAttribute("panier");
        panier.addAll(lesOeuvres);
        req.getSession().setAttribute("panier", panier);

        return "creerGalerie.jsp";
    }
}
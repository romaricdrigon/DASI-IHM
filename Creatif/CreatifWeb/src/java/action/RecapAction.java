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
public class RecapAction extends Action {
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // on garde la variable de session "panier", qui devient un récap de commande
        List<Oeuvre> panier = (List) req.getSession().getAttribute("panier");
        
        // calcul du prix total : un servcie a été fait pour, on va l'utiliser
        double prixTotal = service.calculerPrixGalerie(panier);
        req.setAttribute("prixTotal", prixTotal);
        
        req.setAttribute("message", "La commande a bien été enregistrée !");

        return "recapCommande.jsp";
    }
}

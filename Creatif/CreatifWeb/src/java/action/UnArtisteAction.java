/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Artiste;
import modele.Comparaison;
import modele.Oeuvre;

/**
 *
 * @author Administrateur
 */
public class UnArtisteAction extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // récupération du code de l'artiste
        int idArtiste = Integer.parseInt(req.getParameter("artiste"));
        List<Artiste> tousArtistes = service.rechercherTousArtistes();

        // il n'y a pas de service pour récupérer un artiste à partir de son ID
        // on fait donc cette petite boucle
        for (Artiste unArtiste : tousArtistes) {
            if (unArtiste.getIdArtiste() == idArtiste) {
                req.setAttribute("lArtiste", unArtiste);
                break;
            }
        }
        
        int prix = 0; // par défaut, on choisit tout
        try {
            prix = Integer.parseInt(req.getParameter("prixOeuvre"));
        } catch (Exception e) {
            // rien : ça peut aussi vouloir dire que le prix Oeuvre
            // était à null, pas renseigné par la personne
        }
        
        // on s'intéresse maintenant à l'opérateur
        String comp = req.getParameter("comparaisonPrix");
        Comparaison operateurComp = Comparaison.SUP; // par défaut, on pend tout > 0
        if (comp.equals("inf")) {
            operateurComp = Comparaison.INF;
        } else if (comp.equals("eg")) {
            operateurComp = Comparaison.EGAL;
        }

        // Récupération des oeuvres de l'artiste
        // HACKY : il n'y a pas de service correspondant, du coup on prend les prix > 0 (soit tous)
        List<Oeuvre> lesOeuvres = service.rechercherOeuvreParPrixArtisteDate(idArtiste, prix, operateurComp, (Date)req.getSession().getAttribute("dateDebutCorrecte"), (Date)req.getSession().getAttribute("dateFinCorrecte"));
        req.setAttribute("lesOeuvres", lesOeuvres);

        return "creerGalerie.jsp";
    }

}

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
        // Récupération du code artiste
        int idArtiste = Integer.parseInt(req.getParameter("artiste"));
        List<Artiste> tousArtistes = service.rechercherTousArtistes();

        for (Artiste unArtiste : tousArtistes) {
            if (unArtiste.getIdArtiste() == idArtiste) {
                req.setAttribute("lArtiste", unArtiste);
                break;
            }
        }

        // Récupération des oeuvres de l'artiste
        // HACKY : il n'y a pas de service correspondant, du coup on prend les prix > 0 (soit tous)
        List<Oeuvre> lesOeuvres = service.rechercherOeuvreParPrixArtisteDate(idArtiste, 0, Comparaison.SUP, (Date)req.getSession().getAttribute("dateDebutCorrecte"), (Date)req.getSession().getAttribute("dateFinCorrecte"));
        req.setAttribute("lesOeuvres", lesOeuvres);

        return "creerGalerie.jsp";
    }

}
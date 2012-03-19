/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Artiste;
import modele.Comparaison;
import modele.Oeuvre;

/**
 *
 * @author Administrateur
 */
public class DateAction extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bufferDateDebut = req.getParameter("dateDebut");
        String bufferDateFin = req.getParameter("dateFin");

        SimpleDateFormat ffDate = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dateDebut = ffDate.parse(bufferDateDebut);
            Date dateFin = ffDate.parse(bufferDateFin);
            
            if (dateDebut.getTime() <= dateFin.getTime()) {
                HttpSession session = req.getSession();
                session.setAttribute("dateDebutCorrecte", dateDebut);
                session.setAttribute("dateFinCorrecte", dateFin);

                // Préparation des listes nécessaires à l'IHM de création de galeries
                List<Artiste> lesArtistes = service.rechercherTousArtistes();
                session.setAttribute("TousLesArtistes", lesArtistes);

                // et on prépare une liste de toutes les oeuvres (disponibles sur ces dates)
                List<Oeuvre> lesOeuvres = service.rechercherOeuvreParDate((Date)req.getSession().getAttribute("dateDebutCorrecte"), (Date)req.getSession().getAttribute("dateFinCorrecte"));
                req.setAttribute("lesOeuvres", lesOeuvres);
                
                // on préparer un panier vide pour cette session
                List<String> panier = new ArrayList<String>();
                req.getSession().setAttribute("panier", panier);

                return "creerGalerie.jsp";
            } else {
                req.setAttribute("erreurDate", "Les dates sont incorrectes");
                return "selectionnerDate.jsp";
            }
        } catch(Exception e) {
            req.setAttribute("erreurDate", e.getMessage());
            return "selectionnerDate.jsp";
        } 
    }

}

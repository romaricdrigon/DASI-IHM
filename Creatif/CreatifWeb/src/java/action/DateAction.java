/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Artiste;
import modele.Oeuvre;

/**
 *
 * @author Administrateur
 */
public class DateAction extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bufferDateDebut = (String) req.getAttribute("dateDebut");
        String bufferDateFin = (String) req.getAttribute("dateDebut");

        SimpleDateFormat ffDate = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dateDebut = ffDate.parse(bufferDateDebut);
            Date dateFin = ffDate.parse(bufferDateFin);
            
            if (dateDebut.getTime() <= dateFin.getTime()) {
                req.setAttribute("dateDebutCorrecte", dateDebut);
                req.setAttribute("dateFinCorrecte", dateFin);

                //Préparation des listes nécessaires à l'IHM de création de galeries
                List<Artiste> lesArtistes = service.rechercherTousArtistes();
                List<Oeuvre> lesOeuvres = service.rechercherToutesOeuvres();
                req.setAttribute("TousLesArtistes", lesArtistes);
                req.setAttribute("ToutesLesOeuvres", lesOeuvres);

                return "creerGalerie.jsp";
            } else {
                req.setAttribute("erreurDate", "Les dates sont incorrectes");
                return "selectionnerDate.jsp";
            }
        } catch(Exception e) {
            req.setAttribute("erreurDate", e.getMessage() + bufferDateDebut);
            return "selectionnerDate.jsp";
        } 
    }

}

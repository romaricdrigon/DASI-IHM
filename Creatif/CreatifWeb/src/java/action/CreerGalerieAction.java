/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
public class CreerGalerieAction extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // on vérifie si l'utilisateur est bien connecté
        if (req.getSession() == null || req.getSession().getAttribute("connecte") == null) {
            return "-1";
        }
        // on a pour l'instant aucun traitement à faire
        
        return "selectionnerDate.jsp";
    }

}

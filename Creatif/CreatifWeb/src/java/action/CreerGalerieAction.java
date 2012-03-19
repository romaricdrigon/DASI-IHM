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
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String bouton = req.getParameter("bouton");
        
        if ("creer".equals(bouton)) {
            return "selectionnerDate.jsp";
        } else {
            return "index.jsp";
        }
    }

}

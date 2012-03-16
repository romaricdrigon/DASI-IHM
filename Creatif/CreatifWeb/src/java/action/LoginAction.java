package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
public class LoginAction extends Action {
    // page de login
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // checker les credentials
        String codeClient = req.getParameter("codeClient");

        if (codeClient.equals("")) {
            // erreur, affiche un message
            req.setAttribute("erreur", "Veuillez fournir votre code client");
            return "index.jsp";
        }

        try {
            int code = Integer.parseInt(codeClient);

            service.connexionClient(code);

            // on stock ok dans une variable de session
            //req.getSession(true).setAttribute("connecte", true);

            return "accueil.jsp";
        } catch (NumberFormatException e) {
            req.setAttribute("erreur", "Le code client doit être numérique");
            return "index.jsp";
        } catch (Exception e) {
            req.setAttribute("erreur", "Code client invalide");
            return "index.jsp";
        }
    }
}

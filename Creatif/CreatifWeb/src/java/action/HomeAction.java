package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
public class HomeAction extends Action {
    // page de login
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // on a rien à faire

        // retourne le nom de la vue
        return "index";
    }
}

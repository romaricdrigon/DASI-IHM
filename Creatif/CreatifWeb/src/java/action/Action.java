package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Service;

/**
 *
 * @author Administrateur
 */
public abstract class Action {
    protected Service service;

    public void setService(Service service) {
        this.service = service;
    }
    public abstract String execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;
}
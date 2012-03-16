package Controleur;

import action.Action;
import action.ChoixAction;
import action.DateAction;
import action.LoginAction;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Service;

/**
 *
 * @author Administrateur
 */
public class Controleur extends HttpServlet {
    private Service service;

    // init et récupération du service
    public Service getServiceMetier() {
        if (service == null) {
            service = new Service();
        }

        return service;
    }

    // fonction gérant les requêtes
    @Override
    protected void service (HttpServletRequest req, HttpServletResponse resp) {
        String actionAFaire = req.getParameter("action");
        Action action = getAction(actionAFaire);
        
        try {
            action.setService(getServiceMetier());
            String vue = action.execute(req, resp);
            RequestDispatcher rd = req.getRequestDispatcher(vue);
            rd.forward(req, resp);
        } catch (ServletException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Action getAction(String name) {
        Action action = null;

        if ("login".equals(name)) {
            action = new LoginAction();
        } else if ("choix".equals(name)) {
            action = new ChoixAction();
        } else if ("creer".equals(name)) {
            action = new DateAction();
        }

        return action;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } */

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }*/

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    /*@Override
    public String getServletInfo() {
        return "Short description";
    }*/// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import admin.Login;
import admin.Section;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import peronne.Parents;

/**
 *
 * @author itu
 */
@WebServlet(urlPatterns = {"/AjoutParent"})
public class AjoutParent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
         HttpSession sessiont = request.getSession(true); 
        String akizy = (String) sessiont.getAttribute("akiz");
        Fonctions fonc = new Fonctions();
        String nom = request.getParameter("Pnom");
        String prenom = request.getParameter("Pprenom");
        String prof = request.getParameter("Pprofession");
        String contact = request.getParameter("Pcontact");
        String nomM = request.getParameter("Mnom");
        String prenomM = request.getParameter("Mprenom");
        String profM = request.getParameter("Mprofession");
        String contactM = request.getParameter("Mcontact");
        String adresse = request.getParameter("Padresse"); 
        Login log = new Login();
        String val = log.verifyA(akizy);
         Parents e = new Parents(nom,prenom,prof,adresse,contact,val);
           Parents el = new Parents(nomM,prenomM,profM,adresse,contactM,val); 
            String enfant = "PARENTS";
            String redirectURL = "inscription.jsp";
            int insertable = 7;
            int insertable2 = 0;
            try{
                
                insertable = fonc.insertToTable(e,enfant);
                insertable2 = fonc.insertToTable(el,enfant);
                response.sendRedirect(redirectURL);
                }
            catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
    }

   

}

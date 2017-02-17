/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import function.Fonction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import peronne.Enfant;
import peronne.Parents;

/**
 *
 * @author itu
 */
@WebServlet(urlPatterns = {"/UpdateP"})
public class UpdateP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private String nom ="";
        private String prenom="";
        private String profession = "";
        private String contact ="";
        private String adresse = "";
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
        Fonction fonc = new Fonction();
        String ideleve = request.getParameter("id");
        String ide = request.getParameter("ide");
        nom = request.getParameter("nomA");
        prenom = request.getParameter("prenomA");
        profession = request.getParameter("professionA");
        contact = request.getParameter("contactA");
        adresse = request.getParameter("adresseA");
        String redirectURL = "modifier.jsp?ideleve="+ide;
         Parents e = new Parents();
         e.setNOM(nom);
         e.setPRENOM(prenom);
         e.setPROFESSION(profession);
         e.setCONTACT(contact);
         e.setADRESSE(adresse);
         
          
            String enfant = "PARENTS";
            int insertable = 7;
            String colll = "IDPARENTS";
            try{
                insertable = fonc.updateToTable(e,enfant,ideleve,colll);
              
                //maSession.setAttribute("pakiz",pss);
                response.sendRedirect(redirectURL);
            }
            catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
            
            System.out.println(insertable);
    }

    
}

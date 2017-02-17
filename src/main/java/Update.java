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

/**
 *
 * @author itu
 */
@WebServlet(urlPatterns = {"/Update"})
public class Update extends HttpServlet {
        private String nom ="";
        private String prenom="";
        private String t = "";
        private String sexe ="";
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
         
        nom = request.getParameter("nomA");
        prenom = request.getParameter("prenomA");
        t = request.getParameter("naissanceA");
        sexe = request.getParameter("sexeeA");
        adresse = request.getParameter("adresseA");
        Date nais =  fonc.converDate(t);
        String redirectURL = "reinscription.jsp";
         Enfant e = new Enfant(nom,prenom,nais,sexe,adresse);
         
         
           String ps = nom;
           String pss = prenom;
            String enfant = "ELEVE";
            String coll = "IDELEVE";
            int insertable = 7;
            try{
                insertable = fonc.updateToTable(e,enfant,ideleve,coll);
             
                response.sendRedirect(redirectURL);
            }
            catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
            
            System.out.println(insertable);
    }

    

}

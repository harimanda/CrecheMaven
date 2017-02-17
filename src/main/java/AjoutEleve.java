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
@WebServlet(urlPatterns = {"/AjoutEleve"})
public class AjoutEleve extends HttpServlet {

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
        Fonctions fonc = new Fonctions();
        Fonction f = new Fonction();
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String t = request.getParameter("naissance");
        String sexe = request.getParameter("sexee");
        String adresse = request.getParameter("adresse");
        Date nais =  fonc.converDate(t);
        int branche =0,brancheF =0; 
        HttpSession maSession = request.getSession();
        String redirectURL = "inscription.jsp";
        
           String ps = nom;
           String pss = prenom;
            String enfant = "ELEVE";
            int insertable = 7;
            try{
                System.out.println("ito daty "+nais);
                 branche = f.getCategorie(nais);
                 System.out.println("ito branche "+branche);
                 brancheF = f.setSection(branche);
                 System.out.println("ito section "+brancheF);
                  Enfant e = new Enfant(nom,prenom,nais,sexe,adresse);
                  e.setBRANCHE(brancheF);
                insertable = fonc.insertToTable(e,enfant);
                maSession.setAttribute("akiz",pss);
                //maSession.setAttribute("pakiz",pss);
                response.sendRedirect(redirectURL);
            }
            catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
            
            System.out.println(insertable);
    }

    

}

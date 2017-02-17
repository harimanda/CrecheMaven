/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import admin.Ecolage;
import admin.Mois;
import function.Fonction;
import function.NewPayement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author itu
 */
@WebServlet(urlPatterns = {"/AjoutEcolage"})
public class AjoutEcolage extends HttpServlet {

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
        Fonction f = new Fonction();
        NewPayement paye = new NewPayement();
        String annee = request.getParameter("annee");
        String branche = request.getParameter("section");
        String montant = request.getParameter("montant");        
        String redirectURL = "insertEcolage.jsp";
        Ecolage e = new Ecolage();
         e.setANNEE(annee);
         e.setIDBRANCHES(branche);
         e.setMONTANTS(montant);
            String table = "HISTO_ECOLAGE";
            String uptadeT="ECOLAGE_ACTUEL";
            String col = "IDBRANCHE";
            String table_eco="ECOLAGE_A_PAYE";
            Mois[] mois = paye.getMoisActivite();
            Mois month = new Mois();
            int insertable = 7;
            try{
                insertable = f.insertToTable(e,table);
                if(insertable==1){
                    insertable = f.updateToTable(e, uptadeT,branche, col);
                    for(int i=0;i<mois.length;i++){
                        month.setReference(mois[i].getReference());
                        month.setIdbranche(e.getIDBRANCHE());
                        month.setAnnee(Integer.parseInt(e.getANNEE()));
                        month.setEcolage(e.getMONTANT());
                        insertable = f.insertToTable(month, table_eco);
                    }
                    response.sendRedirect(redirectURL);
                }
            }
            catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
            System.out.println(insertable);
    }

}

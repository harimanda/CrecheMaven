/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import function.NewPayement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author itu
 */
@WebServlet(urlPatterns = {"/FactureEcolage"})
public class FactureEcolage extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            NewPayement paye = new NewPayement();
            String[] facture = null;
            if(request.getParameter("engage")!=null){
                facture = request.getParameterValues("engage");
                for(int i=0;i<facture.length;i++){
                    out.println(facture[i]);
                }
            }
            else{
		request.setAttribute("message", "Veuillez choisir au moins un ecolage");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/payementEcolage.jsp");
		dispatcher.forward(request, response);
            }
            
            
    }

    

}

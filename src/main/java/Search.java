/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import admin.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/Search"})
public class Search extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
         HttpSession sessiont = request.getSession(true); 
        Fonctions fonc = new Fonctions();
        String nom = request.getParameter("champ");
        String prenom = request.getParameter("cle");
        List l = new LinkedList();
        fonc.selecte(nom, prenom);
         for(int i = 0; i < l.size(); i++)
                out.println("Élément à l'index " + i + " = " + l.get(i));
            }
          
    }

   


     



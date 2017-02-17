/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import admin.Login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author itu
 */
@WebServlet(urlPatterns = {"/Authentification"})
public class Authentification extends HttpServlet {

     Login log = new Login();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession maSession = request.getSession();
        String pseudo = request.getParameter("username");
        String pass = request.getParameter("password");
        boolean valeu;
        String redirectURL = "index.jsp";
        if(pseudo != null && pass !=null)
    {
        valeu = log.verify(pseudo,pass);
        if(valeu){
            maSession.setAttribute("user",pseudo);
            response.sendRedirect(redirectURL);
            
        }
        else{
            response.sendRedirect("login.jsp");
        }
        
    }
    else
    {
        response.sendRedirect("login.jsp");
    }
        
            
        
    }

   

}

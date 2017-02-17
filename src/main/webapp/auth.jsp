<%-- 
    Document   : auth
    Created on : 20 oct. 2016, 11:01:35
    Author     : itu
--%>

<%@page import="admin.Login"%>
<%!
    private Login log;  
%>
<%
    String pseudo = request.getParameter("username");
    String pass = request.getParameter("password");
     
    String redirectURL = "index.jsp";
    boolean valeu;
    if(pseudo != null && pass !=null)
    {
        valeu = log.verify(pseudo,pass);
        if(valeu){
            response.sendRedirect(redirectURL);
        }
        else{
            //response.sendRedirect("login.jsp");
        }
        
    }
    else
    {
       // response.sendRedirect("login.jsp");
    }
%>

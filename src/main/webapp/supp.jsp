<%-- 
    Document   : supp
    Created on : 1 déc. 2016, 13:09:06
    Author     : itu
--%>

<%@page import="function.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suppression</title>
    </head>
    <%
        Fonction fon = new Fonction();
        String idel = request.getParameter("ide");
        int rep = 0;
        String nomTable = "PARENTS";
        String idcol = "IDELEVE";
        rep = fon.deleteFromTable(nomTable, idel, idcol);
        if(rep == 1){
            String nt = "ELEVE";
            String idcoll = "IDELEVE";
            rep = fon.deleteFromTable(nt, idel, idcoll);
            response.sendRedirect("reinscription.jsp");
        }
    %>
</html>

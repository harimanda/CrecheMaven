<%-- 
    Document   : deleteP
    Created on : 2 déc. 2016, 11:04:43
    Author     : itu
--%>

<%@page import="function.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <%
        Fonction fon = new Fonction();
        String idel = request.getParameter("idP");
        String idelve = request.getParameter("ide");
        int rep = 0;
        String nomTable = "PARENTS";
        String idcol = "IDPARENTS";
        rep = fon.deleteFromTable(nomTable, idel, idcol);
        if(rep == 1){
            response.sendRedirect("modifier.jsp?ideleve="+idelve);
        }
    %>
</html>

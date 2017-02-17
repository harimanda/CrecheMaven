 

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="connexion.ConnectBase"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
         ConnectBase con = new ConnectBase();  
            Connection c;
         c = con.connect();
        try
              {
                Statement stm = c.createStatement ();
                ResultSet rs = stm.executeQuery("select * from eleve");
                ResultSetMetaData rsmd = rs.getMetaData();
                int nbCols = rsmd.getColumnCount();
                 
                while(rs.next())
                {
                        obj.put("id", rs.getInt("IDELEVE") );
                        obj.put("nom",rs.getString("NOM"));
                        obj.put("prenom",rs.getString("PRENOM"));
                        obj.put("naissance",rs.getDate("DATENAISSANCE"));
                        obj.put("adresse",rs.getString("ADRESSE"));
                        arr.put(obj);
                        obj = new JSONObject();
                      }
                      out.println(arr);
                
               }
                catch(Exception e)
                {

                }
        
    %>

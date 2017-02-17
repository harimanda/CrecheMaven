<%-- 
    Document   : exo
    Created on : 10 nov. 2016, 12:08:59
    Author     : itu
--%>

<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        
        
        String[] a = {"1a","2b","3c"};
        String[] b = {"1aa","2ba","3ca"};
        try{
            for(int i = 0 ; i< a.length ; i++)
            {
                //p = list.get(i);

                obj.put("id", a[i]);
                obj.put("title", b[i]);
                System.out.println(obj);
                arr.put(i,obj);

                obj = new JSONObject();
            }
            out.println(arr);
        }
        catch(Exception e){}
    %>

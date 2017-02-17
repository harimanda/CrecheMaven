/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import connexion.ConnectBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author itu
 */
public class Login {
    private int IDLOGIN;  
    private String PSEUDO;    
    private String PASSE;
    public Login(int IDLOGIN, String PSEUDO, String PASSE) {
        this.IDLOGIN = IDLOGIN;
        this.PSEUDO = PSEUDO;
        this.PASSE = PASSE;
    }
    public Login(){
        
    }
    public int getIDLOGIN() {
        return IDLOGIN;
    }

    public void setIDLOGIN(int IDLOGIN) {
        this.IDLOGIN = IDLOGIN;
    }

    public String getPSEUDO() {
        return PSEUDO;
    }

    public void setPSEUDO(String PSEUDO) {
        this.PSEUDO = PSEUDO;
    }

    public String getPASSE() {
        return PASSE;
    }

    public void setPASSE(String PASSE) {
        this.PASSE = PASSE;
    }
     public boolean verify(String pseudo,String pass){
         boolean rep = false;
           ConnectBase con = new ConnectBase();  
      Connection c;
      c = con.connect();
     Statement stmt = null;
      try {
        
        stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM LOGIN;" );
         while ( rs.next() ) {
             
            String  user = rs.getString("PSEUDO");
            String mdp  = rs.getString("PASS");
            if(pseudo.equals(user) && pass.equals(mdp)){
                rep = true;
            }
            else{
                rep = false;
            }
         }
         rs.close();
         stmt.close();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      return rep;
     }
          public String verifyA(String pseudo){
         boolean rep = false;
           ConnectBase con = new ConnectBase();  
      Connection c;
      c = con.connect();
     Statement stmt = null;
      String  user = "";
      try {
        
        stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM ELEVE WHERE PRENOM = " + "'" + pseudo + "'" );
         while ( rs.next() ) {
             
           user = rs.getString("IDELEVE");
            
            
         }
         rs.close();
         stmt.close();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      return user;
     }
    
}

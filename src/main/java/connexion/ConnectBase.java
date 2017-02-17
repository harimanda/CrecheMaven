/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author itu
 */
public class ConnectBase {
  public Connection connect() {
      Connection c = null;
       
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/crecheF",
            "postgres", "itu");
         c.setAutoCommit(false);
         System.out.println("ok");
          

      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      return c;
   }
  public static void main(String args[]){
      ConnectBase con = new ConnectBase();
      con.connect();
  }
}
    




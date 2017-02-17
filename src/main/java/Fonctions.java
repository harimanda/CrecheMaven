import connexion.ConnectBase;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import peronne.Enfant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Fonctions {
        
        
        
    String requete = "";
            ConnectBase con = new ConnectBase();  
            Connection c;
           ResultSet resultats = null;
           Statement stmt = null;
       public ResultSet Execute(String requete)
	{
	c = con.connect();	 
    	try
    	{
    	 
            stmt = c.createStatement(); 
            
    		resultats = stmt.executeQuery(requete);
			System.out.println("execution reussie");	
			//resultats.close();
    	}
		catch (SQLException e)
	    {
			System.out.println("io ehhhhhh: "+e.getMessage());
    	}
		return resultats;
	} 
    	public int insertToTable(Object o, String nomTable) throws Exception
	{
             
            c = con.connect();
            
           
           int status =0;
			Method met = o.getClass().getMethod("getCol");
			String valCol = (String)met.invoke(o,null);
                        Method met1 = o.getClass().getMethod("getValue");
                        String valueCol = (String)met1.invoke(o,null);
			String requete = "INSERT INTO " + nomTable + "( " + valueCol + ") VALUES (" + valCol + ")";
			 System.out.println(requete);
                      
                        try {

                                     stmt = c.createStatement(); 
                                    stmt.executeUpdate(requete);
                                    String comm = "commit";
                                    stmt.executeUpdate(comm);
                                    status = 1;     
                            
                                    
                                    System.out.println("execution reussie");  
                                            //resultats.close();
                            }
                                    catch (Exception e)
                                {
                                            System.out.println(e);
                            }
			return status;
	}
        public Date converDate(String dateInString){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;

            try {

                date = formatter.parse(dateInString);
               
                //String datef = formatter.format(date);

            } catch (ParseException e) {
                e.printStackTrace();
            }
             return date;
        }
        public String findToTable(Object o,Object[] data)
	{
               String valCol=""; 
               try{
                  Class[] argTypes = { String.class,String.class };
                Method method = o.getClass().getMethod("sorato", argTypes);
                valCol = (String)method.invoke(o, data);	
                
               }
              catch (Exception e) {
                System.err.println(e);
              }
               return valCol;
              
           /* Object rep = new Object();
		requete = "SELECT * FROM " + nomTable;
		 
		int taille = nomColFiltre.length;
		String val = " WHERE "  + nomColFiltre[0] + "="  + "'" + valFiltre[0] + "'";
		String and = "AND";
		 int nbligne=0;
		 
		for(int i =1; i<taille;i++)
		{
			val = val + and + "(" + nomColFiltre[i] + "=" + "'" + valFiltre[i] + "');";
		}
		requete = requete+val;
		System.out.println(requete);
		ResultSet valiny ;
		try
		{
			resultats = Execute(requete);
			valiny = Execute(requete);
			ResultSetMetaData rsmd = resultats.getMetaData();
			boolean next = resultats.next();
			int nbCols = rsmd.getColumnCount();
			while (next)
			{
				for (int i = 1; i <= nbCols; i++)
				System.out.print(resultats.getString(i) + " ");
				System.out.println("\n");
				next = resultats.next();
				nbligne++;
			}
			next = valiny.next();
			while(next)
			{
				for(int u=0;u<nbCols;u++)
				{
					//rep.add(valiny.getString(u));
				}
				next = valiny.next();

			}
			resultats.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return rep;*/
	} 
        public Enfant selecte(String nom,String val){
             
                  c = con.connect();
                  List l = new LinkedList();
                  Enfant enf = new Enfant();
             try
              {
                Statement stm = c.createStatement ();
                ResultSet rs = stm.executeQuery("select * from eleve where "+nom+" = '"+val+"'");
                ResultSetMetaData rsmd = rs.getMetaData();
                int nbCols = rsmd.getColumnCount();
                 
                while(rs.next())
                {
                         int id = rs.getInt("IDELEVE");
                        String firstName = rs.getString("NOM");
                        String lastName = rs.getString("PRENOM");
                        Date dateCreated = rs.getDate("DATENAISSANCE");
                        String isAdmin = rs.getString("ADRESSE");
                        enf.setIDENFANT(id);
                        enf.setNOM(firstName);
                        enf.setPRENOM(lastName);
                        enf.setDATENAISSANCE(dateCreated);
                        enf.setADRESSE(isAdmin);
                        
                      }
                      
                
               }
                catch(Exception e)
                {

                }
             return enf;
            
        }
        public Object findToTables(Object or,String[] nomColFiltre, String[] valFiltre, String nomTable)
	{
		 
		requete = "select * from " + nomTable;
		 
		int taille = nomColFiltre.length;
		String val = " where "  + nomColFiltre[0] + " = "  + "'" + valFiltre[0] + "'";
		String and = "and";
		int nbligne=0;
		int id =0;
		for(int i =1; i<taille;i++)
		{
			val = val + and + "(" + nomColFiltre[i] + "=" + "'" + valFiltre[i] + "');";
		}
		requete = requete+val;
		System.out.println(requete);
		ResultSet valiny ;
		try
		{
			resultats = Execute(requete);
			valiny = Execute(requete);
			ResultSetMetaData rsmd = resultats.getMetaData();
			boolean next = resultats.next();
			int nbCols = rsmd.getColumnCount();
                        System.out.print(nbCols);
                      List l = new LinkedList();
			while (next)
			{
                                
				System.out.println(resultats.getString(2));

                          }
                        resultats.close();
                                
                        
			
		} 
		catch (SQLException e) 
		{
			System.out.println("io ehhhhhh: "+e.getMessage());
		}
		return or;
	} 
        public static void main(String[] args){
           Fonctions fonc = new Fonctions();
           String nom = "NOM";
           String val = "Randria";
           List l = new LinkedList();
           fonc.selecte(nom,val);
        }
}
             
           /*Enfant o = new Enfant();
           String[] nomColFiltre = new String[1];
          nomColFiltre[0] = "NOM";
           String[] valFiltre = new String[1];
           valFiltre[0] = "Randria";
           String nomTable = "ENFANT";
           try{
                o =  (Enfant) fonc.findToTables(o,nomColFiltre, valFiltre,nomTable); 
                 
                String nom2 = o.getNOM().toString(); 
                String nom3 = o.getPRENOM().toString();
                String nom4 = o.getDATENAISSANCE().toString();
                
                System.out.println("nom " + nom2);
                System.out.println("pre " + nom3);
                System.out.println("date " + nom4);
           }
           catch(Exception e){
               System.out.println("iiii " +e);
           }
          
           //Object[] data = {"NOM","Randria" };
           //String coll = fonc.findToTable(o,data);
           //System.out.println(coll);
         
            /*String nom = "Randria";
            String prenom = "Faneva";
            String naissance = "2002/09/20";
            Date nais =  fonc.converDate(naissance);
            String sexe= "Masculin";
            String adresse = "Lot FAIV 28 Malaho Bevalala";
            String prof = "Manager";
            int idP = 1;
            int idM = 2;
            Enfant e = new Enfant(nom,prenom,nais,sexe,adresse);
            Parents enf = new Parents(nom,prenom,prof,adresse);
            String enfant = "ENFANT";
            int insertable = 7;
            try{
                insertable = fonc.insertToTable(e,enfant);
            }
            catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
            
            System.out.println(insertable);*/

            
       


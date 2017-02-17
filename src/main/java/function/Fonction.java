/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import admin.Ecolage;
import admin.Section;
import connexion.ConnectBase;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import peronne.Enfant;
import peronne.Parents;
import peronne.Personne;

/**
 *
 * @author itu
 */
public class Fonction {
   
        
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
       
               public int updateToTable(Object o, String nomTable,String condition,String col) throws Exception
	{
             
            c = con.connect();
            
           
           int status =0;
			Method met = o.getClass().getMethod("Update");
			String valCol = (String)met.invoke(o,null);
                        
                        String requete = "UPDATE "+ nomTable + " SET "+ valCol + " WHERE "+col+" = "+condition;
			//String requete = "INSERT INTO " + nomTable + "( " + valueCol + ") VALUES (" + valCol + ")";
			 System.out.println(requete);
                      
                        try {

                                     stmt = c.createStatement(); 
                                    stmt.executeUpdate(requete);
                                    String comm = "commit";
                                    stmt.executeUpdate(comm);
                                         
                            
                                    
                                    System.out.println("execution reussie");  
                                            //resultats.close();
                            }
                                    catch (Exception e)
                                {
                                            System.out.println(e);
                            }
			return status;
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
        public ResultSet find(String table, String[] col, String [] nomColFiltre, String[][] filtre, String[] groupByClause){
         c = con.connect();
         ResultSet res = null;
        String where="";
        String colonne ="";
        String groupBy ="";
        if(col!=null){
            for(int i=0; i<col.length; i++){
                colonne+= col[i];
                if(i!=col.length-1){
                    colonne+=", ";
                }
            }
        }
        else{
            colonne = "*";
        }
        String sql="SELECT " +colonne+ " FROM "+ table+" "+where;
        
        if(nomColFiltre != null && filtre !=null){
        	where = " WHERE ";
			for(int i = 0; i< nomColFiltre.length ; i++){
				where += nomColFiltre[i] + filtre[0][i] + filtre[1][i];
				if(i != nomColFiltre.length-1){
					where=where+" AND ";
				}
			}
			sql=sql+where;			
        }
        if(groupByClause!= null){
            for(int i=0; i< groupByClause.length; i++){
                groupBy += groupByClause[i];
                if(i<groupByClause.length-1){
                    groupBy+=", ";
                }
            }
            //System.out.println(groupBy);
            groupBy=" GROUP BY "+groupBy;
            sql+=groupBy;
             
        }

        try {
            stmt = c.createStatement();
            res = stmt.executeQuery(sql);
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
       
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
        public String getconverDate(Date dateInString){
            Format formatter = new SimpleDateFormat("dd MMMM yyyy");
            String s = formatter.format(dateInString);
            return s;
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
                        String sexe = rs.getString("SEXE");
                        String isAdmin = rs.getString("ADRESSE");
                        String ref_eleve = rs.getString("REF_ELEVE");
                        enf.setIDENFANT(id);
                        enf.setNOM(firstName);
                        enf.setPRENOM(lastName);
                        enf.setDATENAISSANCE(dateCreated);
                        enf.setSEXE(sexe);
                        enf.setADRESSE(isAdmin);
                        enf.setREF_ELEVE(ref_eleve);
                        
                      }
                      
                
               }
                catch(Exception e)
                {

                }
             return enf;
            
        }
        public Section getBranche(int branche){
            String table = "branche";
            Section par = new Section();
            String[] nomColFiltre = new String[]{"idbranche"};
            String[][] filtre = new String[][]{{" = "},{"'"+branche+"'"}};
            resultats = this.find(table, null, nomColFiltre, filtre,null);
                    try {
                            while(resultats.next()){ 
                                    par.setIDBRANCHE(resultats.getInt("IDBRANCHE"));
                                    par.setBRANCHE(resultats.getString("BRANCHE"));
                                    par.setAGE_DEBUT(resultats.getInt("AGE_DEBUT"));
                                    par.setAGE_FIN(resultats.getInt("AGE_FIN"));
                            }      
                    } catch (SQLException e) {
                            e.printStackTrace();                       
                    }
                
               
            return par;
        }
        public int getCategorie(Date ajout)throws Exception{
            Date now = new Date();
            Calendar c = Calendar.getInstance();
            Calendar c1 = Calendar.getInstance();
            c.setTime(now);
            c1.setTime(ajout);
            int mois = c.get(Calendar.MONTH)+1;
            int years = c.get(Calendar.YEAR);
            int an=0,temp=0,volana =0;
            int mois1 = c1.get(Calendar.MONTH)+1;
            int years1 = c1.get(Calendar.YEAR);
            if(years > years1){
                 an = (years - years1)*12;
                 volana = mois - mois1;
                 temp = an + volana;
            }
            if(years == years1){
                    if(mois>mois1){
                         an = (years - years1)*12;
                            volana = mois - mois1;
                            temp = an + volana;
                    }
                    else throw new Exception("erreur");
            }
            if(years<years1) throw new Exception("erreur date");
             
           
            return temp;
            
        }
        public int setSection(int age)throws Exception{
            int rep =0;
            Section sec1 = new Section();
            int branche1 = 1;
            Section sec2 = new Section();
            int branche2 = 2;
            Section sec3 = new Section();
            int branche3 = 3;
            sec1 = this.getBranche(branche1);
            sec2 = this.getBranche(branche2);
            sec3 = this.getBranche(branche3);
            if(age>=sec1.getAGE_DEBUT() && age<sec1.getAGE_FIN()){
                rep = branche1;
            }
            if(age>=sec2.getAGE_DEBUT() && age<sec2.getAGE_FIN()){
                rep = branche2;
            }
            if(age>=sec3.getAGE_DEBUT() && age<=sec3.getAGE_FIN()){
                rep = branche3;
            }
            if(age<sec1.getAGE_DEBUT() || age>sec3.getAGE_FIN()) 
            {throw new Exception("pas de section");}
            return rep;
            
        }
         public ArrayList foundParent(String ideleve,String val){
             
                  c = con.connect();
                  
                  ArrayList list = new ArrayList();
                  
             try
              {
                Statement stm = c.createStatement ();
                ResultSet rs = stm.executeQuery("select * from parents where "+ideleve+" = '"+val+"'");
                ResultSetMetaData rsmd = rs.getMetaData();
                int nbCols = rsmd.getColumnCount();
                 
                while(rs.next())
                {
                     
                        Parents par = new Parents();
                         int id = rs.getInt("IDPARENTS");
                        String firstName = rs.getString("NOM");
                        String lastName = rs.getString("PRENOMS");
                        String dateCreated = rs.getString("PROFESSION");
                        String adresse = rs.getString("ADRESSE");
                        String contact = rs.getString("CONTACT");
                        par.setIDPARENT(id);
                        par.setNOM(firstName);
                        par.setPRENOM(lastName);
                        par.setPROFESSION(dateCreated);
                        par.setADRESSE(adresse);
                        par.setCONTACT(contact);
                        list.add(par);
                      }
               }
                catch(Exception e)
                {

                }
             return list;
            
        }
          public ArrayList selectBranche(){
             
                  c = con.connect();
                  
                  ArrayList list = new ArrayList();
                  
             try
              {
                Statement stm = c.createStatement ();
                ResultSet rs = stm.executeQuery("select * from branche");
                ResultSetMetaData rsmd = rs.getMetaData();
                int nbCols = rsmd.getColumnCount();
                 
                while(rs.next())
                {
                     
                        Section par = new Section();
                        par.setIDBRANCHE(rs.getInt("IDBRANCHE"));
                        par.setBRANCHE(rs.getString("BRANCHE"));
                        par.setAGE_DEBUT(rs.getInt("AGE_DEBUT"));
                        par.setAGE_FIN(rs.getInt("AGE_FIN"));
                        list.add(par);
                      }
               }
                catch(Exception e)
                {

                }
             return list;
            
        }    
           public ArrayList selectEcolage(){
             
                  c = con.connect();
                  
                  ArrayList list = new ArrayList();
                  
             try
              {
                Statement stm = c.createStatement ();
                ResultSet rs = stm.executeQuery("SELECT * FROM SELECT_ECOLAGE");
                ResultSetMetaData rsmd = rs.getMetaData();
                int nbCols = rsmd.getColumnCount();
                 
                while(rs.next())
                {
                     
                        Ecolage par = new Ecolage();
                        par.setECOLAGE(rs.getInt("ECOLAGE"));
                        par.setBRANCHE(rs.getString("BRANCHE"));
                        par.setANNEE(rs.getString("ANNEE"));
                        par.setAGE_DEBUT(rs.getInt("AGE_DEBUT"));
                        par.setAGE_FIN(rs.getInt("AGE_FIN"));
                        list.add(par);
                      }
               }
                catch(Exception e)
                {

                }
             return list;
            
        }    
          public Parents selecteP(String ideleve,String val){
             
                  c = con.connect();
                  
                  Parents par = new Parents();
                  
             try
              {
                Statement stm = c.createStatement ();
                ResultSet rs = stm.executeQuery("select * from parents where "+ideleve+" = '"+val+"'");
                ResultSetMetaData rsmd = rs.getMetaData();
                int nbCols = rsmd.getColumnCount();
                 
                while(rs.next())
                {
                     
                        
                         int id = rs.getInt("IDPARENTS");
                        String firstName = rs.getString("NOM");
                        String lastName = rs.getString("PRENOMS");
                        String dateCreated = rs.getString("PROFESSION");
                        String adresse = rs.getString("ADRESSE");
                        String contact = rs.getString("CONTACT");
                        par.setIDPARENT(id);
                        par.setNOM(firstName);
                        par.setPRENOM(lastName);
                        par.setPROFESSION(dateCreated);
                        par.setADRESSE(adresse);
                        par.setCONTACT(contact);
                         
                      }
               }
                catch(Exception e)
                {

                }
             return par;
            
        }
        
       public int deleteFromTable(String nomTable,String idel,String idcol) throws Exception
	{
             
            c = con.connect();
            
           
           int status =0;
			String requete = "DELETE FROM "+nomTable+" WHERE "+idcol+" = '"+idel+"'";
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
      
        
}

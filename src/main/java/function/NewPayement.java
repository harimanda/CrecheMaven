/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import admin.Ecolage;
import admin.Mois;
import admin.PayeEcolage;
import connexion.ConnectBase;
import ecolage.Facture;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import peronne.Enfant;

/**
 *
 * @author itu
 */
public class NewPayement {
        private  Connection bdd;
        private  Statement st= null;
        private ConnectBase con = new ConnectBase();  
        private Fonction fonc = new Fonction();
        private ResultSet res = null;
        private  boolean valiny;
        public ResultSet find(String table, String[] col, String [] nomColFiltre, String[][] filtre, String[] groupByClause){
        bdd = con.connect();
        
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
            System.out.println(sql);
        }

        try {
             System.out.println(sql);
            st = bdd.createStatement();
            res = st.executeQuery(sql);
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public Mois[] getMoisActivite(){
        Mois[] val = null;
        String table = "mois_activite";
        String[] colonne = new String[]{"mois","representant"};
        res = this.find(table, colonne, null, null, null);
         Vector vec = new Vector();
		try {
                    
			while(res.next()){
				Mois temp = new Mois();
				temp.setMonth(res.getString("mois"));
                                temp.setReference(res.getInt("representant"));
                                vec.add(temp);	
			}
                         val = new Mois[vec.size()];
                                for(int i = 0; i<vec.size() ; i++){
                                        val[i] = (Mois)vec.get(i);
                                }
                }
                catch(Exception e){
                    
                }
                return val;
    }
     public Mois getMoisActivites(int repre){
        Mois val = new Mois();
        String table = "mois_activite";
        String[] colonne = new String[]{"mois"};
        String[] colfiltre = new String[]{"representant"};
	String[][] filtres = new String[][]{{" = "},{"'"+repre +"'"}};
        res = find(table,colonne,colfiltre,filtres,null);
        
         Vector vec = new Vector();
		try {
                    
			while(res.next()){
				 
				val.setMonth(res.getString("mois"));
                                
			}
                          
                }
                catch(Exception e){
                    
                }
                return val;
    }
     public boolean verifEcoP(String mois,String annee,String ideleve){
         valiny = false;
        String table = "ecolage";
        String[] colonne = new String[]{"IDELEVE"};
	String[] colfiltre =  null;
	String[][] filtres =  null;
        String annee1 = "2017";
        if(mois != null && annee !=null) {
        colfiltre = new String[]{"IDELEVE","ANNEE","MOIS"};
	filtres = new String[][]{{" = "," = "," = "},{"'"+ideleve +"'","'"+annee+"'","'"+mois+"'"}};
        }
        if(mois == null){
             colfiltre = new String[]{"IDELEVE","ANNEE"};
             filtres = new String[][]{{" = "," BETWEEN '"+annee+"' AND "},{"'"+ideleve +"'","'"+annee1+"'"}};
        }
	res = this.find(table, colonne, colfiltre, filtres, null);
        Vector vec = new Vector();
		try {
                    
			while(res.next()){
				PayeEcolage temp = new PayeEcolage();
				 
					temp.setIDELEVE(res.getInt("IDELEVE"));
                                        
					vec.add(temp);
				
			}
			int sizet = vec.size();
                        if(sizet == 0){
                            valiny = true;
                        }
                      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return valiny;
     }
    public Enfant[] getAllEleve(){
        Enfant[] enf = null;
        String table="ELEVE";
        ResultSet res = find(table,null,null,null,null);
        Vector vec = new Vector();
		try {
			while(res.next()){
				Enfant temp = new Enfant();
				 
					temp.setIDENFANT(res.getInt("IDELEVE"));
                                        temp.setREF_ELEVE(res.getString("REF_ELEVE"));
                                        temp.setNOM(res.getString("NOM"));
                                        temp.setPRENOM(res.getString("PRENOM"));
                                        temp.setDATENAISSANCES(res.getString("DATENAISSANCE"));
                                        temp.setADRESSE(res.getString("ADRESSE"));
                                        temp.setDATE_INSCRIPTION(res.getDate("DATE_INSCRIPTION"));
					vec.add(temp);
				 
				
			}
			enf  = new Enfant[vec.size()];
			for(int i = 0; i<vec.size() ; i++){
				enf[i] = (Enfant)vec.get(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		return enf;
    }
    public Enfant getEleve(String idel){
        Enfant temp = new Enfant();
        String table="ELEVE";
        String[] colfiltre = new String[]{"IDELEVE"};
	String[][] filtres = new String[][]{{" = "},{"'"+idel +"'"}};
        res = find(table,null,colfiltre,filtres,null);
		try {
			while(res.next()){
					temp.setIDENFANT(res.getInt("IDELEVE"));
                                        temp.setREF_ELEVE(res.getString("REF_ELEVE"));
                                        temp.setNOM(res.getString("NOM"));
                                        temp.setPRENOM(res.getString("PRENOM"));
                                        temp.setDATENAISSANCES(res.getString("DATENAISSANCE"));
                                        temp.setDATENAISSANCE(res.getDate("DATENAISSANCE"));
                                        temp.setADRESSE(res.getString("ADRESSE"));
                                        temp.setDATE_INSCRIPTION(res.getDate("DATE_INSCRIPTION"));
                                        temp.setBRANCHE(res.getInt("BRANCHE"));
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		return temp;
    }
    public int payeEcolage(String ideleve,String ecolage,String datepaye,String annee,String mois)throws Exception
    {
        PayeEcolage e = new PayeEcolage();
        String table = "ECOLAGE";
        int rep =0;
        valiny = this.verifEcoP(mois, annee, ideleve);
        if(valiny = true){
             e.setIDELEVE(Integer.parseInt(ideleve));
             e.setECOLAGE(Double.parseDouble(ecolage));
             e.setDATEPAYE(fonc.converDate(datepaye));
             e.setANNEE(annee);
             e.setMOIS(Integer.parseInt(mois));
             rep = fonc.insertToTable(e, table);
        }
        else throw new Exception("Ecolage d&eacute;j&agrave; pay&eacute;");
        return rep;
    }
    public Facture[] getUnpayedEcolgae(String ideleve,String moiss,String annee){
        bdd = con.connect();
        Facture[] rep = null;
        Enfant enf = new Enfant();
        enf = this.getEleve(ideleve);
        Date dateInscription = enf.getDATE_INSCRIPTION();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(dateInscription);
        int mois = c1.get(Calendar.MONTH)+1;
        int years = c1.get(Calendar.YEAR);
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        int mois1 = c.get(Calendar.MONTH)+1;
        int years1 = c.get(Calendar.YEAR);
        String sql="";
        if(moiss.compareTo("")==0 && annee.compareTo("")==0){
        sql= "SELECT * FROM ecolage_a_paye t1 WHERE NOT EXISTS "
                 + "(SELECT 1 FROM ecolage t2 WHERE t1.mois = t2.mois and t2.ideleve ='"+ ideleve + "')"
                 + " and t1.annee BETWEEN '"+ years1 +"' AND '"+years+"' and t1.idbranche= '"+enf.getBRANCHE()+"'";
        }
        if(moiss.compareTo("")!=0){
            sql= "SELECT * FROM ecolage_a_paye t1 WHERE NOT EXISTS "
                 + "(SELECT 1 FROM ecolage t2 WHERE t1.mois = t2.mois and t2.ideleve ='"+ ideleve + "')"
                 + " and t1.annee BETWEEN '"+ years1 +"' AND '"+years+"' and t1.idbranche= '"+enf.getBRANCHE()+"' and t1.mois='"+moiss+"'";
        }
        if(annee.compareTo("")!=0){
            sql= "SELECT * FROM ecolage_a_paye t1 WHERE NOT EXISTS "
                    + "(SELECT 1 FROM ecolage t2 WHERE t1.mois = t2.mois and t2.ideleve ='"+ ideleve + "')"
                    + " and t1.annee ='"+ annee+"'and t1.idbranche= '"+enf.getBRANCHE()+"'";
        }
        if(annee.compareTo("")!=0 && moiss.compareTo("")!=0){
            sql= "SELECT * FROM ecolage_a_paye t1 WHERE NOT EXISTS "
                    + "(SELECT 1 FROM ecolage t2 WHERE t1.mois = t2.mois and t2.ideleve ='"+ ideleve + "')"
                    + " and t1.annee ='"+ annee+"'and t1.idbranche= '"+enf.getBRANCHE()+"'and t1.mois='"+moiss+"'";
        }
         Vector vec = new Vector();
		try {
                    System.out.println(sql);
			st = bdd.createStatement();
                        res = st.executeQuery(sql);
                        while(res.next()){
                            Facture eco = new Facture();
                            eco.setIDECOLAGE_AP(res.getInt("IDECOLAGE_AP"));
                            eco.setECOLAGE(res.getDouble("ECOLAGE"));
                            eco.setMOIS(res.getInt("MOIS"));
                            eco.setIDBRANCHE(res.getInt("IDBRANCHE"));
                            eco.setANNEE(res.getInt("ANNEE"));
                            eco.setIDELEVE(enf.getIDENFANT());
                            eco.setREF_ELEVE(enf.getREF_ELEVE());
                            vec.add(eco);
                        }     
                        rep  = new Facture[vec.size()];
			for(int i = 0; i<vec.size() ; i++){
				rep[i] = (Facture)vec.get(i);
			}
                        
                }
                catch(Exception e){
                    
                }
        return rep;
    }
    public Facture[] splitFacture(String[] fact){
        int tailleE = fact.length;
        Facture[] temp= new Facture[tailleE];
        String[] idfact=new String[tailleE];
        String[] ideleve=new String[tailleE];
	String[] total = null;
        String sql ="";
           String p="";
            for(int i = 0; i<tailleE ; i++){
                if(i>0){
                    p =p+","+ fact[i];
                 }
                else{
                    p=fact[i];
                }
            }
             total=p.split(",");                                        
                 int x=0;
                 for(int o=0;o<total.length;o=o+2){                                                         
                     idfact[x] = total[o];
                     ideleve[x] = total[o+1];
                     x++;                
                 }
                 for(int h=0;h<idfact.length;h++){
                    temp[h] = new Facture();
                    temp[h].setIDECOLAGE_AP(Integer.parseInt(idfact[h]));
                    temp[h].setIDELEVE(Integer.parseInt(ideleve[h]));
                }
                /* for(int o=0;o<idfact.length;o++){
                     sql= "SELECT * FROM ecolage_a_paye WHERE idecolage_ap = '"+idfact[o]+"'";
                     System.out.println(sql);
                 }*/
        
        return temp;
    }
    public Facture getFacture(int idfact){
        Facture fact = null;
        String table="ECOLAGE_A_PAYE";
        String[] colfiltre = new String[]{"idecolage_ap"};
	String[][] filtres = new String[][]{{" = "},{"'"+idfact +"'"}};
        res = find(table,null,colfiltre,filtres,null);
		try {
			while(res.next()){
                            fact = new Facture();
                            fact.setIDECOLAGE_AP(res.getInt("IDECOLAGE_AP"));
                            fact.setIDBRANCHE(res.getInt("IDBRANCHE"));
                            fact.setECOLAGE(res.getDouble("ECOLAGE"));
                            fact.setMOIS(res.getInt("MOIS"));
                            fact.setANNEE(res.getInt("ANNEE"));
			} 
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
        return fact;
    }
    public static void main(String[] args){
        Ecolage[] eco = null;
        NewPayement fon = new NewPayement();
        String ideleve = "2";
        String annee = "2017";
        Date n = new Date();
        Fonction fi = new Fonction();
        annee = fi.getconverDate(n);
        System.out.println(annee);
        
        int m = 2;
        String[] mois = new String[]{"11,14","12,14"};
        String annees = null;
        Facture[] fact = fon.splitFacture(mois);
       /* for(int i=0;i<fact.length;i++){
            
            System.out.println(fact[i].getIDECOLAGE_AP()+" "+fact[i].getIDELEVE());
        }
       // System.out.println(fact.length);
        //Mois mo = fon.getMoisActivites(m);
       /*for(int i=0;i<fact.length;i++){
            System.out.println(fact[i].getREF_ELEVE()+" "+fact[i].getIDBRANCHE()+" "+fact[i].getECOLAGE()+" "+fact[i].getMOIS()+" "+fact[i].getANNEE());
         }*/
       // String mois="2";
        boolean bool = false;
        //bool = fon.verifEcoP(null, annee, ideleve);
        //System.out.println(mo.getMonth());
        //fon.getUnpayedEcolgae(ideleve);
    }
}

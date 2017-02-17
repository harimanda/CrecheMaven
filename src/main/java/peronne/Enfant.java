/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peronne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author itu
 */
public class Enfant{
        private int IDENFANT;
	private String NOM;
	private String PRENOM;
	private Date DATENAISSANCE;
	private String SEXE;
        private String ADRESSE;
        private int IDPERE;
        private int IDMERE;
        private String REF_ELEVE;
        private int BRANCHE;
        private Date DATE_INSCRIPTION;

    
	public Enfant(){

	}
	public Enfant( String nom, String prenom, Date dateNaissance, String sexe ,String idAttribut) {
        
        this.NOM = nom;
        this.PRENOM = prenom;
        this.DATENAISSANCE = dateNaissance;
        this.SEXE = sexe;
        this.ADRESSE = idAttribut;
        
        }

    public Date getDATE_INSCRIPTION() {
        return DATE_INSCRIPTION;
    }

    public void setDATE_INSCRIPTION(Date DATE_INSCRIPTION) {
        this.DATE_INSCRIPTION = DATE_INSCRIPTION;
    }
        
    public int getBRANCHE() {
        return BRANCHE;
    }

    public void setBRANCHE(int BRANCHE) {
        this.BRANCHE = BRANCHE;
    }
        
	public int getIDENFANT() {
		return IDENFANT;
    }

    public String getREF_ELEVE() {
        return REF_ELEVE;
    }

    public void setREF_ELEVE(String REF_ELEVE) {
        this.REF_ELEVE = REF_ELEVE;
    }
        
    public void setIDENFANT(int idPersonne) {
        this.IDENFANT = idPersonne;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String nom) {
        this.NOM = nom;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String prenom) {
        this.PRENOM = prenom;
    }

    public Date getDATENAISSANCE() {
        return DATENAISSANCE;
    }

    public void setDATENAISSANCE(Date dateNaissance) {
        this.DATENAISSANCE = dateNaissance;
    }
     public void setDATENAISSANCES(String dateNaissance) {
         Date fin = converDates(dateNaissance);
        this.DATENAISSANCE = fin;
    }

    public String getSEXE() {
        return SEXE;
    }

    public void setSEXE(String sexe) {
        this.SEXE = sexe;
    }
    public String getADRESSE() {
        return ADRESSE;
    }
    public int getIDPERE() {
        return IDPERE;
    }

    public void setIDPERE(int IDPERE) {
        this.IDPERE = IDPERE;
    }

    public int getIDMERE() {
        return IDMERE;
    }

    public void setIDMERE(int IDMERE) {
        this.IDMERE = IDMERE;
    }
        
    public void setADRESSE(String IDATTRIBUT) {
        this.ADRESSE = IDATTRIBUT;
    }
        public String sorato(String col,String arg) {
            return "SELECT * FROM ELEVE WHERE "+ col +" = '" + arg + "'";
          }
        public String getAll(){
            return "SELECT * FROM ELEVE";
        }
	 public String getId()
	{
		return "IDELEVE='"+IDENFANT+"'";
	}
          public Date converDates(String dateInString){
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
         public void construct(List l){
              
             this.IDENFANT = Integer.parseInt((String)l.get(0));
             this.NOM = (String) l.get(1);
             this.PRENOM = (String) l.get(2);
             
             this.DATENAISSANCE = converDates((String)l.get(3));
             
         }
         public String getValue()
	{
               
		String valC= "NOM,PRENOM,DATENAISSANCE,SEXE,ADRESSE,REF_ELEVE,BRANCHE,DATE_INSCRIPTION";
		return valC;
	}
	public String getCol()
	{
               Date NOW = new Date();
		String args= "'" + NOM + "','" + PRENOM + "','" + DATENAISSANCE + "','" + SEXE + "','" + ADRESSE + "',CONCAT('ELV',nextval('REF_ELEVE_SEQ')),'"+BRANCHE+"','"+NOW+"'" ;
		return args;
	}
	public String Update()
	{
		return "NOM='"+NOM+"',PRENOM='"+PRENOM+"',DATENAISSANCE='"+DATENAISSANCE+"',SEXE='"+SEXE+"',ADRESSE='"+ADRESSE+"'";
	}
        public void addV(String v){
            System.out.println(v);
        }
}

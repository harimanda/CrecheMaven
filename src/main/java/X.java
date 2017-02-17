/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itu
 */
import java.lang.reflect.Method;
import java.util.Date;
//www  .  jav a2  s.c om
class X {
   private int IDENFANT;
	private String NOM;
	private String PRENOM;
	private Date DATENAISSANCE;
	private String SEXE;
        private String ADRESSE;
        private int IDPERE;
        private int IDMERE;

    
	public X(){

	}
	public X( String nom, String prenom, Date dateNaissance, String sexe ,String idAttribut) {
        
        this.NOM = nom;
        this.PRENOM = prenom;
        this.DATENAISSANCE = dateNaissance;
        this.SEXE = sexe;
        this.ADRESSE = idAttribut;
        
        }
	public int getIDENFANT() {
		return IDENFANT;
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
        public void sorato(String arg,String k) {
            System.out.println("Instance method: " + arg + " " + k);
          }
	 public String getId()
	{
		return "IDENFANT='"+IDENFANT+"'";
	}
	public String getCol()
	{
               
		String args= "'" + NOM + "','" + PRENOM + "','" + DATENAISSANCE + "','" + SEXE + "','" + ADRESSE + "'"  ;
		return args;
	}
	public String Update()
	{
		return "',NOM='"+NOM+"',PRENOM='"+PRENOM+"',DATENAISSANCE='"+DATENAISSANCE+"',SEXE='"+IDPERE+"',IDPERE='"+IDMERE+"',IDMERE='"+SEXE+"'',ADRESSE='"+ADRESSE+"'";
	}
}



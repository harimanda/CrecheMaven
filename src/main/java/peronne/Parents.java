/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peronne;

/**
 *
 * @author itu
 */
public class Parents {
    private int IDPARENT;
    private String CONTACT;
    private String NOM;
    private String PRENOM;
    private String  PROFESSION;
    private String ADRESSE;
    private int IDELEVE;

    public Parents( String nom, String prenom, String prof,String adr,String contact,String ideleve) {
        
        this.NOM = nom;
        this.PRENOM = prenom;
        this.PROFESSION = prof;
        this.ADRESSE = adr;
        this.CONTACT = contact;
        this.IDELEVE = Integer.parseInt(ideleve);
    }

    public Parents() {
         
    }

    public int getIDPARENT() {
        return IDPARENT;
    }

    public void setIDPARENT(int IDPARENT) {
        this.IDPARENT = IDPARENT;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }

    public int getIDELEVE() {
        return IDELEVE;
    }

    public void setIDELEVE(int IDELEVE) {
        this.IDELEVE = IDELEVE;
    }

     

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getPROFESSION() {
        return PROFESSION;
    }

    public void setPROFESSION(String PROFESSION) {
        this.PROFESSION = PROFESSION;
    }

    public String getADRESSE() {
        return ADRESSE;
    }

    public void setADRESSE(String ADRESSE) {
        this.ADRESSE = ADRESSE;
    }
    public String getValue(){
        String valueC = "NOM,PRENOMS,PROFESSION,CONTACT,ADRESSE,IDELEVE";
		return valueC;
    }
     
	public String getCol()
	{
              
		String args= "'" + NOM + "','" + PRENOM + "','" + PROFESSION + "','" + CONTACT + "','" + ADRESSE + "','" + IDELEVE + "'"  ;
		return args;
	}
	public String Update()
	{
		return "NOM='"+NOM+"',PRENOMS='"+PRENOM+"',PROFESSION='"+PROFESSION+"',ADRESSE='"+ADRESSE+"',CONTACT='"+CONTACT+"'";
	}
    
}

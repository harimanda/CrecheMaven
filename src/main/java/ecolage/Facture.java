/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecolage;

import java.util.Date;

/**
 *
 * @author itu
 */
public class Facture {
    private int IDECOLAGE_AP;
    private int IDBRANCHE;
    private double ECOLAGE;
    private int MOIS;
    private int ANNEE;
    private int IDELEVE;
    private String REF_ELEVE;
    private Date DATE_EDITION;
    private Date DATE_EXPIRATION;

    public Facture() {
    }

    public int getIDECOLAGE_AP() {
        return IDECOLAGE_AP;
    }

    public Date getDATE_EDITION() {
        return DATE_EDITION;
    }

    public void setDATE_EDITION(Date date_edition) {
        this.DATE_EDITION = date_edition;
    }

    public Date getDATE_EXPIRATION() {
        return DATE_EXPIRATION;
    }

    public void setDATE_EXPIRATION(Date date_expiration) {
        this.DATE_EXPIRATION = date_expiration;
    }
    
    public void setIDECOLAGE_AP(int IDECOLAGE_AP) {
        this.IDECOLAGE_AP = IDECOLAGE_AP;
    }

    public int getIDBRANCHE() {
        return IDBRANCHE;
    }

    public void setIDBRANCHE(int IDBRANCHE) {
        this.IDBRANCHE = IDBRANCHE;
    }

    public double getECOLAGE() {
        return ECOLAGE;
    }

    public void setECOLAGE(double ECOLAGE) {
        this.ECOLAGE = ECOLAGE;
    }

    public int getMOIS() {
        return MOIS;
    }

    public void setMOIS(int MOIS) {
        this.MOIS = MOIS;
    }

    public int getANNEE() {
        return ANNEE;
    }

    public void setANNEE(int ANNEE) {
        this.ANNEE = ANNEE;
    }

    public int getIDELEVE() {
        return IDELEVE;
    }

    public void setIDELEVE(int IDELEVE) {
        this.IDELEVE = IDELEVE;
    }

    public String getREF_ELEVE() {
        return REF_ELEVE;
    }

    public void setREF_ELEVE(String REF_ELEVE) {
        this.REF_ELEVE = REF_ELEVE;
    }
    public String getValue()
	{
               
		String valC= "REF_FACTURE,ID_ELEVE,ECOLAGE,DATE_EDITION,DATE_EXPIRATION";
		return valC;
	}
	public String getCol()
	{
               Date NOW = new Date();
		String args= "CONCAT('FACT',nextval('fature_mere_id_facture_m_seq')),'" + IDELEVE + "','" + ECOLAGE + "','" + DATE_EDITION + "','" + DATE_EXPIRATION + "'" ;
		return args;
	}
    
}

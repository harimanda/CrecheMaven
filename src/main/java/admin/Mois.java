/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author itu
 */
public class Mois {
    private String month;
    private int reference;
    private int annee;
    private int idbranche;
    private double ecolage;

    public Mois() {
    }

    public double getEcolage() {
        return ecolage;
    }

    public void setEcolage(double ecolage) {
        this.ecolage = ecolage;
    }
    
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getIdbranche() {
        return idbranche;
    }

    public void setIdbranche(int idbranche) {
        this.idbranche = idbranche;
    }
    
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }
       public String getValue()
	{
               
		String valC= "IDBRANCHE,ECOLAGE,ANNEE,MOIS";
		return valC;
	}
	public String getCol()
	{
               
		String args= "'" + idbranche + "','" + ecolage + "','" + annee + "','" + reference + "'"  ;
		return args;
	}
    
     
}

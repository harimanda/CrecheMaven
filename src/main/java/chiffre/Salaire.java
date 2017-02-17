/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chiffre;

import peronne.Personnel;

/**
 *
 * @author itu
 */
public class Salaire
{
	private int IDSALAIRE;
	private Personnel IDPERSONNEL;
	private double SALAIRE;
	private String SITUATION;
	 
	public Salaire(int idSalaire, Personnel idPersonnel, double salaire, String situation) {
        this.IDSALAIRE = idSalaire;
        this.IDPERSONNEL = idPersonnel;
        this.SALAIRE = salaire;
        this.SITUATION = situation;
    }
    public Salaire(){

    }
    public int getIDSALAIRE() {
        return IDSALAIRE;
    }

    public void setIDSALAIRE(int idSalaire) {
        this.IDSALAIRE = idSalaire;
    }

    public Personnel getIDPERSONNEL() {
        return IDPERSONNEL;
    }

    public void setIDPERSONNEL(Personnel idPersonnel) {
        this.IDPERSONNEL = idPersonnel;
    }

    public double getSALAIRE() {
        return SALAIRE;
    }

    public void setSALAIRE(double salaire) {
        this.SALAIRE = salaire;
    }

    public String getSITUATION() {
        return SITUATION;
    }

    public void setSITUATION(String situation) {
        this.SITUATION = situation;
    }
}

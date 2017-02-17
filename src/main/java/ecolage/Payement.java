/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecolage;

import peronne.Enfant;

/**
 *
 * @author itu
 */
public class Payement {
    private int IDPAYEMENT;      
    private Enfant IDENFANT;            
    private double ECOLAGE;           
    private String SITUATION; 

    public Payement(int IDPAYEMENT, Enfant IDENFANT, double ECOLAGE, String SITUATION) {
        this.IDPAYEMENT = IDPAYEMENT;
        this.IDENFANT = IDENFANT;
        this.ECOLAGE = ECOLAGE;
        this.SITUATION = SITUATION;
    }
    public Payement(){
        
    }

    public int getIDPAYEMENT() {
        return IDPAYEMENT;
    }

    public void setIDPAYEMENT(int IDPAYEMENT) {
        this.IDPAYEMENT = IDPAYEMENT;
    }

    public Enfant getIDENFANT() {
        return IDENFANT;
    }

    public void setIDENFANT(Enfant IDENFANT) {
        this.IDENFANT = IDENFANT;
    }

    public double getECOLAGE() {
        return ECOLAGE;
    }

    public void setECOLAGE(double ECOLAGE) {
        this.ECOLAGE = ECOLAGE;
    }

    public String getSITUATION() {
        return SITUATION;
    }

    public void setSITUATION(String SITUATION) {
        this.SITUATION = SITUATION;
    }
    
    
}
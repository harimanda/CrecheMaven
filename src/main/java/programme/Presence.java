/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programme;

import peronne.Enfant;

/**
 *
 * @author itu
 */
public class Presence {
   private int IDPRESENCE;                    
   private Enfant IDENFANT;            
   private Activite IDACTIVITE;           
   private String PRESENCE;

    public Presence(int IDPRESENCE, Enfant IDENFANT, Activite IDACTIVITE, String PRESENCE) {
        this.IDPRESENCE = IDPRESENCE;
        this.IDENFANT = IDENFANT;
        this.IDACTIVITE = IDACTIVITE;
        this.PRESENCE = PRESENCE;
    }

    public int getIDPRESENCE() {
        return IDPRESENCE;
    }

    public void setIDPRESENCE(int IDPRESENCE) {
        this.IDPRESENCE = IDPRESENCE;
    }

    public Enfant getIDENFANT() {
        return IDENFANT;
    }

    public void setIDENFANT(Enfant IDENFANT) {
        this.IDENFANT = IDENFANT;
    }

    public Activite getIDACTIVITE() {
        return IDACTIVITE;
    }

    public void setIDACTIVITE(Activite IDACTIVITE) {
        this.IDACTIVITE = IDACTIVITE;
    }

    public String getPRESENCE() {
        return PRESENCE;
    }

    public void setPRESENCE(String PRESENCE) {
        this.PRESENCE = PRESENCE;
    }
   

     
   
}

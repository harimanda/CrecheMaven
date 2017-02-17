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
public class Contact {

   
     private int IDCONTACT;
     private Personne IDPERSONNEL;   
     private String CONTACT;
      public Contact(int IDCONTACT, Personne IDPERSONNEL, String CONTACT) {
        this.IDCONTACT = IDCONTACT;
        this.IDPERSONNEL = IDPERSONNEL;
        this.CONTACT = CONTACT;
    }
      public Contact(){
          
      }

    public int getIDCONTACT() {
        return IDCONTACT;
    }

    public void setIDCONTACT(int IDCONTACT) {
        this.IDCONTACT = IDCONTACT;
    }

    public Personne getIDPERSONNEL() {
        return IDPERSONNEL;
    }

    public void setIDPERSONNEL(Personne IDPERSONNEL) {
        this.IDPERSONNEL = IDPERSONNEL;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }
      
}

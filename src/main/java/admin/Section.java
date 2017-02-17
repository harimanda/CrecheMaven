/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.Date;

/**
 *
 * @author itu
 */
public class Section {
        private int IDBRANCHE;
        private String BRANCHE;
        private int AGE_DEBUT;
        private int AGE_FIN;
        private Date date_entree;
        private int ideleve;

        public Section() {
        }

    public Date getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }

    public int getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(int ideleve) {
        this.ideleve = ideleve;
    }
        
    public int getIDBRANCHE() {
        return IDBRANCHE;
    }

    public void setIDBRANCHE(int IDBRANCHE) {
        this.IDBRANCHE = IDBRANCHE;
    }

    public String getBRANCHE() {
        return BRANCHE;
    }

    public void setBRANCHE(String BRANCHE) {
        this.BRANCHE = BRANCHE;
    }

    public int getAGE_DEBUT() {
        return AGE_DEBUT;
    }

    public void setAGE_DEBUT(int AGE_DEBUT) {
        this.AGE_DEBUT = AGE_DEBUT;
    }

    public int getAGE_FIN() {
        return AGE_FIN;
    }

    public void setAGE_FIN(int AGE_FIN) {
        this.AGE_FIN = AGE_FIN;
    }
    
        
}

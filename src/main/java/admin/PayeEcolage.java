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
public class PayeEcolage {
           private int IDELEVE;
           private double ECOLAGE; 
           private Date DATEPAYE;
           private String ANNEE;
           private int MOIS;

            public PayeEcolage() {
            }

            public int getIDELEVE() {
                return IDELEVE;
            }

            public void setIDELEVE(int IDELEVE) {
                this.IDELEVE = IDELEVE;
            }

            public double getECOLAGE() {
                return ECOLAGE;
            }

            public void setECOLAGE(double ECOLAGE) {
                this.ECOLAGE = ECOLAGE;
            }

            public Date getDATEPAYE() {
                return DATEPAYE;
            }

            public void setDATEPAYE(Date DATEPAYE) {
                this.DATEPAYE = DATEPAYE;
            }

            public String getANNEE() {
                return ANNEE;
            }

            public void setANNEE(String ANNEE) {
                this.ANNEE = ANNEE;
            }

            public int getMOIS() {
                return MOIS;
            }

            public void setMOIS(int MOIS) {
                this.MOIS = MOIS;
            }
            public String getValue()
            {

                    String valC= "IDELEVE,ECOLAGE,DATEPAYE,ANNEE,MOIS";
                    return valC;
            }
            public String getCol()
            {

                    String args= "'" + IDELEVE + "','" + ECOLAGE + "','" + DATEPAYE + "','" + ANNEE + "','" + MOIS +"'";
                    return args;
            }
            
            
           
}

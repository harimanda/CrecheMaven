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
public class FactureFille {
    private int ID_ECOLAGE_AP;
    private Date DATE_EDITION;
    private int ID_FACTURE_M;

    public FactureFille() {
    }

    public int getID_ECOLAGE_AP() {
        return ID_ECOLAGE_AP;
    }

    public void setID_ECOLAGE_AP(int ID_ECOLAGE_AP) {
        this.ID_ECOLAGE_AP = ID_ECOLAGE_AP;
    }

    public Date getDATE_EDITION() {
        return DATE_EDITION;
    }

    public void setDATE_EDITION(Date DATE_EDITION) {
        this.DATE_EDITION = DATE_EDITION;
    }

    public int getID_FACTURE_M() {
        return ID_FACTURE_M;
    }

    public void setID_FACTURE_M(int ID_FACTURE_M) {
        this.ID_FACTURE_M = ID_FACTURE_M;
    }

    
    public String getValue()
	{
               
		String valC= "ID_ECOLAGE_AP,DATE_EDITION,ID_FACTURE_M";
		return valC;
	}
	public String getCol()
	{
               Date NOW = new Date();
		String args= "'" + ID_ECOLAGE_AP + "','" + DATE_EDITION + "',currentval('fature_mere_id_facture_m_seq')" ;
		return args;
	}
    
}

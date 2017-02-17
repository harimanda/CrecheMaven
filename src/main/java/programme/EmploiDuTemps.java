/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programme;

/**
 *
 * @author itu
 */
import java.util.Date;
public class EmploiDuTemps{
	private int IDTEMP;
	private Activite IDACTIVITE;
	private Date DEBUTCOURS;
	private Date FINCOURS;
	private Date DATEAU;

    public EmploiDuTemps(int IDTEMP, Activite IDACTIVITE, Date DEBUTCOURS, Date FINCOURS, Date DATEAU) {
        this.IDTEMP = IDTEMP;
        this.IDACTIVITE = IDACTIVITE;
        this.DEBUTCOURS = DEBUTCOURS;
        this.FINCOURS = FINCOURS;
        this.DATEAU = DATEAU;
    }

    public int getIDTEMP() {
        return IDTEMP;
    }

    public void setIDTEMP(int IDTEMP) {
        this.IDTEMP = IDTEMP;
    }

    public Activite getIDACTIVITE() {
        return IDACTIVITE;
    }

    public void setIDACTIVITE(Activite IDACTIVITE) {
        this.IDACTIVITE = IDACTIVITE;
    }

    public Date getDEBUTCOURS() {
        return DEBUTCOURS;
    }

    public void setDEBUTCOURS(Date DEBUTCOURS) {
        this.DEBUTCOURS = DEBUTCOURS;
    }

    public Date getFINCOURS() {
        return FINCOURS;
    }

    public void setFINCOURS(Date FINCOURS) {
        this.FINCOURS = FINCOURS;
    }

    public Date getDATEAU() {
        return DATEAU;
    }

    public void setDATEAU(Date DATEAU) {
        this.DATEAU = DATEAU;
    }
    
	
}

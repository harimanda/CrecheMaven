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
public class Activite{
	private int IDACTIVITE;
	private String PROGRAMME;
	public Activite(int idActivite, String programme) {
        this.IDACTIVITE = idActivite;
        this.PROGRAMME = programme;
    }
    public Activite(){
    	
    }
    public int getIDACTIVITE() {
        return IDACTIVITE;
    }

    public void setIDACTIVITE(int idActivite) {
        this.IDACTIVITE = idActivite;
    }

    public String getPROGRAMME() {
        return PROGRAMME;
    }

    public void setPROGRAMME(String programme) {
        this.PROGRAMME = programme;
    }
	
}

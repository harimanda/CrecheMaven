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
import java.util.Date;
public class Personne{
	private int IDPERSONNEL;
	private String NOM;
	private String PRENOM;
	private Date DATENAISSANCE;
	private String SEXE;
        private Attribut IDATTRIBUT;
	public Personne(){

	}
	public Personne(int idPersonne, String nom, String prenom, Date dateNaissance, String sexe, Attribut idAttribut) {
        this.IDPERSONNEL = idPersonne;
        this.NOM = nom;
        this.PRENOM = prenom;
        this.DATENAISSANCE = dateNaissance;
        this.SEXE = sexe;
        this.IDATTRIBUT = idAttribut;
        }
	public int getIDPERSONNEL() {
		return IDPERSONNEL;
    }

    public void setIDPERSONNEL(int idPersonne) {
        this.IDPERSONNEL = idPersonne;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String nom) {
        this.NOM = nom;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String prenom) {
        this.PRENOM = prenom;
    }

    public Date getDATENAISSANCE() {
        return DATENAISSANCE;
    }

    public void setDATENAISSANCE(Date dateNaissance) {
        this.DATENAISSANCE = dateNaissance;
    }

    public String getSEXE() {
        return SEXE;
    }

    public void setSEXE(String sexe) {
        this.SEXE = sexe;
    }
    public Attribut getIDATTRIBUT() {
        return IDATTRIBUT;
    }

    public void setIDATTRIBUT(Attribut IDATTRIBUT) {
        this.IDATTRIBUT = IDATTRIBUT;
    }
	
}

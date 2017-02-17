/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author itu
 */
public class Ecolage {
       private int IDECOLAGE;
       private double MONTANT;
       private String ANNEE;
       private int IDBRANCHE;
       private String BRANCHE;
       private int AGE_DEBUT;
       private int AGE_FIN;
       private double ECOLAGE;

        public Ecolage() {
        }

    public double getECOLAGE() {
        return ECOLAGE;
    }

    public void setECOLAGE(double ECOLAGE) {
        this.ECOLAGE = ECOLAGE;
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
            
            public int getIDECOLAGE() {
                return IDECOLAGE;
            }

            public void setIDECOLAGE(int IDECOLAGE) {
                this.IDECOLAGE = IDECOLAGE;
            }

            public double getMONTANT() {
                return MONTANT;
            }

            public void setMONTANT(double MONTANT) {
                this.MONTANT = MONTANT;
            }
            public void setMONTANTS(String MONTANT) {
                double val = Double.parseDouble(MONTANT);
                this.MONTANT = val;
            }

            public String getANNEE() {
                return ANNEE;
            }

            public void setANNEE(String ANNEE) {
                this.ANNEE = ANNEE;
            }

            public int getIDBRANCHE() {
                return IDBRANCHE;
            }

            public void setIDBRANCHE(int IDBRANCHE) {
                this.IDBRANCHE = IDBRANCHE;
            }
            public void setIDBRANCHES(String IDBRANCHE) {
                int vall = Integer.parseInt(IDBRANCHE);
                this.IDBRANCHE = vall;
            }
              public String getValue()
	{
               
		String valC= "MONTANT,ANNEE,IDBRANCHE";
		return valC;
	}
	public String getCol()
	{
               
		String args= "'" + MONTANT + "','" + ANNEE + "','" + IDBRANCHE + "'"  ;
		return args;
	}
	public String Update()
	{
		return "ECOLAGE='"+MONTANT+"'";
	}
        
}

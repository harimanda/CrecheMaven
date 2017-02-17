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
public class Attribut {
       private int IDATTRIBUT;
       private String ATTRIBUT;

    public Attribut(int IDATTRIBUT, String ATTRIBUT) {
        this.IDATTRIBUT = IDATTRIBUT;
        this.ATTRIBUT = ATTRIBUT;
    }

    public int getIDATTRIBUT() {
        return IDATTRIBUT;
    }

    public void setIDATTRIBUT(int IDATTRIBUT) {
        this.IDATTRIBUT = IDATTRIBUT;
    }

    public String getATTRIBUT() {
        return ATTRIBUT;
    }

    public void setATTRIBUT(String ATTRIBUT) {
        this.ATTRIBUT = ATTRIBUT;
    }
       
}

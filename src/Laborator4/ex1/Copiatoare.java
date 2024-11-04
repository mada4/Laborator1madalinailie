package Laborator4.ex1;

import java.io.Serializable;

enum FormatCopiere {
    A3,
    A4
}

/**
 * Clasa derivata din clasa de baza EchipamenteElectronice
 * @author Ilie Maria-Madalina
 */
public class Copiatoare extends EchipamenteElectronice implements Serializable {
    private int p_ton;
    private FormatCopiere formatCopiere;

    /**
     * Constructor ce il extinde pe cel din clasa de baza
     * @param denumire
     * @param nr_inv
     * @param pret
     * @param zona_mag
     * @param situatie
     * @param tip
     * @param p_ton - numarul de pagini/toner
     * @param formatCopiere - formatul de copiere
     */
    public Copiatoare(String denumire, int nr_inv, double pret, String zona_mag, Situatie situatie, String tip, int p_ton, FormatCopiere formatCopiere) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.p_ton = p_ton;
        this.formatCopiere = formatCopiere;
    }

    /**
     * Getter care da acces de citire al variabilei membre ce contine numarul de pagini
     * @return numarul de pagini/toner
     */
    public int getP_ton() {
        return p_ton;
    }

    /**
     * Getter care da acces de citire al variabilei membre care contine tipul de format al copiatoarelor
     * @return formatul copiatoarelor, care poate fi A3 sau A4
     */
    public FormatCopiere getFormatCopiere() {
        return formatCopiere;
    }

    /**
     * Setter care seteaza formatul de copiere
     * @param formatCopiere
     */
    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    /**
     * Redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișare
     * @return caracteristicile copiatoarelor
     */
    public String toString() {
        return super.toString() + p_ton + ";" + formatCopiere;
    }
}

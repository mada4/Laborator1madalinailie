package Laborator4.ex1;

import java.io.Serializable;

enum SistemOperare {
    windows,
    linux
}

/**
 * Clasa derivata din clasa de baza EchipamenteElectronice
 * @author Ilie Maria-Madalina
 */
public class SistemeCalcul extends EchipamenteElectronice implements Serializable {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare sistemOperare;

    /**
     * Constructor ce il extinde pe cel din clasa de baza
     * @param denumire
     * @param nr_inv
     * @param pret
     * @param zona_mag
     * @param situatie
     * @param tip
     * @param tip_mon - tipul de monitor al sistemelor de calcul
     * @param vit_proc - viteza unui procesor
     * @param c_hdd - capacitate a HDD
     * @param sistemOperare - sistemul de operare al sistemelor de calcul
     */
    public SistemeCalcul(String denumire, int nr_inv, double pret, String zona_mag, Situatie situatie, String tip, String tip_mon, double vit_proc, int c_hdd, SistemOperare sistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemOperare = sistemOperare;
    }

    /**
     * Getter care da acces de citire al variabilei membre care contine tipul monitorului
     * @return tipul
     */
    public String getTip_mon() {
        return tip_mon;
    }

    /**
     * Getter care da acces de citire al variabilei membre care contine viteza unui procesor
     * @return viteza
     */
    public double getVit_proc() {
        return vit_proc;
    }

    /**
     * Getter care da acces de citire al variabilei membre care contine o capacitate a HDD
     * @return capacitate HDD
     */
    public int getC_hdd() {
        return c_hdd;
    }

    /**
     * Getter care da acces de citire al variabilei membre care contine sistemul de operare al sistemelor de calcul
     * @return sistem de operare
     */
    public SistemOperare getSistemOperare() {
        return sistemOperare;
    }

    /**
     * Seteaza sistemul de operare al sistemelor de calcul, care poate fi Windows sau Linux
     * @param sistemOperare
     */
    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    /**
     * Redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișare
     * @return caracteristicile sistemelor de calcul
     */
    @Override
    public String toString() {
        return super.toString() + tip_mon + ";" + vit_proc + ";" + c_hdd + ";" + sistemOperare;
    }
}

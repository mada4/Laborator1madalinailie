package Laborator4.ex1;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum Situatie {
    achizitionat,
    expus,
    vandut
}

/**
 * @author Ilie Maria-Madalina
 * @version 1
 * @since 2024
 */
public class EchipamenteElectronice implements Serializable {
    public String tip;
    protected String denumire;
    protected int nr_inv;
    protected double pret;
    protected String zona_mag;
    protected Situatie sit;

    /**
     * Constructor clasa echipamente
     * @param denumire - numele echipamentului
     * @param nr_inv - numarul de inventar al echipamentului
     * @param pret - pretul echipamentului
     * @param zona_mag - zona din magazie in care este plasat echipamentul
     * @param sit - situatia in care este echipamentul
     */
    public EchipamenteElectronice(String denumire, int nr_inv, double pret, String zona_mag, Situatie sit) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.sit = sit;
    }

    /**
     * Getter care da acces de citire a variabilei membre care contine denumirea echipamentului electronic din firma
     * @return denumirea echipamentului
     */
    public String getDenumire() {
        return denumire;
    }

    /**
     * Getter care da acces de citire a variabilei membre care contine numar de inventar al echipamentului
     * @return numar de inventar
     */
    public int getNr_inv() {
        return nr_inv;
    }

    /**
     * Getter care da acces de citire a variabilei membre care contine pretul echipamentului
     * @return pretul
     */
    public double getPret() {
        return pret;
    }

    /**
     * Getter care da acces de citire a variabilei membre care contine zona din magazie in care este plasat echipamentul
     * @return zona din magazie
     */
    public String getZona_mag() {
        return zona_mag;
    }

    /**
     * Getter care da acces de citire a variabilei membre care contine situatia in case afla un echipament
     * @return situatia echipamentului
     */
    public Situatie getSit() {
        return sit;
    }

    /**
     * Seteaza situatia in care se poate afla un echipament: achizitionat, expus sau vandut
     * @param sit
     */
    public void setSit(Situatie sit) {
        this.sit = sit;
    }

    /**
     * Redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișare
     * @return caracteristicile echipamentelor electronice
     */
    @Override
    public String toString() {
        return denumire + ';' + nr_inv + ';' + pret + ';' + zona_mag + ';' + sit.toString() + ';';
    }
}

package Laborator4.ex1;

import java.io.Serializable;

enum ModTiparire {
    color,
    alb_negru
}

/**
 * Clasa derivata din clasa de baza EchipamenteElectronice
 * @author Ilie Maria-Madalina
 */
public class Imprimanta extends EchipamenteElectronice implements Serializable {
    private int ppm;
    private String dpi;
    private int p_car;
    private ModTiparire mod;

    /**
     * Constructor ce il extinde pe cel din clasa de baza
     * @param denumire
     * @param nr_inv
     * @param pret
     * @param zona_mag
     * @param sit
     * @param tip
     * @param ppm - pagini scrise pe minut
     * @param dpi - rezolutie(numar de puncte per inch)
     * @param p_car - numarul de pagini/cartus
     * @param mod - modul de tiparire
     */
    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Situatie sit, String tip, int ppm, String dpi, int p_car, ModTiparire mod) {
        super(denumire, nr_inv, pret, zona_mag, sit);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.mod = mod;
    }

    /**
     * Getter care da acces de citire al variabilei membre ce contine numar de pagini scrise pe minut
     * @return numar de pag
     */
    public int getPpm() {
        return ppm;
    }

    /**
     * Getter care da acces de citire al variabilei membre care contine rezolutia imprimantelor
     * @return rezolutia(numarul de puncte per inch)
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * Getter care da acces de citire al variabilei membre care contine numarul de pagini/cartus
     * @return numarul de pag
     */
    public int getP_car() {
        return p_car;
    }

    /**
     * Getter care da acces de citire al variabilei membre ce contine modul de tiparire al imprimantelor
     * @return modul de tiparire
     */
    public ModTiparire getMod() {
        return mod;
    }

    /**
     * Setter care seteaza modul de tiparire al imprimantelor, acesta poate fi color sau alb negru
     * @param mod
     */
    public void setModTiparire(ModTiparire mod) {
        this.mod = mod;
    }

    /**
     * Redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișare
     * @return caracteristicile imprimantelor
     */
    @Override
    public String toString() {
        return super.toString() + ppm + ';' + dpi + ';' + p_car + ';' + mod;
    }
}

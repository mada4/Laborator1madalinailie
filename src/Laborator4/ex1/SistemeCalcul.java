package Laborator4.ex1;

enum SistemOperare {
    Windows,
    Linux
}

public class SistemeCalcul extends EchipamenteElectronice {
    private String tip_mon;
    private int vit_proc;
    private int c_hdd;
    private SistemOperare sistemOperare;

    public SistemeCalcul(String denumire, int nr_inv, double pret, String zona_mag, Situatie situatie, String tip_mon, int vit_proc, int c_hdd, SistemOperare sistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemOperare = sistemOperare;
    }

    public SistemeCalcul(String denumire, int nrInv, double pret, String zonaMag, Situatie situatie, String tip, String tipMon, double vitProc, int cHdd, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, situatie);
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public int getVit_proc() {
        return vit_proc;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public SistemOperare getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    public void afisareDate() {
        System.out.print("Imprimanta: " + denumire + " Numar inventar: " + nr_inv + "Pret: " + pret + "Zona: " + zona_mag + "Situatie: " + sit + "Tip: " + tip_mon + "Viteza procesor: " + vit_proc + "Capacitate a HDD: " + c_hdd + "Sistem de operare: " + sistemOperare);
    }
}

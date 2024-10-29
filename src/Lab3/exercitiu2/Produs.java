package Lab3.exercitiu2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate data_expirarii;
    private static double incasari=0;

    Produs(String denumire, double pret, int cantitate, LocalDate data_expirarii)
    {
        this.denumire=denumire;
        this.pret=pret;
        this.cantitate=cantitate;
        this.data_expirarii=data_expirarii;
    }

    public String getDenumire()
    {
        return denumire;
    }

    public double getPret()
    {
        return pret;
    }

    public int getCantitate()
    {
        return cantitate;
    }

    public LocalDate getData_expirarii()
    {
        return data_expirarii;
    }

    public void vanzare(int cant) {
        if (cant > cantitate) {
            System.out.println("Cantitate depasita!");
            return;
        }

        cantitate -= cant;
        incasari += cant * pret;
    }

    @Override
    public String toString() {
        return "denumire: " + denumire + ", " +
                "pret: " + pret + ", " +
                "cantitate: " + cantitate + ", " +
                "data_expirarii: " + data_expirarii;
    }
}

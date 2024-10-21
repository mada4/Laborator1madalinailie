package Lab2.exercitiu4;

import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Persoana{
    private String nume;
    private String cnp;
    private long varsta;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume=nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public boolean validareCNP(String cnp){
        if(cnp.length()!=13)
        {
            return false;
        }
        for(int i=0;i<cnp.length();i++)
            if(cnp.charAt(i)<'0'||cnp.charAt(i)>'9')
                return false;
        if(cnp.charAt(0)=='0'||cnp.charAt(0)=='3'||cnp.charAt(0)=='4'||cnp.charAt(0)=='7'||cnp.charAt(0)=='8'||cnp.charAt(0)=='9')
            return false;
        int suma=0;
        String nr="279146358279";
        for(int i=0;i<12;i++)
        {
            int a=Integer.parseInt(cnp.charAt(i)+"");
            int b=Integer.parseInt(nr.charAt(i)+"");
            suma+=a*b;
        }
        int ultima_cifra=Integer.parseInt(cnp.charAt(12)+"");
        if(ultima_cifra!=suma%11)
            return false;
        return true;
    }

    public void setVarsta(){
        String an_aux = cnp.substring(1, 3);
        if(an_aux.charAt(0) > '2'){
            an_aux = "19" + an_aux;
        }
        else an_aux = "20" + an_aux;

        int an = Integer.parseInt(an_aux);
        int luna = Integer.parseInt(cnp.substring(3,5));
        int zi = Integer.parseInt(cnp.substring(5,7));

        LocalDate data_nasterii = LocalDate.of(an, luna, zi);
        LocalDate data_curenta = LocalDate.now();
        varsta = ChronoUnit.YEARS.between(data_nasterii, data_curenta);
    }

    public void AfisarePersoana(){
        System.out.println("Nume: " + nume);
        System.out.println("CNP: " + cnp);
        System.out.println("Varsta: " + varsta);
        System.out.println("_____________");
    }
}

public class ex4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numarul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Persoana[] lista_persoane = new Persoana[n];

        String nume, cnp;

        for(int i = 0; i < lista_persoane.length; i++) {
            System.out.print("Numele: ");
            nume = scanner.nextLine();
            System.out.print("CNP: ");
            cnp = scanner.nextLine();

            lista_persoane[i] = new Persoana(nume, cnp);

            while(!lista_persoane[i].validareCNP(cnp)){
                System.out.print("Reintroduceti un CNP valid: ");
                cnp = scanner.nextLine();
                lista_persoane[i].setCnp(cnp);
            }
            lista_persoane[i].setVarsta();

        }
        for (Persoana persoana : lista_persoane) {
            persoana.AfisarePersoana();
        }
        scanner.close();
    }
}

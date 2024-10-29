package Lab3.exercitiu2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class ex2 {
    public static void main(String[] args) throws FileNotFoundException
    {
        List<Produs>listaproduse=new ArrayList<Produs>();
        LocalDate today=LocalDate.now();
        Scanner scanner=new Scanner(new File("src/Lab3/exercitiu2/produse.csv"));
        String denumire;
        int cantitate;
        double pret;
        LocalDate data_expirarii;
        double pret_min;
        String[] data;
        while(scanner.hasNextLine())
        {
            data=scanner.nextLine().split(",");
            denumire=data[0];
            pret=Double.parseDouble(data[1]);
            cantitate=Integer.parseInt(data[2]);
            data_expirarii=LocalDate.parse(data[3]);
            listaproduse.add(new Produs(denumire,pret,cantitate,data_expirarii));
        }
        scanner.close();

        int opt;
        Produs deSters = null;
        Scanner scanner1=new Scanner(System.in);
        PrintStream out = new PrintStream(new File("src/Lab3/exercitiu2/out"));
        do{
            System.out.println("0.Exit");
            System.out.println("1.Afisarea tuturor produselor ");
            System.out.println("2.Afisarea produselor expirate ");
            System.out.println("3.Vanzarea unui produs ");
            System.out.println("4.Afisarea produselor cu pret minim ");
            System.out.println("5.Salvarea produselor cu o cantitate mai mica decat una introdusa, in fisier");
            System.out.print("Introduceti optiunea dorita: ");
            opt=scanner1.nextInt();
            switch (opt)
            {
                case 0:
                    exit(0);
                    break;
                case 1:
                    for(Produs prod: listaproduse)
                        System.out.println(prod.toString());
                       break;
                case 2:
                    System.out.println("Produse expirate: ");
                    for(Produs prod : listaproduse){
                        if(prod.getData_expirarii().isBefore(today)){
                            System.out.println(prod.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Denumire produs: ");
                    denumire = scanner1.next();
                    System.out.print("Cantitate: ");
                    cantitate = scanner1.nextInt();
                    for (Produs produs: listaproduse)
                        if (produs.getDenumire().equals(denumire)) {
                            produs.vanzare(cantitate);
                            if (produs.getCantitate() == 0)
                                deSters = produs;
                        }
                    if (deSters != null)
                        listaproduse.remove(deSters);
                    break;
                case 4:
                    pret_min = Double.MAX_VALUE;
                    System.out.println("Produse cu pret minim: ");
                    for(Produs prod : listaproduse){
                        if(prod.getPret()< pret_min)
                            pret_min = prod.getPret();
                    }
                    for(Produs prod : listaproduse){
                        if(prod.getPret()==pret_min)
                            System.out.println(prod.toString());
                    }
                    break;
                case 5:
                    System.out.print("Introduceti cantitatea: ");
                    cantitate = scanner1.nextInt();
                    for (Produs prod: listaproduse)
                        if (prod.getCantitate() < cantitate)
                            out.println(prod);
                    break;
                default:
                    System.out.println("Optiunea invalida!");
                    break;
            }
        }while(opt!=0);
    }

}

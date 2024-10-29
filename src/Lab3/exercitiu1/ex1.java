package Lab3.exercitiu1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> lista=new ArrayList<Parabola>();
        Scanner scanner=new Scanner(new File("src/Lab3/exercitiu1/parabola_in"));

        while(scanner.hasNextLine())
        {
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            lista.add(new Parabola(a,b,c));
        }

        for(Parabola p:lista)
        {
            System.out.println(p.toString());
            Punct varf=p.varfParabola();
            System.out.println("Varful parabolei: " + varf);
        }

        if(lista.size()>=2)
        {
            Parabola p1=lista.get(0);
            Parabola p2=lista.get(1);
            Punct mijl=p1.Mijloc(p2);
            System.out.println("Mijlocul segment care uneste vf parabolei curente cu o parabola: " + mijl);
            Punct mijloc=Parabola.Mijloc1(p1,p2);
            System.out.println("Mijlocul segmentului care uneste varfurile celor doua parabole: " + mijloc);
            double  lung=p1.Lungime(p2);
            System.out.println("Lungimea segmentului care uneste vf parabolei curente cu o parabola: " + lung);
            double lungime=Parabola.Lungime1(p1,p2);
            System.out.println("Lungimea segmentului care uneste varfurile celor doua parabole: "+lungime);
        }
    }
}

package execitiu2;

import java.io.*;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("src/execitiu2/in.txt"));
        int suma=0;
        int n;
        float medie_aritmetica=0;
        int valoare_maxima=Integer.MIN_VALUE;
        int valoare_minima=Integer.MAX_VALUE;
        int k=0;

        PrintStream out=new PrintStream("src/execitiu2/out.txt");
        while(scanner.hasNext()==true)
        {
            k++;
            n=scanner.nextInt();
            suma=suma+n;
            if(valoare_minima>n)
                valoare_minima=n;
            if(valoare_maxima<n)
                valoare_maxima=n;
        }
        medie_aritmetica=(float)suma/k;
        out.println("Suma: "+suma);
        out.println("Medie: "+medie_aritmetica);
        out.println("Valoare minima: "+valoare_minima);
        out.println("Valoare maxima: "+valoare_maxima);

        System.out.println("Suma: "+suma);
        System.out.println("Medie: "+medie_aritmetica);
        System.out.println("Valoare minima: "+valoare_minima);
        System.out.println("Valoare maxima: "+valoare_maxima);
        scanner.close();
    }
}

package Lab2.exercitiu1;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] main) throws FileNotFoundException
    {
        String[] judete=new String[41];
        Scanner scanner=new Scanner(new File("src/exercitiu1/judete_in.txt"));
        int k=0;
        while(scanner.hasNext()==true)
        {
            judete[k++]=scanner.next();
        }
        scanner.close();

        Arrays.sort(judete,0,k);

        for(int i=0;i<k;i++)
            System.out.println(i + "." + judete[i]);
        Scanner scanner_citire=new Scanner(System.in);
        System.out.print("Introduceti judetul cautat: ");
        String judet_cautat=scanner_citire.next();
        scanner_citire.close();
        int pozitie=Arrays.binarySearch(judete,0, k, judet_cautat);
        if(pozitie>=0)
        {
            System.out.println("Judetul se afla la pozitia: "+pozitie);
        }
        else System.out.println("Judetul nu a fost gasit!");
    }
}

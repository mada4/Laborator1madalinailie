package Lab2.exercitiu2;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.PrintStream;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] main) throws FileNotFoundException {
        Vers[] vers = new Vers[10];
        int nr=0;
        Scanner scanner=new Scanner(new File("src/Lab2/exercitiu2/cantec_in.txt"));
        PrintStream out=new PrintStream(new File("src/Lab2/exercitiu2/cantec_out.txt"));
        String gruparealeasa="da";
        while(scanner.hasNextLine())
        {
            vers[nr]=new Vers();
            vers[nr].setVers(scanner.nextLine());
            double randomVal=vers[nr].randomval();
            String versFormatat=vers[nr].randomUpperCase(randomVal);
            if(vers[nr].grupare(gruparealeasa))
            {
                versFormatat+=" *";
            }
            out.println(versFormatat + " " + vers[nr].nrCuv() + " " + vers[nr].nrVoc() + " " + String.format("%2f", randomVal));
            nr++;
        }
        out.close();
        scanner.close();
    }
}

package execitiu1;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Lungime= ");
        int L=scanner.nextInt();
        System.out.print("latime= ");
        int l=scanner.nextInt();
        int perimetru=2*(L+l);
        int arie=L*l;
        System.out.println("Perimetru: "+perimetru);
        System.out.println("Aria: "+arie);
        scanner.close();
    }
}

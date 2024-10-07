package exercitiu3;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Numar: ");
        int nr=scanner.nextInt();
        int k=0;
        System.out.print("Divizorii numarului sunt: ");
        System.out.print("1 ");
        for(int i=2;i<nr;i++)
        {
            if(nr%i==0)
            {
                k++;
                System.out.print(i+" ");
            }
        }
        System.out.print(nr+"\n");
        if(k==0) {
            System.out.print("Numarul este prim!");
        }
        scanner.close();
    }
}

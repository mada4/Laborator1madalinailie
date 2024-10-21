package Lab1.exercitiu5;

import java.util.Random;

public class ex5 {
    public static void main(String[] args)
    {
        Random random=new Random();
        int n=random.nextInt(20);
        System.out.println("n="+n);
        if(n==1)
        {
            System.out.println("Apartine sirului!");
            return;
        }
        int i;
        int a=1,b=1;
        int c;
        boolean apartine=false;

        for(i=1;i<=n;i++)
        {
            c=a+b;
            a=b;
            b=c;
            if(a==n)
                apartine=true;
        }
        if(apartine)
            System.out.println("Apartine sirului!");
        else System.out.println("Nu apartine sirului!");
    }
}

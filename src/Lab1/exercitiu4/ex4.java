package Lab1.exercitiu4;

import java.util.Random;

public class ex4 {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(31);
        System.out.println("a=" + a);
        int b = random.nextInt(31);
        System.out.println("b=" + b);
        while(a!=b)
            if(a>b)
                a=a-b;
            else
                b=b-a;
        System.out.println("cmmdc="+a);
    }
}

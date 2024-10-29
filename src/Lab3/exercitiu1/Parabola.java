package Lab3.exercitiu1;

import java.util.Arrays;
import static java.lang.Math.hypot;

public class Parabola {
    public int a;
    public int b;
    public int c;

    public Parabola(int a, int b, int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public int getC()
    {
        return c;
    }

    public Punct varfParabola() {
        double x= (double) -b/(2.0*a);
        //double y=(a*x*x)+(b*x)+c;
        double y= (double) (-b*b+4*a*c)/(4*a);
        return new Punct(x,y);
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    public Punct Mijloc(Parabola p)
    {
        Punct v1=this.varfParabola();
        Punct v2=p.varfParabola();
        double mijlocX = (v1.getX() + v2.getX()) / 2;
        double mijlocY = (v2.getY()+ v2.getY()) / 2;
        return new Punct(mijlocX,mijlocY);
    }

    public static Punct Mijloc1(Parabola p1, Parabola p2)
    {
        Punct v1 = p1.varfParabola();
        Punct v2 = p2.varfParabola();
        double mijlocX = (v1.getX() + v2.getX()) / 2;
        double mijlocY = (v2.getY() + v2.getY()) / 2;
        return new Punct(mijlocX,mijlocY);
    }

    public double Lungime(Parabola p)
    {
        Punct v1 = this.varfParabola();
        Punct v2 = p.varfParabola();
        return hypot(v2.getX() - v1.getX(), v2.getY() - v1.getY());
    }

    public static double Lungime1(Parabola p1, Parabola p2)
    {
        Punct v1 = p1.varfParabola();
        Punct v2 = p2.varfParabola();
        return hypot(v2.getX() - v1.getX(), v2.getY() - v1.getY());
    }
}

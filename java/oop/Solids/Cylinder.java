package oop.Solids;

/**
 * Created on: 27/Feb/2017
 *
 * @author DMarinov
 */

public class Cylinder extends Solid
{
    double height;

    public Cylinder(double height, double radius)
    {
        super(radius);
        this.height = height;
    }

    public String toString()
    {
        return "Cylinder[r=" + radius + ", h=" + height + "]";
    }

    public double volume()
    {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    public double surface()
    {
        return 2 * Math.PI * radius * (radius + height);
    }

}

package oop.Solids;

public class Sphere extends Solid
{

    public Sphere(double radius)
    {
        super(radius);
    }

    public String toString()
    {
        return "Sphere[r=" + radius + "]";
    }

    public double volume()
    {
        return 4.0 / 3.0 * Math.PI * radius * radius * radius;
    }

    public double surface()
    {
        return 4.0 * Math.PI * radius * radius;
    }

}

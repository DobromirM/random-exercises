package oop.Solids;

public abstract class Solid implements Comparable<Solid>
{

    public double radius;

    public Solid(double radius)
    {
        this.radius = radius;
    }

    public abstract double volume();

    public abstract double surface();

    // compare solids by volume
    public int compareTo(Solid other)
    {
        return Double.compare(this.volume(), other.volume());
    }

}

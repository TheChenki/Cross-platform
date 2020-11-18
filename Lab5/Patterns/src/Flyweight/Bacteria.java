package Flyweight;

public abstract class Bacteria
{
    protected String type;
    protected String shape;

    public void display(int x, int y)
    {
        System.out.println("В точке "+x+":"+y+" замечена бактерия "+ type + ", которая имеет форму "+ shape);
    }
}

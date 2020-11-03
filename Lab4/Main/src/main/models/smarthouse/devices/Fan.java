package main.models.smarthouse.devices;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Fan extends TimedDevice
{
    private final IntegerProperty speed = new SimpleIntegerProperty(100);
    private final BooleanProperty rotating = new SimpleBooleanProperty(true);


    public int getSpeed()
    {
        return speed.get();
    }
    public void setSpeed(int speed)
    {
        if(speed > 100)
            speed = 100;

        if(speed < 0)
            speed = 0;

        this.speed.set(speed);
    }
    public boolean isRotating()
    {
        return rotating.get();
    }
    public void setRotating(boolean rotating)
    {
        this.rotating.set(rotating);
    }


    public IntegerProperty speedProperty()
    {
        return speed;
    }
    public BooleanProperty rotatingProperty()
    {
        return rotating;
    }

    public Fan(String name)
    {
        super(name);
    }
}

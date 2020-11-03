package main.models.smarthouse.devices;

import javafx.beans.property.*;

public class Boiler extends TimedDevice
{
    private final IntegerProperty temperature = new SimpleIntegerProperty(90);


    public int getTemperature()
    {
        return temperature.get();
    }
    public void setTemperature(int temperature)
    {
        if(temperature > 90)
            temperature = 90;

        if(temperature < 0)
            temperature = 0;

        this.temperature.set(temperature);
    }


    public IntegerProperty temperatureProperty()
    {
        return temperature;
    }


    public Boiler(String name)
    {
        super(name);
    }
}

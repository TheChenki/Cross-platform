package main.models.smarthouse.devices;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Fridge extends Device
{
    private final IntegerProperty fridgeTemperature = new SimpleIntegerProperty(5);
    private final IntegerProperty freezerTemperature = new SimpleIntegerProperty(-18);


    public int getFridgeTemperature()
    {
        return fridgeTemperature.get();
    }
    public void setFridgeTemperature(int temperature)
    {
        if(temperature > 6)
            temperature = 6;

        if(temperature < 0)
            temperature = 0;

        this.fridgeTemperature.set(temperature);
    }

    public int getFreezerTemperature()
    {
        return freezerTemperature.get();
    }
    public void setFreezerTemperature(int temperature)
    {
        if(temperature > -6)
            temperature = -6;

        if(temperature < -24)
            temperature = -24;

        this.freezerTemperature.set(temperature);
    }


    public IntegerProperty fridgeTemperatureProperty()
    {
        return fridgeTemperature;
    }
    public IntegerProperty freezerTemperatureProperty()
    {
        return freezerTemperature;
    }

    public Fridge(String name)
    {
        super(name);
    }
}

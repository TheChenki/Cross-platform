package main.models.smarthouse.devices;

import javafx.beans.property.*;

import java.time.LocalTime;

public class Hood extends TimedDevice
{
    private final BooleanProperty light = new SimpleBooleanProperty(false);
    private final BooleanProperty airing = new SimpleBooleanProperty(false);
    private final ObjectProperty<LocalTime> airingPeriod = new SimpleObjectProperty<LocalTime>(LocalTime.of(0,30));
    private final IntegerProperty power = new SimpleIntegerProperty(100);
    private final IntegerProperty tilt = new SimpleIntegerProperty(0);


    public int getPower()
    {
        return power.get();
    }
    public void setPower(int power)
    {
        if(power > 100)
            power = 100;

        if(power < 0)
            power = 0;

        this.power.set(power);
    }

    public int getTilt()
    {
        return tilt.get();
    }
    public void setTilt(int tilt)
    {
        if(tilt > 30)
            tilt = 30;

        if(tilt < 0)
            tilt = 0;

        this.tilt.set(tilt);
    }

    public boolean isLight()
    {
        return light.get();
    }
    public void setLight(boolean light)
    {
        this.light.set(light);
    }

    public boolean isAiring()
    {
        return airing.get();
    }
    public void setAiring(boolean airing)
    {
        this.airing.set(airing);
    }

    public LocalTime getAiringPeriod()
    {
        return airingPeriod.get();
    }
    public void setAiringPeriod(LocalTime airingPeriod)
    {
        this.airingPeriod.set(airingPeriod);
    }


    public IntegerProperty powerProperty()
    {
        return power;
    }
    public IntegerProperty tiltProperty()
    {
        return tilt;
    }
    public BooleanProperty lightProperty()
    {
        return light;
    }
    public BooleanProperty airingProperty()
    {
        return airing;
    }
    public ObjectProperty<LocalTime> airingPeriodProperty()
    {
        return airingPeriod;
    }

    public Hood(String name)
    {
        super(name);
    }
}

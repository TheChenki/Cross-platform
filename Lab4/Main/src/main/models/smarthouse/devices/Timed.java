package main.models.smarthouse.devices;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

import java.time.LocalTime;

public interface Timed
{
    LocalTime getStartTime();
    void setStartTime(LocalTime time);

    LocalTime getStopTime();
    void setStopTime(LocalTime time);

    boolean isStartTimerSet();
    void setStartTimer(boolean time);

    boolean isStopTimerSet();
    void setStopTimer(boolean time);

    ObjectProperty<LocalTime> startTimeProperty();
    ObjectProperty<LocalTime> stopTimeProperty();
    BooleanProperty startTimerProperty();
    BooleanProperty stopTimerProperty();

}

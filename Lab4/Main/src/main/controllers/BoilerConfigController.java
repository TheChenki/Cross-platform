package main.controllers;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.smarthouse.devices.Boiler;
import main.models.smarthouse.SmartHouse;

import java.net.URL;
import java.util.ResourceBundle;

public class BoilerConfigController implements Initializable
{
    @FXML JFXSlider temperature;

    SmartHouse house;
    Boiler device;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        house = SmartHouse.getInstance();
        device = (Boiler)house.getSelectedDevice();

        Bindings.bindBidirectional(temperature.valueProperty(), device.temperatureProperty());
    }
}

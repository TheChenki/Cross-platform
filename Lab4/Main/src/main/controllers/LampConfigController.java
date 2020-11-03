package main.controllers;

import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.smarthouse.devices.Lamp;
import main.models.smarthouse.SmartHouse;

import java.net.URL;
import java.util.ResourceBundle;

public class LampConfigController implements Initializable
{
    @FXML private JFXColorPicker lampColor;
    @FXML private JFXSlider brightness;

    private SmartHouse house;
    private Lamp lamp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        house = SmartHouse.getInstance();
        lamp = (Lamp)house.getSelectedDevice();

        Bindings.bindBidirectional(lampColor.valueProperty(), lamp.colorProperty());
        Bindings.bindBidirectional(brightness.valueProperty(), lamp.brightnessProperty());
    }
}

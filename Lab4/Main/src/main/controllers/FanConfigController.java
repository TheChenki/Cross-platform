package main.controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.smarthouse.devices.Fan;
import main.models.smarthouse.SmartHouse;

import java.net.URL;
import java.util.ResourceBundle;

public class FanConfigController implements Initializable
{
    @FXML JFXSlider speed;
    @FXML JFXCheckBox rotating;

    SmartHouse house;
    Fan device;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        house = SmartHouse.getInstance();
        device = (Fan)house.getSelectedDevice();

        Bindings.bindBidirectional(speed.valueProperty(), device.speedProperty());
        Bindings.bindBidirectional(rotating.selectedProperty(), device.rotatingProperty());
    }
}

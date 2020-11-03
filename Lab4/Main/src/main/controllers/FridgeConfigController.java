package main.controllers;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.smarthouse.devices.Fridge;
import main.models.smarthouse.SmartHouse;

import java.net.URL;
import java.util.ResourceBundle;

public class FridgeConfigController implements Initializable
{
    @FXML JFXSlider freezerTemperature;
    @FXML JFXSlider fridgeTemperature;

    SmartHouse house;
    Fridge device;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        house = SmartHouse.getInstance();
        device = (Fridge) house.getSelectedDevice();

        Bindings.bindBidirectional(freezerTemperature.valueProperty(), device.freezerTemperatureProperty());
        Bindings.bindBidirectional(fridgeTemperature.valueProperty(), device.fridgeTemperatureProperty());
    }
}

package main.controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTimePicker;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.smarthouse.devices.Hood;
import main.models.smarthouse.SmartHouse;

import java.net.URL;
import java.util.ResourceBundle;

public class HoodConfigController implements Initializable
{
    @FXML private JFXSlider tilt;
    @FXML private JFXSlider power;
    @FXML private JFXCheckBox airing;
    @FXML private JFXCheckBox light;
    @FXML private JFXTimePicker airingPeriod;

    private SmartHouse house;
    private Hood hood;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        house = SmartHouse.getInstance();
        hood = (Hood)house.getSelectedDevice();

        Bindings.bindBidirectional(tilt.valueProperty(), hood.tiltProperty());
        Bindings.bindBidirectional(power.valueProperty(), hood.powerProperty());
        Bindings.bindBidirectional(airing.selectedProperty(), hood.airingProperty());
        Bindings.bindBidirectional(light.selectedProperty(), hood.lightProperty());
        Bindings.bindBidirectional(airingPeriod.valueProperty(), hood.airingPeriodProperty());
    }
}

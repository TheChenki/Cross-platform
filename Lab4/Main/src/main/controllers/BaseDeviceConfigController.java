package main.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import main.models.smarthouse.devices.Device;
import main.models.smarthouse.SmartHouse;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseDeviceConfigController implements Initializable
{
    @FXML private JFXTextField deviceName;
    @FXML private CheckBox deviceSwitchedOn;

    private SmartHouse house;
    private Device device;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        house = SmartHouse.getInstance();
        device = house.getSelectedDevice();

        Bindings.bindBidirectional(deviceSwitchedOn.selectedProperty(), device.enabledProperty());
        Bindings.bindBidirectional(deviceName.textProperty(), device.nameProperty());
    }
}

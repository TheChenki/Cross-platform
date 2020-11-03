package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.models.smarthouse.SmartHouse;
import main.models.smarthouse.devices.*;

public class AddDeviceController
{
    @FXML private TextField deviceName;
    @FXML private ComboBox<String> deviceType;

    public void addDevice(ActionEvent actionEvent)
    {
        String value = deviceType.getValue();
        String name = deviceName.getText();
        Device device = null;

        switch (value)
        {
            case "Lamp": device = new Lamp(name); break;
            case "Hood": device = new Hood(name); break;
            case "Boiler": device = new Boiler(name); break;
            case "Fridge": device = new Fridge(name); break;
            case "Fan": device = new Fan(name); break;
        }

        if(device != null)
            SmartHouse.getInstance().getItems().add(device);
    }
}

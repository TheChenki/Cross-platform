package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import main.models.smarthouse.devices.Device;
import main.models.smarthouse.SmartHouse;
import main.models.smarthouse.devices.Timed;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ConfigDeviceController implements Initializable
{
    @FXML private VBox vbox;

    private SmartHouse house;
    private Device device;

    public void switchDevice(ActionEvent actionEvent)
    {
        device.setEnabled(!device.isEnabled());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        FXMLLoader loader = new FXMLLoader();
        List<String> views = new ArrayList<String>();

        house  = SmartHouse.getInstance();
        device = house.getSelectedDevice();

        vbox.getChildren().clear();
        views.add("/main/views/baseDeviceConfigView.fxml");

        if(device instanceof Timed)
        {
            views.add("/main/views/timedDeviceConfigView.fxml");
        }

        switch (device.getClass().getSimpleName())
        {
            case "Lamp":
                views.add("/main/views/lampConfigView.fxml"); break;
            case "Boiler":
                views.add("/main/views/boilerConfigView.fxml"); break;
            case "Hood":
                views.add("/main/views/hoodConfigView.fxml"); break;
            case "Fridge":
                views.add("/main/views/fridgeConfigView.fxml"); break;
            case "Fan":
                views.add("/main/views/fanConfigView.fxml"); break;
        }

        try
        {
            for (String view : views)
            {
                vbox.getChildren().add(loader.load(getClass().getResource(view)));
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}

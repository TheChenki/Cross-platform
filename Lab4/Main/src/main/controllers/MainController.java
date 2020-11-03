package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import main.models.smarthouse.devices.Device;
import main.models.smarthouse.SmartHouse;
import main.views.templates.DeviceListViewCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML private Pane pane;
    @FXML private ListView<Device> deviceList;

    private SmartHouse house;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        house = SmartHouse.getInstance();

        deviceList.itemsProperty().bind(house.itemsProperty());
        deviceList.setCellFactory(deviceListView -> new DeviceListViewCell());
    }

    public void addDevice(ActionEvent actionEvent) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();

        pane.getChildren().clear();
        pane.getChildren().add(fxmlLoader.load(getClass().getResource("/main/views/addDeviceView.fxml")));
    }

    public void deleteDevice(ActionEvent actionEvent)
    {
        if(deviceList.getSelectionModel().getSelectedItem() == null)
            return;

        house.getItems().remove(deviceList.getSelectionModel().getSelectedItem());
    }

    public void configDevice(ActionEvent actionEvent) throws IOException
    {
        if(deviceList.getSelectionModel().getSelectedItem() == null)
            return;

        house.setSelectedDevice(deviceList.getSelectionModel().getSelectedItem());

        FXMLLoader fxmlLoader = new FXMLLoader();

        pane.getChildren().clear();
        pane.getChildren().add(fxmlLoader.load(getClass().getResource("/main/views/configDeviceView.fxml")));
    }

}

package main.models.smarthouse;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.models.smarthouse.devices.Device;

public class SmartHouse
{
    private static SmartHouse instance;

    private final ListProperty<Device> items = new SimpleListProperty<Device>(FXCollections.observableArrayList(Device.extractor()));
    private final ObjectProperty<Device> selectedDevice = new SimpleObjectProperty<Device>();

    public ObservableList<Device> getItems()
    {
        return items.get();
    }
    public Device getSelectedDevice()
    {
        return selectedDevice.get();
    }
    public void setSelectedDevice(Device selectedDevice)
    {
        this.selectedDevice.set(selectedDevice);
    }

    public ListProperty<Device> itemsProperty()
    {
        return items;
    }
    public ObjectProperty<Device> selectedDeviceProperty()
    {
        return selectedDevice;
    }

    private SmartHouse()
    {

    }

    public static SmartHouse getInstance()
    {
        if (instance == null)
        {
            instance = new SmartHouse();
        }
        return instance;
    }
}

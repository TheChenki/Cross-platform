package models;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Car
{
    private ObjectId id;
    private ObjectId driverId;
    private String model;
    private String color;
    private String driver;


    public ObjectId getId()
    {
        return id;
    }
    private void setId(ObjectId id)
    {
        this.id = id;
    }

    public ObjectId getDriverId()
    {
        return driverId;
    }
    public void setDriverId(ObjectId driverId)
    {
        this.driverId = driverId;
    }

    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model = model;
    }

    public String getColor()
    {
        return color;
    }
    public void setColor(String color)
    {
        this.color = color;
    }

    public String getDriver()
    {
        return driver;
    }
    public void setDriver(String driver)
    {
        this.driver = driver;
    }

    public Car(Document doc)
    {
        this.setId((ObjectId)doc.get("_id"));
        this.setModel((String)doc.get("model"));
        this.setColor((String)doc.get("color"));

        try
        {
            this.setDriver(((ArrayList<Document>)doc.get("driver")).get(0).getString("name"));
        }
        catch (Exception ex){}

    }
}

import com.mongodb.client.MongoDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Car;
import models.MyDB;
import models.Person;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class CarController implements Initializable
{
    @FXML private TableView<Car> table;
    @FXML private TableColumn<Car, String> columnModel;
    @FXML private TableColumn<Car, String> columnColor;
    @FXML private TableColumn<Car, String> columnDriver;

    @FXML private TextField model;
    @FXML private TextField color;

    private MainController parentController;

    private MongoDatabase db;

    private ObservableList<Car> cars = FXCollections.observableArrayList();

    public void setParentController(MainController parentController)
    {
        this.parentController = parentController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        db = MyDB.getDB();

        columnModel.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        columnColor.setCellValueFactory(new PropertyValueFactory<Car, String>("color"));
        columnDriver.setCellValueFactory(new PropertyValueFactory<Car, String>("driver"));

        table.setItems(cars);

        getCars();
    }

    public void addCar(ActionEvent actionEvent)
    {
        var collection = db.getCollection("Cars");

        Document document = new Document();
        document.put("model", model.getText());
        document.put("color", color.getText());
        document.put("driverId", null);

        collection.insertOne(document);

        getCars();
    }

    public void refresh(ActionEvent actionEvent)
    {
        getCars();
    }

    public void deleteCar(ActionEvent actionEvent)
    {
        if(table.getSelectionModel().selectedItemProperty().getValue() == null)
            return;

        var collection = db.getCollection("Cars");
        collection.deleteOne(eq("_id", table.getSelectionModel().selectedItemProperty().getValue().getId()));

        getCars();
    }

    public void getCars()
    {
        cars.clear();

        Bson lookup = new Document("$lookup",
                new Document("from", "Users")
                        .append("localField", "driverId")
                        .append("foreignField", "_id")
                        .append("as", "driver"));

        List<Bson> filters = new ArrayList<Bson>();
        filters.add(lookup);

        var collection = db.getCollection("Cars").aggregate(filters);
        for (Document doc : collection)
        {
            cars.add(new Car(doc));
        }
    }

    public void setDriver(ActionEvent actionEvent)
    {
        Person person = parentController.getPerson();
        Car car = table.getSelectionModel().selectedItemProperty().getValue();

        if(person == null || car == null)
            return;

        var collection = db.getCollection("Cars");
        collection.updateOne(eq("_id", car.getId()), new Document("$set", new Document("driverId", person.getId())));

        getCars();
    }
}

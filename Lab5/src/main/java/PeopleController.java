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
import models.MyDB;
import models.Person;
import org.bson.Document;

import java.net.URL;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class PeopleController implements Initializable
{
    @FXML private TableView<Person> table;
    @FXML private TableColumn<Person, String> columnName;
    @FXML private TableColumn<Person, String> columnPhone;

    @FXML private TextField name;
    @FXML private TextField phone;

    private MainController parentController;

    private MongoDatabase db;

    private ObservableList<Person> people = FXCollections.observableArrayList();

    public void setParentController(MainController parentController)
    {
        this.parentController = parentController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        db = MyDB.getDB();

        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        table.setItems(people);

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> parentController.setPerson(newValue));

        getPeople();
    }

    public void addPerson(ActionEvent actionEvent)
    {
        var collection = db.getCollection("Users");

        Document document = new Document();
        document.put("name", name.getText());
        document.put("phone", phone.getText());

        collection.insertOne(document);

        getPeople();
    }

    public void refresh(ActionEvent actionEvent)
    {
        getPeople();
    }

    public void deletePerson(ActionEvent actionEvent)
    {
        if(table.getSelectionModel().selectedItemProperty().getValue() == null)
            return;

        var collection = db.getCollection("Users");
        collection.deleteOne(eq("_id", table.getSelectionModel().selectedItemProperty().getValue().getId()));

        getPeople();
    }

    public void getPeople()
    {
        people.clear();

        var collection = db.getCollection("Users");
        for (Document doc : collection.find())
        {
            people.add(new Person(doc));
        }
    }




}

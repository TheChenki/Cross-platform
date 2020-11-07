import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.Person;
import org.bson.types.ObjectId;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML private PeopleController peopleController;
    @FXML private CarController carsController;

    private Person person;

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        peopleController.setParentController(this);
        carsController.setParentController(this);
    }

}

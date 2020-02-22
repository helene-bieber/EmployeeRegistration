import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PersonGUIController extends Application {

	private MainPerson mainPerson;
	private PersonGUIView personInputView;

	public PersonGUIController() {
		mainPerson = new MainPerson(); 
      personInputView = new PersonGUIView();
		personInputView.setProcessIsWorkingAction(this::processIsWorking);
		personInputView.setDisplayPersonsAction(this::displayPersons);
		personInputView.setAddPersonAction(this::addPerson);
	}

	
	public void start(Stage primaryStage) {
		PersonGUIController controller = new PersonGUIController();
		Scene scene = new Scene(controller.personInputView.getParent(), 500, 500, Color.BEIGE);
		primaryStage.setTitle("Professor registration system");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void addPerson(ActionEvent event) {	
			String name = personInputView.getNameField(); 
			String email = personInputView.getEmailField(); 
         String department = personInputView.getDepartmentField();        
			Semester semester = personInputView.getSemesterField();

			Person person = new Teacher(name, email, department, semester); 
         mainPerson.addPerson(person);
			personInputView.clearInputs(); 
		}


	private void processIsWorking(ActionEvent event) {
		ArrayList<Person> personList = mainPerson.getPersonList(); 
      String output = "";
		for (Person p : personList) {
        if(p instanceof Teacher){
			 output += ((Teacher)p).working() + "\n";
        }
		}
		personInputView.displayResultText("Professors", output); 
	}

	private void displayPersons(ActionEvent event) {
		ArrayList<Person> personList = mainPerson.getPersonList(); 
		String output = "";
		for (Person p : personList) {
			output += p.toString() + "\n";
		}
		personInputView.displayResultText("Professor:", output); 

	}

}

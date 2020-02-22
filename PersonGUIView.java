import java.util.Arrays;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class PersonGUIView {
	
	private TextField emailField, nameField, departmentField;
	private ComboBox<Semester> semesterComboBox;
	private Text firstText, emailText, nameText, departmentText, semesterText, resultText;
	private TextArea outputResult;
	private Button addButton, displayButton, isWorkingButton;
	private FlowPane pane;
	private final static Font font = Font.font("Verdana", 20);
	
	public PersonGUIView() {
		
		pane = new FlowPane();
		pane.setStyle("-fx-background-color: grey");
      pane.setVgap(20);

		firstText = new Text("Welcome to the Professor registery system!\n Please enter the Pofessor informations.");
		firstText.setFont(font);
		pane.getChildren().add(firstText);
		
		nameText = new Text("Enter the name:");
		nameText.setFont(font);
		nameField = new TextField();
		HBox nameBox = new HBox(nameText, nameField);
		nameBox.setSpacing(10);
		pane.getChildren().add(nameBox);
		
		emailText = new Text("Enter the email:");
		emailText.setFont(font);
		emailField = new TextField();
		HBox emailBox = new HBox(emailText, emailField);
		emailBox.setSpacing(10);
		pane.getChildren().add(emailBox);
      
      departmentText = new Text("Enter the department:");
		departmentText.setFont(font);
		departmentField = new TextField();
		HBox departmentBox = new HBox(departmentText, departmentField);
		departmentBox.setSpacing(10);
		pane.getChildren().add(departmentBox);
 
		
		semesterText = new Text("Select the semester:");
		semesterText.setFont(font);
		ObservableList<Semester> semesterOptions = FXCollections.observableArrayList((Arrays.asList(Semester.values())));
		semesterComboBox = new ComboBox<Semester>(semesterOptions);
		semesterComboBox.setValue(Semester.FALL);
		HBox semesterBox = new HBox(semesterText, semesterComboBox);
		semesterBox.setSpacing(10);
		pane.getChildren().add(semesterBox);
		
		addButton = new Button("Add Professor");
		displayButton = new Button("Show Professor Data");
		isWorkingButton = new Button("Who is working this semester");
		
		HBox buttonBox = new HBox(addButton, displayButton, isWorkingButton);
		buttonBox.setSpacing(10);
		pane.getChildren().add(buttonBox);

		resultText = new Text("");
		resultText.setFont(font);
		resultText.setVisible(false);
      pane.getChildren().add(resultText);
		outputResult = new TextArea("");
		outputResult.setVisible(false);
		pane.getChildren().add(outputResult);
		
	}
	
	public Parent getParent() {
		return pane;
	}

	public void setProcessIsWorkingAction(EventHandler<ActionEvent> handler) {
		isWorkingButton.setOnAction(handler);
	}
	public void setDisplayPersonsAction(EventHandler<ActionEvent> handler) {
		displayButton.setOnAction(handler);
	}
	public void setAddPersonAction(EventHandler<ActionEvent> handler) {
		addButton.setOnAction(handler);
	}

	public void displayResultText(String label, String output) {
		resultText.setVisible(true);
		resultText.setText(label);
      outputResult.clear();
   	outputResult.setVisible(true);
		outputResult.setText(output);
	}
	
	public void clearInputs() {
		nameField.clear();
		emailField.clear();
      departmentField.clear();
		semesterComboBox.setValue(Semester.FALL);
	}
	
	public String getNameField() {
		return nameField.getText();
	}
	public String getEmailField() {
		return emailField.getText();
	}
   public String getDepartmentField(){
      return departmentField.getText();
   }
	public Semester getSemesterField() {
		return semesterComboBox.getValue();
	}
	
	public void setNameField(String text) {
		nameField.setText(text);
	}
	public void setEmailField(String text) {
		emailField.setText(text);
	}
   public void setDepartmentField(String text) {
		departmentField.setText(text);
	}

   
	
	public void setSemesterField(Semester semester) {
		semesterComboBox.setValue(semester);
	}
	
	
	
	

	
}

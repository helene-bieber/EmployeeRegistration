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
	private Text introText, emailLabel, nameLabel, departmentLabel, semesterLabel, resultLabel;
	private TextArea result;
	private Button addButton, displayButton, isWorkingButton;
	private VBox primaryBox;
	
	private final static Font font = Font.font("Helvetica", 20);
	
	public PersonGUIView() {
		System.setProperty("glass.accessible.force", "false");
		
		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(20);
		primaryBox.setStyle("-fx-background-color: white");

		introText = new Text("Welcome to the Professor registery system!\n Please enter the Pofessor informations.");
		introText.setFont(font);
		VBox introBox = new VBox(introText);
		introBox.setAlignment(Pos.CENTER);
		introBox.setSpacing(10);
		primaryBox.getChildren().add(introBox);
		
		nameLabel = new Text("Enter the name:");
		nameLabel.setFont(font);
		nameField = new TextField();
		VBox nameBox = new VBox(nameLabel, nameField);
		nameBox.setAlignment(Pos.CENTER);
		nameBox.setSpacing(10);
		primaryBox.getChildren().add(nameBox);
		
		emailLabel = new Text("Enter the email:");
		emailLabel.setFont(font);
		emailField = new TextField();
		VBox emailBox = new VBox(emailLabel, emailField);
		emailBox.setAlignment(Pos.CENTER);
		emailBox.setSpacing(10);
		primaryBox.getChildren().add(emailBox);
      
      departmentLabel = new Text("Enter the department:");
		departmentLabel.setFont(font);
		departmentField = new TextField();
		VBox departmentBox = new VBox(departmentLabel, departmentField);
		departmentBox.setAlignment(Pos.CENTER);
		departmentBox.setSpacing(10);
		primaryBox.getChildren().add(departmentBox);

		
		semesterLabel = new Text("Select the semester:");
		semesterLabel.setFont(font);
		ObservableList<Semester> statusOptions = FXCollections.observableArrayList((Arrays.asList(Semester.values())));
		semesterComboBox = new ComboBox<Semester>(semesterOptions);
		semesterComboBox.setValue(Semester.FALL);
		VBox semesterBox = new VBox(semesterLabel, semesterComboBox);
		semesterBox.setAlignment(Pos.CENTER);
		semesterBox.setSpacing(10);
		primaryBox.getChildren().add(semesterBox);
		
		addButton = new Button("Add Professor");
		displayButton = new Button("Show Professor Data");
		benefitsButton = new Button("Process isWorking");
		
		HBox buttonBox = new HBox(addButton, displayButton, isWorkingButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		primaryBox.getChildren().add(buttonBox);

		resultLabel = new Text("");
		resultLabel.setFont(font);
		resultLabel.setFill(Color.BLUE);
		resultLabel.setVisible(false);
		result = new TextArea("");
		result.setVisible(false);
		result.setEditable(false);
		VBox resultBox = new VBox(resultLabel, result);
		resultBox.setAlignment(Pos.CENTER);
		resultBox.setSpacing(10);
		primaryBox.getChildren().add(resultBox);

	}
	
	public Parent getParent() {
		return primaryBox;
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
		resultLabel.setVisible(true);
		resultLabel.setText(label);
		
		result.clear();
		result.setVisible(true);
		result.setText(output);
	}
	
	public void hideResultText() {
		result.clear();
		result.setVisible(false);
		resultLabel.setVisible(false);
	}
	public void clearInputs() {
		nameField.clear();
		emailField.clear();
      departmentField.clear();
		semesterComboBox.setValue(semester.FALL);
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

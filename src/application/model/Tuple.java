package application.model;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Tuple {

	private Label id;
	private Label firstName;
	private Label lastName;
	private Label age;
	
	private final Insets constInsets = new Insets(0, 100, 0, 0);
	public Tuple(String id, String firstName, String lastName, String age) {
		this.id = new Label(id);
		this.firstName = new Label(firstName);
		this.lastName = new Label(lastName);
		this.age = new Label(age);
		
		initTextFields();
	
	}
	private void initTextFields() {
		id.setPadding(constInsets);
		firstName.setPadding(constInsets);
		lastName.setPadding(constInsets);
		age.setPadding(constInsets);		
		
//		id.setDisable(true);
//		firstName.setDisable(true);
//		lastName.setDisable(true);
//		age.setDisable(true);
	}
	public String getId() {
		return id.getText();
	}
	public String getFirstName() {
		return firstName.getText();
	}
	public String getLastName() {
		return lastName.getText();
	}
	public String getAge() {
		return age.getText();
	}
	
	public HBox getTuple() {
		HBox row = new HBox();
		row.getChildren().add(id);
		row.getChildren().add(firstName);
		row.getChildren().add(lastName);
		row.getChildren().add(age);
		
		return row;
	}
	
	
}

package application.controller;

import javax.swing.JDialog;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CRUDController {

	
	@FXML
	private Button addButton;
	
	@FXML
	private Button clearButton;
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private TextField age;
	
	@FXML
	public void handleAdd() {
		
		System.out.println("Här ska vi addera datan till DATABASEN!");
		System.out.println(firstName.getText() + ":" + lastName.getText() + ":" + age.getText());
		
	}
	
	@FXML
	public void clear() {
		firstName.clear();
		lastName.clear();
		age.clear();
	}
	
	
	
	
	
	@FXML
	private Button deleteButton;
	
	@FXML
	private Button updateButton;
	
	
	
	
}

package application.controller;

import application.Main;
import application.model.Artist;
import application.model.ArtistDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CRUDController implements SubController{

	
	private ArtistDAO dao;
	private MainController mainController;
	private Main mainWindow;
	private ObservableList<Artist> db;
	
	public Main getMainWindow() {
		return mainWindow;
	}

	@FXML 
	private Label dynamicLabel;
	
	
	@FXML
	private Button addButton;
	
	@FXML
	private Button clearButton;
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private TextField searchField;
	
	@FXML
	private TextField age;
	
	@FXML
	public void handleAdd() {
		
		System.out.println("Här ska vi addera datan till DATABASEN!");
		System.out.println(firstName.getText() + ":" + lastName.getText() + ":" + age.getText());
		
	}
	
	@FXML
	public void clear() {
		if(firstName!=null)
		firstName.clear();
		if(lastName!=null)
		lastName.clear();
		if(age!=null)
		age.clear();
		if(searchField!=null)
		searchField.clear();
	}
	
	@FXML
	public void cancel() {
		mainWindow.cancel();
	}
	
	@FXML
	public void handleSearch() {
		
		switch(dynamicLabel.getText()) {
		case "First Name":
			
			break;
		case "Last Name":
			break;
		case "Age":
			break;
		case "ID":
			System.out.println(searchField.getText());
//			dao.findById(Integer.parseInt(searchField.getText()));
			break;
		}
	}
	
	
	
	@FXML
	private Button deleteButton;
	
	@FXML
	private Button updateButton;

	public void setDynamicLabel(String element) {
		dynamicLabel.setText(element);
	}

	@Override
	public void setWindowAndController(Main mainWindow, MainController mainController) {
		this.mainWindow = mainWindow;
		this.mainController = mainController;
	}

	@Override
	public void setDaoAndDB() {
		dao = mainController.getDao();
		db = mainController.getDB();
	}
	
	
	
	
}

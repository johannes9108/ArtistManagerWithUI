package application.controller;

import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.model.Artist;
import application.model.ArtistDAO;
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
//	@FXML
//	public void initialize() {
//		dao = mainController.getDao();
//		db = mainController.getDB();
//	}

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
		mainWindow.closePopUp();
	}
	
	@FXML
	public void handleSearch() {
		System.out.println(searchField.getText());
		
		switch(dynamicLabel.getText()) {
		case "First Name":
			System.out.println(dao.findByFirstName(searchField.getText()));
			mainWindow.closePopUp();
			mainController.showSearchResults(dao.findByFirstName(searchField.getText()));
			break;
		case "Last Name":
			mainWindow.closePopUp();
			mainController.showSearchResults(dao.findByLastName(searchField.getText()));
			break;
		case "Age":
			mainWindow.closePopUp();
			mainController.showSearchResults(dao.findByAge(Integer.parseInt(searchField.getText())));
			
			break;
		case "ID":
			mainWindow.closePopUp();
			mainController.showSearchResults(convertSingleToList(dao.findById(Integer.parseInt(searchField.getText()))));
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
		db = mainController.getDB();
		dao = mainController.getDao();
	}


	private List<Artist> convertSingleToList(Artist artist){
		ArrayList<Artist> convert = new ArrayList<>();
		convert.add(artist);
	return convert;
	}
	
	
	
}

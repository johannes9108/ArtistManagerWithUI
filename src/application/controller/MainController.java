package application.controller;

import java.util.List;

import application.Main;
import application.model.Artist;
import application.model.ArtistDAO;
import application.model.ArtistDAOJDBCImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	private Main mainWindow;
	private ArtistDAO dao;
	private ObservableList<Artist> db;
	
	public MainController() {
		dao = new ArtistDAOJDBCImpl();
		db = FXCollections.observableArrayList(dao.getAll());
	}

	public Main getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(Main mainWindow) {
		this.mainWindow = mainWindow;
	}
	



	@FXML
	Button showButton;

	@FXML
	Button addButton;

	@FXML
	Button updateButton;

	@FXML
	Button deleteButton;

	@FXML
	Button findById;

	@FXML
	Button findByFirstName;

	@FXML
	Button findByLastName;

	@FXML
	Button findByAge;

	public void showAll() {
		mainWindow.cancel();
		mainWindow.showAllView(db);
		

	}

	public void add() {
		mainWindow.cancel();
		mainWindow.showAddView();

	}

	public void delete() {
		mainWindow.cancel();
		mainWindow.showDeleteView();

	}

	public void update() {

		mainWindow.cancel();
		mainWindow.showUpdateView();
	}

	public void clear() {

		mainWindow.clear();
	}

	public void cancel() {
		mainWindow.cancel();

	}

	// HÄMTA DATA FRÅN DB och skicka vidare till VYN
	public void findByElement(ActionEvent event) {
		Button button = (Button) event.getSource();
		System.out.println(button.getId());
		String returningString = "";

		switch (button.getId()) {

		case "findByFirstName":
			returningString = "First Name";
			break;
		case "findByLastName":
			returningString = "Last Name";
			break;
		case "findByAge":
			returningString = "Age";
			break;
		case "findById":
			returningString = "ID";
			break;
		}

		mainWindow.findByElement(returningString);

	}

	public ArtistDAO getDao() {
		return dao;
	}

	public ObservableList<Artist> getDB() {
		return db;
	}

}

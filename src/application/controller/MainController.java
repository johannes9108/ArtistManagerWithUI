package application.controller;

import java.util.List;

import javax.swing.text.TabExpander;

import application.Main;
import application.model.Artist;
import application.model.ArtistDAO;
import application.model.ArtistDAOJDBCImpl;
import application.model.ArtistDAOJPAImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	private Main mainWindow;
	private TableViewController tableViewController;
	private CRUDController crudController;
	private ArtistDAO dao;
	private List<Artist> db;

	public MainController() {
		dao = new ArtistDAOJPAImpl();
		db = dao.getAll();
	}

	public TableViewController getTableViewController() {
		return tableViewController;
	}

	public CRUDController getCrudController() {
		return crudController;
	}

	public void setTableViewController(TableViewController tableViewController) {
		this.tableViewController = tableViewController;
		this.tableViewController.setWindowAndController(mainWindow, this);

	}

	public void setCrudController(CRUDController crudController) {
		this.crudController = crudController;
		this.crudController.setWindowAndController(mainWindow, this);
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
		mainWindow.closePopUp();
		mainWindow.showAllView();
		tableViewController.fillTable(db);

	}

	public void add() {
		mainWindow.closePopUp();
		mainWindow.showAddView();

	}

	public void delete() {
		mainWindow.closePopUp();
		Artist selectedArtist = tableViewController.getSelected();
		deleteSelected(selectedArtist);
		
	}

	public void update() {

		mainWindow.closePopUp();
		mainWindow.showUpdateView();
		
		Artist selectedItem = tableViewController.getSelected();
		crudController.populateUpdate(selectedItem);
	}

	public void clear() {

		mainWindow.clear();
	}

	public void cancel() {
		mainWindow.closePopUp();

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

		mainWindow.findByElement();
		crudController.setDynamicLabel(returningString);

	}

	public ArtistDAO getDao() {
		return dao;
	}

	public ObservableList<Artist> getDB() {
		return FXCollections.observableArrayList(db);
	}

	public void showSearchResults(List<Artist> results) {
		tableViewController.showSearchResults(results);
	}

	public void refresh() {
		db = dao.getAll();
	}
	
	
	public void deleteSelected(Artist selectedArtist) {
		dao.delete(selectedArtist.getId());
		refresh();
		showAll();
	}

}

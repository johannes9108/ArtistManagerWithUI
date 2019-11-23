package application.controller;

import java.util.List;

import application.Main;
import application.model.Artist;
import application.model.ArtistDAO;
import application.model.ArtistDAOJDBCImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	private Main mainWindow;
	private ArtistDAO aDao;
	
	private List<Artist> db;

	public Main getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(Main mainWindow) {
		this.mainWindow = mainWindow;
		aDao = new ArtistDAOJDBCImpl();
		db = aDao.showAll();
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
	Button clearButton;

	public void showAll() {
		mainWindow.showAllView(db);
	}

	public void add() {
		mainWindow.showAddView();

	}

	public void delete() {
		mainWindow.showDeleteView();

	}

	public void update() {

		mainWindow.showUpdateView();
	}

	public void clear() {

		mainWindow.clear();
	}

}

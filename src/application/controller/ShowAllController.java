package application.controller;

import java.util.List;

import application.Main;
import application.model.Artist;
import application.model.ArtistDAO;
import application.model.ArtistDAOJDBCImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowAllController implements SubController{

	private List<Artist> db;
	private ArtistDAO dao;
	private Main mainWindow;
	private MainController mainController;
	
	@FXML
	private TableView<Artist> theTable;

	@FXML
	private TableColumn<Artist, Integer> idColumn;
	
	@FXML
	private TableColumn<Artist, String> firstNameColumn;
	
	@FXML
	private TableColumn<Artist, String> lastNameColumn;
	
	@FXML
	private TableColumn<Artist, Integer> ageColumn;
	
	public ShowAllController() {
		
	}

	@FXML
	public void initialize() {
		
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
//		idColumn.setCellValueFactory(new PropertyValueFactory<Artist,Number>("id"));
//		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Artist,String>("firstName"));
//		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Artist,String>("lastName"));
//		ageColumn.setCellValueFactory(new PropertyValueFactory<Artist,Number>("age"));
//		idColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
//		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
//		lastNameColumn.setCellValueFactory(cellData->cellData.getValue().lastNameProperty());
//		ageColumn.setCellValueFactory(cellData->cellData.getValue().idProperty());
		
//		theTable.getItems().add(art);
		

	}

	public void printStatus() {
		theTable.getItems().forEach(System.out::println);
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

	public void fillTable() {
		ObservableList<Artist> artists = FXCollections.observableArrayList();
		artists.add(new Artist(10, "j", "j", 10));
		artists.add(new Artist(20, "j", "j", 10));

		db.forEach(System.out::println);
		theTable.getItems().addAll(db);
		
//		theTable.setItems(artists);
		System.out.println(theTable.getItems());
		System.out.println(theTable.getColumns());
		
		System.out.println(firstNameColumn.getCellData(1));

	}

	
	
}

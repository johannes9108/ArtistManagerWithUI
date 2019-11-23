package application;
	
import java.io.IOException;
import java.util.List;

import application.controller.MainController;
import application.model.Artist;
import application.model.Tuple;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	private MainController controller;
	private BorderPane root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/Main.fxml"));
			root = loader.load();
			controller = loader.getController();
			controller.setMainWindow(this);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void showAllView(List<Artist> db) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/showAllv2.fxml"));
			BorderPane ap = loader.load();
			
			SplitPane sp = (SplitPane) root.getCenter();
			sp.getItems().set(1, ap);
			
			ListView<HBox> theListView = (ListView) ap.getCenter();
			
			
			
			
			ObservableList<HBox> list = FXCollections.observableArrayList();
			
			for(Artist artist: db) {
				list.add(new Tuple(artist.getId()+"",artist.getFirstName(),artist.getLastName(),artist.getAge()+"").getTuple());
			}
			
			theListView.setItems(list);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void showAddView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/AddView.fxml"));
			Node node = loader.load();
			
			SplitPane sp = (SplitPane) root.getCenter();
			sp.getItems().set(1, node);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void showDeleteView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/DeleteView.fxml"));
			Node node = loader.load();
			
			SplitPane sp = (SplitPane) root.getCenter();
			sp.getItems().set(1, node);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

	public void showUpdateView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/UpdateView.fxml"));
			Node node = loader.load();
			
			SplitPane sp = (SplitPane) root.getCenter();
			sp.getItems().set(1, node);
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void clear() {
//		SplitPane sp = (SplitPane) root.getCenter();
//		sp.getItems().set(1, null);
	}
	
	
}

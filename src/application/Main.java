package application;

import java.io.IOException;
import java.util.List;

import application.controller.CRUDController;
import application.controller.MainController;
import application.controller.TableViewController;
import application.model.Artist;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private BorderPane root;
	private Stage popUpStage;
	private MainController mainController;

	@Override
	public void start(Stage primaryStage) {
		try {

			popUpStage = new Stage();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/Main.fxml"));
			root = loader.load();

			mainController = loader.getController();
			mainController.setMainWindow(this);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void showAllView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/showAllv2.fxml"));
			AnchorPane node = loader.load();

			SplitPane sp = (SplitPane) root.getCenter();
			sp.getItems().set(1, node);

			mainController.setTableViewController(loader.getController());
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showAddView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/AddView.fxml"));
			Parent node = loader.load();

			mainController.setCrudController(loader.getController());
			
			popUpStage.setScene(new Scene(node));
			popUpStage.show();

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

	public void closePopUp() {
		if (popUpStage != null)
			popUpStage.close();
	}

	public void findByElement() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/findByElement.fxml"));
			Parent node = loader.load();

			mainController.setCrudController(loader.getController());

			popUpStage.setScene(new Scene(node));
			popUpStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}

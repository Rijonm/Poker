package Game;

import Controller.PokerController;
import Model.PokerModel;
import View.PokerView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class PokerGame extends Application {
	PokerView view;
	PokerModel model;
	PokerController controller;
	public static int NUM_PLAYERS = 2;
	
	 public static void main(String[] args) {
	        launch();
	        
	    }
	
	@Override
	public void start(Stage primaryStage) {
		model = new PokerModel();
		view = new PokerView(primaryStage, model); //model to add
		controller = new PokerController(model, view);
		
	}
	
	
	
	
	

}

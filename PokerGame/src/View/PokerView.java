package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Game.PokerGame;
import Model.PokerModel;

public class PokerView {
	private VBox players;
	private ControlArea controls;
	private MenuArea menuBar;
	
	private PokerModel model;
	public Stage primaryStage;
	
	
	public PokerView(Stage primaryStage, PokerModel model) {
		this.model = model;
		this.primaryStage = primaryStage;
		
		
		// Create all of the player panes we need, and put them into an HBox
		players = new VBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
		}
		
		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic
		
		menuBar = new MenuArea();
		
		
		
		// Put players and controls into a BorderPane
		BorderPane root = new BorderPane();
		root.setTop(menuBar);
		root.setCenter(players);
		root.setBottom(controls);
		
		// Disallow resizing - which is difficult to get right with images
		primaryStage.setResizable(false);

        // Create the scene using our layout; then display it
        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("♥♦♣♠ PokerGame ♠♣♦♥");
        primaryStage.setScene(scene);
        primaryStage.show();		
	}
		

		public PlayerPane getPlayerPane(int i) {
			return (PlayerPane) players.getChildren().get(i);
		}

		public Button getShuffleButton() {
			return controls.btnShuffle;
		}

		public Button getDealButton() {
			return controls.btnDeal;
		}
		
		public MenuItem getHelp() {
			return menuBar.howTo;
		}
		public MenuItem setTwoPlayers() {
			return menuBar.two;
		}
		public MenuItem setThreePlayers() {
			return menuBar.three;
		}
		
		public MenuItem setFourPlayers() {
			return menuBar.four;
		}
		
		public MenuItem getScores() {
			return menuBar.scores;
		}
		
		
	

}

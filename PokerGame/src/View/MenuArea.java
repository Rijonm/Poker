package View;

import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;

public class MenuArea extends MenuBar{
	public Menu menu = new Menu("Menu");;
	public Menu numbPlayers = new Menu("Players");;
	public MenuItem two = new MenuItem("2");
	public MenuItem three = new MenuItem("3");
	public MenuItem four = new MenuItem("4");
	public MenuItem scores = new MenuItem("Scores...");
	public Menu help = new Menu("Help");
	public MenuItem howTo = new MenuItem("How to...");
	
	public MenuArea() {
		super();
			
			numbPlayers.getItems().addAll(two, three, four);
			menu.getItems().addAll(numbPlayers, scores);
			help.getItems().add(howTo);
			this.getMenus().addAll(menu, help);
			
			
	}
	
	
}
package View;



import Model.Card;
import Model.HandType;
import Model.Player;
import Model.PokerModel;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class PlayerPane extends VBox {
	private Label lblName = new Label();
    private HBox hboxCards = new HBox();
    private Label lblEvaluation = new Label("--");
    private Label lblWinnerOrLoser = new Label("--");
    public  int counter = 0;
    
    // Link to player object
    private Player player;

    
    protected VBox vbox;
	
	public PlayerPane() {
		super(); // Always call super-constructor first !!
        this.getStyleClass().add("player"); // CSS style class
        this.lblName.setStyle("-fx-text-fill:white;");
        this.lblEvaluation.setStyle("-fx-text-fill:white;");
        
        // Add child nodes
        this.getChildren().addAll(lblName, hboxCards, lblEvaluation, lblWinnerOrLoser);
        
        // Add CardLabels for the cards
        
        for (int i = 0; i < 5; i++) {
           Label lblCard = new CardLabel();
           hboxCards.getChildren().addAll(lblCard);
        }
	}
	
	public void setPlayer(Player player) {
    	this.player = player;
    	updatePlayerDisplay(); // Immediately display the player information
    }
    
    public void updatePlayerDisplay() {
    	lblName.setText(player.getPlayerName());
    	for (int i = 0; i < Player.HAND_SIZE; i++) {
    		Card card = null;
    		if (player.getCards().size() > i) 
    			card = player.getCards().get(i);
    		CardLabel cl = (CardLabel) hboxCards.getChildren().get(i);
    		cl.setCard(card);
    		HandType evaluation = player.evaluateHand();
    		if (evaluation != null)
    			lblEvaluation.setText(evaluation.toString());
    		else
    			lblEvaluation.setText("--");
    		
    		if (evaluation != null) {
    			lblWinnerOrLoser.setText(player.winnerOrLoser);
    			if(lblWinnerOrLoser.getText() == "Winner") { 
    				lblWinnerOrLoser.setStyle("-fx-background-color: green");
    				counter++;
    			}
    			if(lblWinnerOrLoser.getText() == "Loser") 
        			lblWinnerOrLoser.setStyle("-fx-background-color: red");
    			if(lblWinnerOrLoser.getText() == "Splitpot") 
    				lblWinnerOrLoser.setStyle("-fx-background-color: orange");
    		}
    		else
    			lblWinnerOrLoser.setText("--");
    		if(lblWinnerOrLoser.getText() == "--") 
    			lblWinnerOrLoser.setStyle("-fx-background-color: none");
    	}
    	
    }
    public int getCounter() {
		
		return counter;
    }
}

package View;

import Model.DeckOfCards;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DeckLabel extends Label {
	Image back = new Image(this.getClass().getClassLoader().getResourceAsStream("PokerImages/back_card3.png"));
	ImageView b = new ImageView(back);
	public DeckLabel() {
		super();
		this.setStyle("-fx-text-fill:white;");
		
	}
	
	// Bind the label to the CardsRemaining property of the deck
	public void setDeck(DeckOfCards deck) {
		this.textProperty().bind(deck.getCardsRemainingProperty().asString());
		b.setFitHeight(40);
		b.setFitWidth(25);
		this.setGraphic(b);
	}
}

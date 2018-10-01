package View;

import Model.Card;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardLabel extends Label {
	public CardLabel() {
		super();
		this.getStyleClass().add("card");
	}
	public void setCard(Card card) {
		if (card != null) {
			String fileName = cardToFileName(card);
			Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("PokerImages/" + fileName));
			ImageView imv = new ImageView(image);
			imv.fitWidthProperty().bind(this.widthProperty());
			imv.fitHeightProperty().bind(this.heightProperty());
			imv.setPreserveRatio(true);
			this.setGraphic(imv);
		} else {
			Image back = new Image(this.getClass().getClassLoader().getResourceAsStream("PokerImages/back_card3.png"));
			ImageView b = new ImageView(back);
			b.fitWidthProperty().bind(this.widthProperty());
			b.fitHeightProperty().bind(this.heightProperty());
			b.setPreserveRatio(true);
			this.setGraphic(b);
		}
	}

	private String cardToFileName(Card card) {
		String rank = card.getRank().toString();
		String suit = card.getSuit().toString();
		return rank + "_of_" + suit + ".png";
	}
}

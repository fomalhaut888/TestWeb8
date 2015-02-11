package test.default_methods;

public class PlayingCard implements Card {
	
	private Suit suit;
	
	private Rank rank;
	
	public PlayingCard(Suit suit, Rank rank){
			this.suit = suit;
			this.rank = rank;
	}
	
	@Override
	public int hashCode() {
	    	return ((suit.value()-1)*13)+rank.value();
	}

	@Override
	public int compareTo(Card o) {
			return this.hashCode() - o.hashCode();
	}

	@Override
	public Suit getSuit() {
			return suit;
	}

	@Override
	public Rank getRank() {
			return rank;
	}

}

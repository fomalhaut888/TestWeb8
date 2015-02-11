package test.default_methods;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import test.default_methods.Card.Rank;
import test.default_methods.Card.Suit;

public class StandardDeck implements Deck {
	
	private List<Card> entireDeck;
	
	public StandardDeck(){
			deckFactory();
	}
	
	@Override
	public void sort() {
			Collections.sort(entireDeck);
	}

	@Override
	public void sort(Comparator<Card> c) {
			Collections.sort(entireDeck, c);
	}
	
	public static void main(String args[]){
			Deck myDeck = new StandardDeck();
			myDeck.shuffle();
			//myDeck.sort(new SortByRankThenSuit());
			//compare with one criterium only
			//myDeck.sort((firstCard, secondCard) -> firstCard.getRank().value() - secondCard.getRank().value());
			//myDeck.sort(Comparator.comparing((card) -> card.getRank()));
			//myDeck.sort(Comparator.comparing(Card::getRank));
			//compare with more than one criteria
			/*
			myDeck.sort((firstCard, secondCard) -> {
					int compare = firstCard.getRank().value() - secondCard.getRank().value();
					if (compare != 0){
							return compare;
					}else{
							return firstCard.getSuit().value() - secondCard.getSuit().value();
					}
			});*/
			/*
			myDeck.sort(
					Comparator.comparing(Card::getRank)
							.thenComparing(Comparator.comparing(Card::getSuit)));*/
			//reverse order
			myDeck.sort(
					Comparator.comparing(Card::getRank)
							.reversed()
							.thenComparing(Comparator.comparing(Card::getSuit)));
			System.out.println(myDeck.deckToString());
	}
	
	@Override
	public List<Card> getCards() {
			return entireDeck;
	}

	@Override
	public int size() {
			return entireDeck.size();
	}

	@Override
	public void addCard(Card card) {
			entireDeck.add(card);
	}

	@Override
	public void addCards(List<Card> cards) {
			entireDeck.addAll(cards);
	}

	@Override
	public void addDeck(Deck deck) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Integer, Deck> deal(int players, int numberOfCards)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String deckToString() {
			StringBuffer sb = new StringBuffer();
			for(Card card: entireDeck){
					switch(card.getSuit()){
							case DIAMONDS:
									sb.append("\u2662");
									break;
							case CLUBS:
									sb.append("\u2663");
									break;
							case HEARTS:
									sb.append("\u2661");
									break;
							case SPADES:
									sb.append("\u2660");
									break;
					}
					switch(card.getRank()){
							case DEUCE:
									sb.append("2");
									break;
							case THREE:
									sb.append("3");
									break;
							case FOUR:
									sb.append("4");
									break;
							case FIVE:
									sb.append("5");
									break;
							case SIX:
									sb.append("6");
									break;
							case SEVEN:
									sb.append("7");
									break;
							case EIGHT:
									sb.append("8");
									break;
							case NINE:
									sb.append("9");
									break;
							case TEN:
									sb.append("10");
									break;
							case JACK:
									sb.append("J");
									break;
							case QUEEN:
									sb.append("Q");
									break;
							case KING:
									sb.append("K");
									break;
							case ACE:
									sb.append("A");
									break;
					}
					sb.append("\n");
			}
			
			return sb.toString();
	}
	
	@Override
	public void shuffle() {
			List<Card> temp = new ArrayList<Card>();
			Random r = new Random(Calendar.getInstance().getTimeInMillis());
			while(entireDeck.size() > 0){
					int i = r.nextInt(entireDeck.size());
					temp.add(entireDeck.get(i));
					entireDeck.remove(i);
			}
			entireDeck = temp;
	}

	@Override
	public Deck deckFactory() {
			if(entireDeck == null){
					entireDeck = new ArrayList<Card>();
					Card card = new PlayingCard(Suit.DIAMONDS, Rank.DEUCE);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.THREE);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.FOUR);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.FIVE);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.SIX);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.SEVEN);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.EIGHT);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.NINE);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.TEN);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.JACK);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.QUEEN);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.KING);
					addCard(card);
					card = new PlayingCard(Suit.DIAMONDS, Rank.ACE);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.DEUCE);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.THREE);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.FOUR);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.FIVE);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.SIX);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.SEVEN);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.EIGHT);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.NINE);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.TEN);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.JACK);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.QUEEN);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.KING);
					addCard(card);
					card = new PlayingCard(Suit.CLUBS, Rank.ACE);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.DEUCE);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.THREE);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.FOUR);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.FIVE);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.SIX);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.SEVEN);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.EIGHT);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.NINE);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.TEN);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.JACK);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.QUEEN);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.KING);
					addCard(card);
					card = new PlayingCard(Suit.HEARTS, Rank.ACE);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.DEUCE);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.THREE);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.FOUR);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.FIVE);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.SIX);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.SEVEN);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.EIGHT);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.NINE);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.TEN);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.JACK);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.QUEEN);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.KING);
					addCard(card);
					card = new PlayingCard(Suit.SPADES, Rank.ACE);
					addCard(card);
			}
			return this;
	}
}

package Poker;

public class DeckCard extends Deck{
	public DeckCard(){
	}
	
	public void listCard(){
		for(int i = 0; i < getNumCards(); i ++){
			System.out.println(getCards()[i].toString());
		}
	}
}

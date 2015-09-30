package Poker;

public class PlayerCard extends Deck{
	public PlayerCard(){
		super(2);
	}
	
	public void listCard(){
		for(int i = 0; i < 2; i ++){
			System.out.println(getCards()[i].toString());
		}
	}
	
}

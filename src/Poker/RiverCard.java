package Poker;

public class RiverCard extends Deck{
	public RiverCard(){
		super(5);
	}
	
	public void listCard(){
		for(int i = 0; i < 5; i ++){
			System.out.println(getCards()[i].toString());
		}
	}
}

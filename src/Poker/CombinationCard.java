package Poker;

public class CombinationCard extends Deck{
	public CombinationCard(){
		super(7);
	}
	
	public void listCard(){
		for(int i = 0; i < 7; i ++){
			System.out.println(getCards()[i].toString());
		}
	}
	
	public void pokerHandEvaluate(Card[] cards){
		System.out.println("hasPair -- " + PokerHandEvaluator.hasPair(cards));
		System.out.println("hasTwoPair -- " + PokerHandEvaluator.hasTwoPairs(cards));
		System.out.println("hasThreeOfAKind -- " + PokerHandEvaluator.hasThreeOfAKind(cards));
		System.out.println("hasStraight -- " + PokerHandEvaluator.hasStraight(cards));
		System.out.println("hasFlush -- " + PokerHandEvaluator.hasFlush(cards));
		System.out.println("hasFullHouse -- " + PokerHandEvaluator.hasFullHouse(cards));
		System.out.println("hasFourOfAKind -- " + PokerHandEvaluator.hasFourOfAKind(cards));
		System.out.println("hasStraightFlush -- " + PokerHandEvaluator.hasStraightFlush(cards));		
		System.out.println("----------------------------------------");
		System.out.print("Best Hand: ");
		
		if(PokerHandEvaluator.hasStraightFlush(cards) == true){
			System.out.print("Straight Flush\n");
		}
		
		else if(PokerHandEvaluator.hasFourOfAKind(cards) == true){
			System.out.print("Four of A Kind\n");
		}
		
		else if(PokerHandEvaluator.hasFullHouse(cards) == true){
			System.out.print("Full House\n");
		}
		
		else if(PokerHandEvaluator.hasFlush(cards) == true){
			System.out.print("Flush\n");
		}
		
		else if(PokerHandEvaluator.hasStraight(cards) == true){
			System.out.print("Straight\n");
		}
		
		else if(PokerHandEvaluator.hasThreeOfAKind(cards) == true){
			System.out.print("Three of A Kind\n");
		}
		
		else if(PokerHandEvaluator.hasTwoPairs(cards) == true){
			System.out.print("Two Pair\n");
		}
		
		else if(PokerHandEvaluator.hasPair(cards) == true){
			System.out.print("One Pair\n");
		}
		
		else{
			System.out.println(" - \n");
		}
	}
}

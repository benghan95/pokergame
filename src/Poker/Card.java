package Poker;

public class Card {
	private int value;
	private int suit;
	
	public Card(){
		
	}
	
	public Card(int value, int suit){
		this.value = value;
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public int getSuit() {
		return suit;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public String toString() {
		String SuitsInString = "";
		
		switch(this.suit){			//suits are represented by their size in integer
		
		case 1:
			SuitsInString = "Spade";
			break;
			
		case 2:
			SuitsInString = "Hearts";
			break;
			
		case 3:
			SuitsInString = "Clubs";
			break;
			
		case 4:
			SuitsInString = "Diamonds";
			break;
			
		}
		
		if(this.value < 14 && this.suit <= 4){
			
			if(this.value == 13){
				
				return "King\tof " + SuitsInString;		//suitable naming convention for poker cards in relation to their size
			}
			if(this.value == 12){
				
				return "Queen\tof " + SuitsInString;
			}
			if(this.value == 11){
				
				return "Jack\tof " + SuitsInString;
			}
			if(this.value == 10){
				
				return "10\tof " + SuitsInString;
			}
			if(this.value == 9){
	
				return "9\tof " + SuitsInString;
			}
			if(this.value == 8){
	
				return "8\tof " + SuitsInString;
			}
			if(this.value == 7){
	
				return "7\tof " + SuitsInString;
			}
			if(this.value == 6){
	
				return "6\tof " + SuitsInString;
			}
			if(this.value == 5){
	
				return "5\tof " + SuitsInString;
			}
			if(this.value == 4){
	
				return "4\tof " + SuitsInString;
			}
			if(this.value == 3){
	
				return "3\tof " + SuitsInString;
			}
			if(this.value == 2){
				
				return "2\tof " + SuitsInString;
			}
			if(this.value == 1){
				
				return "1\tof " + SuitsInString;
			}
			
		}

		else
			return "The suits or the value is not right!!!";		//if anything goes wrong
		
		return "";
	}
	
}

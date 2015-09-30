package Poker;

public abstract class Deck{
	private int deckSize;
	private Card[] cards;
	static int TopCard = 51;	//initialize a static variable for the top card in the deck   **static cant be < 0**
	
	public Deck(){
		deckSize = 52;
		cards = new Card[deckSize];
		int counter = 0;
		for(int i = 1; i <= 4; i ++){
			for(int j = 1; j <= deckSize / 4 && counter < deckSize; j ++){
				cards[counter++] = new Card(j, i);
			}
		}
	}
	
	public Deck(int deckSize){
		this.deckSize = deckSize;
		cards = new Card[deckSize];
	}
	
	public Deck(Deck other){
		System.arraycopy(cards, 0, other, 0, deckSize);
	}
	
	public Card getCardAt(int position){
		return cards[position];
	}
	
	public int getDeckSize() {
		return deckSize;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	public int getNumCards(){
		return cards.length;
	}
	
	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
	public abstract void listCard();
	
	public void shuffle() {
        int firstHalf = 0, secondHalf; //to store the position of the 2nd half
        int numOfCards = getNumCards();
        
        if (numOfCards % 2 == 0) {
            secondHalf = numOfCards / 2;
        }
        else {
            secondHalf = (numOfCards / 2) + 1; //to make the first half have one more card than the 2nd half if it has an odd number of cards left 
        }
       
        Card newCards[] = new Card[numOfCards]; //create a new array
        
        for (int i = 0; i < numOfCards; firstHalf++, secondHalf++, i+=2) {
            newCards[i] = cards[firstHalf]; //placing first card first
            
            if (secondHalf < numOfCards) { //to make sure that if the deck has an odd number of cards left, it's bound to finish at the first half. so if the second half is null, this step is not required.
                newCards[i+1] = cards[secondHalf];
            }
        }
        
        for (int i = 0; i < numOfCards; i++) {
            cards[i] = newCards[i]; //to move the new shuffled deck in the new array to the original array
        }
        
        System.out.println("Shuffled successfully.");       
    }
	
	public void cut(int position){ 
		int k = 0; 
		Card[] tempCut = new Card[position]; 
		for(int i = 0; i < position; i ++){ 
			tempCut[i] = cards[i]; 
		} 
		for(int i = 0; i < (cards.length - position);i ++){ 
			cards[i] = cards[i + position]; 
		} 
		for(int i = (cards.length - position); i < cards.length; i ++){ 
			cards[i] = tempCut[k++]; 
		} 
		System.out.println("The deck has been cut.");
	}
	
	public Card[] deal(int numCards){
		Card[] deal = new Card[numCards];
		Card[] smaller = new Card[(cards.length - numCards)];
		smaller.clone();
		
		for(int i = 0; i < numCards; i ++){
			deal[i] = cards[i];
		}
		
		for(int k = 0; k < (cards.length - numCards); k ++){
			smaller[k] = cards[numCards + k];
		}
		
		cards = (Card[]) smaller.clone();
		
		return deal;		
	}	
}

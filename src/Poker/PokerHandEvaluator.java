package Poker;

public class PokerHandEvaluator{
	
	public PokerHandEvaluator(){
	
	}

	public static boolean hasPair(Card[] cards){
		boolean isPair = false;
		
		int counter = 0;
		if(cards.length != 0){
			for(int i = 0; i < cards.length; i ++){
				for(int j = i + 1; j < cards.length; j ++){
					if(cards[i].getValue() == cards[j].getValue()){
						counter ++;						
					}
					
					if(counter >= 1){
						isPair = true;
						break;
					}
				}
			}
		}
		
		return isPair;
	}
	
	public static boolean hasTwoPairs (Card[] card){
		int firstPair = -1, secondPair = -1;
        sortCard(card);
            
        for (int i = 0; i < card.length - 1; i++) {
        	for (int j = i + 1; j < card.length; j++) {
        		if (card[i].getValue() == card[j].getValue()) {
        			firstPair = card[i].getValue();
                }
            }
        }
            
        if (firstPair == -1) {
            return false;
        }
            
        for (int i = 0; i < card.length - 1; i++) {
            for (int j = i + 1; j < card.length; j++) {
                if (card[i].getValue() == card[j].getValue()) {
                    if (card[i].getValue() != firstPair) {
                        secondPair = card[i].getValue();
                    }
                }
            }
        }
            
            
        if ((firstPair == -1) || (secondPair == -1)) {
            return false;
        }
        
        if (firstPair == secondPair) {
        	return false;
        }
            
        else {
            return true;
        }          
	}
	
	public static boolean hasThreeOfAKind(Card[] cards){
		boolean isThreeOfAKind = false;
		for(int i = 0; i < cards.length; i ++){
			for(int j = i + 1; j < cards.length; j ++){
				for(int k = j + 1; k < cards.length; k ++){
					if(cards[i].getValue() == cards[j].getValue() && cards[i].getValue() == cards[k].getValue()){
						isThreeOfAKind  = true;
						break;
					}
				}
			}
		}
		return isThreeOfAKind;
	}
	
	public static boolean hasStraight(Card[] cards){
		boolean isStraight = false;
		int jack = 0;
		int queen = 0;
		int card10 = 0;
		int counter = 0;
		int cardPivot;
		int cardTemp;

		sortCard(cards);		
		
		for(int i = 0; i < cards.length; i ++){
			cardPivot = i;
			cardTemp = cardPivot + 1;
			counter = 0;
			while(cardTemp < cards.length && cardPivot < cards.length){
				if(cards[cardPivot].getValue() == (cards[cardTemp].getValue() - 1)){
					cardPivot = cardTemp;
					if(cardTemp++ != cards.length){
						cardTemp = cardPivot + 1;
					}
					counter ++;
				}

				else{
					cardTemp ++;
				}
				
				if(counter >= 4){
					isStraight = true;
					break;
				}
			}
			
		}
		
		for(int k = 0; k < cards.length; k ++){ 
			if(cards[k].getValue() == 10){
				card10 ++;
			}
			
			else if(cards[k].getValue() == 11){
				jack ++;
			}
			
			else if(cards[k].getValue() == 12){
				queen ++;
			}
			
			else{
				//Nothing
			}
		}
		
		if(cards[0].getValue() == 1 && card10 >= 1 && jack >= 1 && queen >= 1 && cards[cards.length - 1].getValue() == 13){
			isStraight = true;
		}
		
		return isStraight;
	}
	
	public static boolean hasStraight(Card[] cards, int length){
		boolean isStraight = false;
		int jack = 0;
		int queen = 0;
		int card10 = 0;
		int counter = 0;
		int cardPivot;
		int cardTemp;

		sortCard(cards, length);		
		
		for(int i = 0; i < length; i ++){
			cardPivot = i;
			cardTemp = cardPivot + 1;
			counter = 0;
			while(cardTemp < length && cardPivot < length){
				if(cards[cardPivot].getValue() == (cards[cardTemp].getValue() - 1)){
					cardPivot = cardTemp;
					if(cardTemp++ != length){
						cardTemp = cardPivot + 1;
					}
					counter ++;
				}

				else{
					cardTemp ++;
				}
				
				if(counter >= 4){
					isStraight = true;
					break;
				}
			}
			
		}
		
		for(int k = 0; k < length; k ++){ 
			if(cards[k].getValue() == 10){
				card10 ++;
			}
			
			else if(cards[k].getValue() == 11){
				jack ++;
			}
			
			else if(cards[k].getValue() == 12){
				queen ++;
			}
			
			else{
				//Nothing
			}
		}
		
		if(cards[0].getValue() == 1 && card10 >= 1 && jack >= 1 && queen >= 1 && cards[length - 1].getValue() == 13){
			isStraight = true;
		}
		
		return isStraight;
	}
	
	public static boolean hasFlush(Card[] cards){
		boolean isFlush = true;
		int spades = 0;
		int hearts = 0;
		int clubs = 0;
		int diamonds = 0;
		
		for(int i = 0; i < cards.length; i ++){
			if(cards[i].getSuit() == 1){
				spades ++;
			}
			
			else if(cards[i].getSuit() == 2){
				hearts ++;
			}
			
			else if(cards[i].getSuit() == 3){
				clubs ++;
			}
			
			else {
				diamonds ++;
			}
		}
		
		if(spades >= 5 || hearts >= 5 || clubs >= 5 || diamonds >= 5){
			isFlush = true;
		}
		
		else{
			isFlush = false;
		}
		
		return isFlush;
	}
	
	public static boolean hasFullHouse(Card[] cards){
		boolean isFullHouse = false;
		
		if(hasThreeOfAKind(cards) == true && hasTwoPairs(cards) == true){
			isFullHouse = true;
		}
		
		else{
			isFullHouse = false;
		}
		
		return isFullHouse;
	}
	
	public static boolean hasFourOfAKind(Card[] cards){
		boolean isFourOfAKind = false;
		int counter;
		for(int i = 0; i < cards.length - 3; i ++){
			counter = 0;
			for(int j = i + 1; j < cards.length; j ++){
				if(cards[i].getValue() == cards[j].getValue()){
					counter ++;
				}
				
				if(counter >= 3){
					return true;
				}
					
				else{
					isFourOfAKind = false;
				}
			}
		}
		return isFourOfAKind;
	}
	
	
	public static boolean hasStraightFlush(Card[] cards){
		boolean isStraightFlush = false;
		int spadeCtr = 0;
		int heartCtr = 0;
		int clubCtr = 0;
		int diamondCtr = 0;
		
		Card[] spade = new Card[7];
		Card[] heart = new Card[7];
		Card[] club = new Card[7];
		Card[] diamond = new Card[7];
		
		for(int i = 0; i < cards.length; i ++){
			if(cards[i].getSuit() == 1){
				spade[spadeCtr++] = cards[i];
			}
			
			else if(cards[i].getSuit() == 2){
				heart[heartCtr++] = cards[i];
			}
			
			else if(cards[i].getSuit() == 3){
				club[clubCtr++] = cards[i];
			}
			
			else {
				diamond[diamondCtr++] = cards[i];
			}
		}
		
		if(spade[4] != null){
			if(spadeCtr != 0){
				sortCard(spade, spadeCtr - 1);
				if(hasStraight(spade, spadeCtr - 1) == true){
					isStraightFlush = true;
				}
				
				else{
					isStraightFlush = false;
				}
			}
			
			else{
				isStraightFlush = false;
			}
		}
		
		else if(heart[4] != null){
			if(heartCtr != 0){
				sortCard(heart, heartCtr - 1);
				if(hasStraight(heart, heartCtr - 1) == true){
					isStraightFlush = true;
				}
				
				else{
					isStraightFlush = false;
				}
			}
			
			else{
				isStraightFlush = false;
			}
		}
		
		else if(club[4] != null){
			if(clubCtr != 0){
				sortCard(club, clubCtr - 1);
				if(hasStraight(club, clubCtr - 1) == true){
					isStraightFlush = true;
				}
				
				else{
					isStraightFlush = false;
				}
			}
			
			else{
				isStraightFlush = false;
			}
		}
		
		else if(diamond[4] != null) {
			if(diamondCtr != 0){
				sortCard(diamond, diamondCtr - 1);
				if(hasStraight(diamond, diamondCtr - 1) == true){
					isStraightFlush = true;
				}
				
				else{
					isStraightFlush = false;
				}
			}
			
			else{
				isStraightFlush = false;
			}
		}
		
		else{
			isStraightFlush = false;
		}
	
		return isStraightFlush;
	}
	
	public static Card[] sortCard(Card[] cards){
		for(int i = cards.length; i > 1; i --){
			for(int j = 1; j < cards.length; j ++){
				while(cards[j - 1].getValue() > cards[j].getValue()){
					int temp = cards[j].getValue();
					cards[j].setValue(cards[j - 1].getValue());
					cards[j - 1].setValue(temp);
				}
			}			
		}
		
		return cards;
	}
	
	public static Card[] sortCard(Card[] cards, int length){
		for(int i = cards.length; i > 1; i --){
			for(int j = 1; j < length; j ++){
				while(cards[j - 1].getValue() > cards[j].getValue()){
					int temp = cards[j].getValue();
					cards[j].setValue(cards[j - 1].getValue());
					cards[j - 1].setValue(temp);
				}
			}			
		}
		
		return cards;
	}
}

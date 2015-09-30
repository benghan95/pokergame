package Poker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver{
	static Scanner scanner = new Scanner(System.in);
	static DeckCard deck = new DeckCard();
	
	public static void main(String[] args){
		int noOfPlayer = 0;
		PlayerCard[] player = new PlayerCard[noOfPlayer];
		RiverCard river = new RiverCard();
		
		int option = 1;
		while(option >= 1 && option <= 8){
		System.out.println("=============================");	
		System.out.println("Poker Game");
		System.out.println("=============================");
		System.out.println("\t1. Shuffle Card");
		System.out.println("\t2. Cut Deck");
		System.out.println("\t3. Deal Cards");
		System.out.println("\t4. List Deck");
		System.out.println("\t5. Results");
		System.out.println("\t6. Exit");
		System.out.println("=============================");
		
		System.out.print("Enter a valid option [1~6]: ");
		
		boolean checkException;
		
		option = -1;
		checkException = true;
		
		while(checkException || option < 1 || option > 6){
			try{
				option = scanner.nextInt(); //scan input for option
				
				//if statement to check whether the option is an option of the main menu
				if(option < 1 || option  > 6){
					System.out.println("Invalid Option! Selection must be within [1 ~ 8] ");
					System.out.println("Please re-enter a valid option: ");
				}
				
				checkException = false; // to exit the while loop if the input doesn't mismatch of its data type
				
			}catch(InputMismatchException e){	//if there is a mismatch input, it will request user to re-type a correct input
				System.out.println("Invalid Option! Selection must be in Integers!");
				System.out.println("Please re-enter a valid option: ");
				scanner.nextLine();
			}
		}
		
		int position = 0;
		
		switch(option){
			case 1: 
				deck.shuffle();
				break;
				
			case 2:
				position = -1;
				checkException = true;
				
				System.out.println("Enter the position that you want to cut");
				while(checkException || position < 0 || position > deck.getDeckSize()){
					try{
						position = scanner.nextInt(); //scan input for option
						
						//if statement to check whether the option is an option of the main menu
						if(position < 0 || position > deck.getDeckSize()){
							System.out.println("Invalid Position! Position must be within [0 ~ " + deck.getDeckSize() + "]");
							System.out.println("Please re-enter a valid position: ");
						}
						
						checkException = false; // to exit the while loop if the input doesn't mismatch of its data type
						
					}catch(InputMismatchException e){	//if there is a mismatch input, it will request user to re-type a correct input
						System.out.println("Invalid Position! Position must be in Integers!");
						System.out.println("Please re-enter a valid position: ");
						scanner.nextLine();
					}
				}
				deck.cut(position);
				break;
				
			case 3:
							
				System.out.println("Enter the number of players. (Max. Player - 4, Min. Player - 2)");
								
				noOfPlayer = -1;
				checkException = true;
				
				while(checkException || noOfPlayer < 2 || noOfPlayer > 4){
					try{
						noOfPlayer = scanner.nextInt(); //scan input for option
						
						if(noOfPlayer < 2 || noOfPlayer  > 4){
							System.out.println("Invalid No. of player! No. of player must be within [2 ~ 4] ");
							System.out.println("Please re-enter a valid number: ");
						}
						
						checkException = false; // to exit the while loop if the input doesn't mismatch of its data type
						
					}catch(InputMismatchException e){	//if there is a mismatch input, it will request user to re-type a correct input
						System.out.println("Invalid No. of player! No. of player must be in Integers!");
						System.out.println("Please re-enter a valid number: ");
						scanner.nextLine();
					}
				}
				
				player = new PlayerCard[noOfPlayer];
	
				for(int k = 0; k < noOfPlayer; k ++){
					player[k] = new PlayerCard();
				}
				
				for(int i = 0; i < 2; i ++){
					for(int j = 0; j < noOfPlayer; j ++){
						System.arraycopy(deck.deal(1), 0, player[j].getCards(), i, 1);
					}
				}
				
				river = new RiverCard();
				System.arraycopy(deck.deal(5), 0, river.getCards(), 0, 5);	
				
				System.out.println("==========================================");
				System.out.println("Cards have been dealt to " + noOfPlayer + " players.");
				System.out.println("==========================================");
				
				for(int i = 0; i < noOfPlayer; i ++){
					System.out.println("Player " + (i + 1) + ": ");
					player[i].listCard();
				}
				
				System.out.println("River Card: ");
				river.listCard();
				
				break;
				
			case 4:
				deck.listCard();
				break;
				
			case 5:
				System.out.println("========================================");
				if(noOfPlayer == 0){
					System.out.println("Dealing haven't been done");
					break;
				}
				
				else{
					for(int i = 0; i < noOfPlayer; i ++){
						System.out.println("Player " + (i + 1) + ": ");
						player[i].listCard();
					}
					
					System.out.println("River Card: ");
					river.listCard();
				}
				
				System.out.println("========================================");
				System.out.println("Results");
				System.out.println("========================================");
				
				CombinationCard newDeck = new CombinationCard();
				for(int m = 0; m < noOfPlayer; m ++){
					System.arraycopy(river.getCards(), 0, newDeck.getCards(), 0, 5);
					System.arraycopy(player[m].getCards(), 0, newDeck.getCards(), 5, 2);
					System.out.println("Player " + (m + 1) + ": ");
					newDeck.listCard();
					System.out.println("----------------------------------------");
					newDeck.pokerHandEvaluate(newDeck.getCards());
					System.out.println("========================================");
				}
				
				
				
				break;
				
			case 6: 
				System.exit(0);
		}
		}
	}
}

package objectorientedprograms;


/**@purpose: Write a Program ​ DeckOfCards.java ​ , to initialize deck of cards having suit ("Clubs",
 *            "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8", "9", "10",
 *           "Jack", "Queen", "King", "Ace"). Shuffle the cards using Random method and then
 *            distribute 9 Cards to 4 Players and Print the Cards the received by the 4 Players
 *            using 2D Array...
 * @version:1.0
 * @author:Snehal Gaikwad.
 *@since:12/3/2019
 */
public class DeckOfCard {
//class for cards

	public static void main(String[] args) 
	{
		  String   SUITS[] = {"Clubs", "Diamonds", "Hearts", "Spades"};   //array for the suits
		   String  RANKS[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};//array for the ranks
		// set all cards
		int n = SUITS.length * RANKS.length;     //for checking the length of the suits and ranks
		String deck[] = new String[n];
		for (int i = 0; i < RANKS.length; i++) 
		{
			for (int j = 0; j < SUITS.length; j++) 
			{
				deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
			}
		}
		// shuffle all cards
		for (int i = 0; i < n; i++) 
		{
			int r = i+(int) (Math.random() * (n-i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
		String[][] p=new String [13][4];
		int count=0;
		for(int i=0;i<13;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(count==deck.length) break;
				p[i][j]=deck[count];
				//	System.out.println(p[i][j]);
				count++;
			}
		}
		int ply=1;
		while(ply<5)
		{
			for(int i=0; i<4; i++)
			{
				System.out.println("\n\nFor Player: "+ply+"\n");
				for(int j = 0; j<9; j++)
				{
					System.out.println(p[j][i]);
				}
				ply++;
			}
		}
	}
}
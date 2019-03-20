package objectorientedprograms;


import java.util.Objects;



public class Card
{
  
   public enum Suit
   {
      SPADES, HEARTS, DIAMONDS, CLUBS;
   }

   // The min and max valid card ranks
   private static final int MIN_RANK = 1;
   private static final int MAX_RANK = 13;

   // This instance's rank and suit
   private int rank;
   private Suit suit;

   
   public Card(int rank, Suit suit)
   {
      setRank(rank);
      setSuit(suit);
   }

   
   public int getRank()
   {
      return rank;
   }

   
   public void setRank(int rank)
   {
      if (rank < MIN_RANK || rank > MAX_RANK)
         throw new RuntimeException(
            String.format("Invalid rank: %d (must be between %d and %d inclusive)",
                          rank, MIN_RANK, MAX_RANK));
      this.rank = rank;
   }

   
   public Suit getSuit()
   {
      return suit;
   }

   
   public void setSuit(Suit suit)
   {
      if (suit == null)
         throw new RuntimeException("Suit must be non-null");
      this.suit = suit;
   }

   @Override
   public String toString()
   {
      return String.format("%s[rank=%d, suit=%s]",
                           getClass().getSimpleName(),
                           getRank(),
                           getSuit().name());
   }

   @Override
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Card))
         return false;
      if (obj == this)
         return true;

      Card that = (Card)obj;
      return that.getRank() == getRank() && that.getSuit() == getSuit();
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(getRank(), getSuit());
   }

   
   public static int getMinRank()
   {
      return MIN_RANK;
   }

   public static int getMaxRank()
   {
      return MAX_RANK;
   }

  
   public static Suit[] getSuits()
   {
      return Suit.values();
   }

   public static void main(String[] args)
   {
      Card card;

      card = new Card(10, Suit.DIAMONDS);
      System.out.println(" Ten of diamonds:");
      System.out.println("Suit = " + card.getSuit().toString().toLowerCase());
      System.out.println("Rank = " + card.getRank());
      System.out.println("Hash = " + card.hashCode());
      System.out.println();

      card = new Card(7, Suit.CLUBS);
      System.out.println(" sSeven of clubs:");
      System.out.println("Suit = " + card.getSuit().toString().toLowerCase());
      System.out.println("Rank = " + card.getRank());
      System.out.println("Hash = " + card.hashCode());
   }
}
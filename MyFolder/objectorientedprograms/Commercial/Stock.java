package objectorientedprograms.Commercial;
import java.util.Scanner;


import java.util.Scanner;
public class Stock
{
	public static void main(String[] args) throws Exception 
	{		
		Scanner scanner = new Scanner(System.in);
		Utility utility = new Utility();
		StockMethods stock = new StockMethods();
		int choice;
		do
		{
			System.out.println("Enter your choice");
			System.out.println("Press 1 : To create account");
			System.out.println("Press 2 : Buy shares");
			System.out.println("Press 3 : Sell shres");
			System.out.println("Press 4 : Print report");
			
			choice = utility.inputInteger();			
			switch(choice)
			{
				case 1 : 
					stock.addDetails();
					break;
				case 2 : 
					stock.buyStock();
					break;
				case 3:
					stock.sellStock();
					break;
				case 4 : 
					stock.printReport();	
				default :
					break;			
			}
		}while(choice!=5);
	}
}

	
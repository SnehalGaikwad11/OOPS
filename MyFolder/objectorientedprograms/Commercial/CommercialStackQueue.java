package objectorientedprograms.Commercial;

import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

public class CommercialStackQueue 
{
	public static void main(String[] args)throws ParseException, IOException 
	{
		Scanner scanner = new Scanner(System.in);
		Utility utility = new Utility();
		CommercialStackMethods stock = new CommercialStackMethods();
		char ch;
		do
		{
			System.out.println("1. Add Details\n2. Buy\n3. Sell\n4. Print Report ");
			int choice = utility.inputInteger();			
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
					break;							
				default :
					System.out.println("Invalid Choice..!!!");
					break;			
			}
			System.out.println("Do you wants to continue...(Y/N)");
			ch = scanner.next().charAt(0);
		}while(ch=='Y' || ch == 'y');
	}
}
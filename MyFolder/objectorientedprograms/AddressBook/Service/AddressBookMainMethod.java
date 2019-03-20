package objectorientedprograms.AddressBook.Service;

import java.io.IOException;

public class AddressBookMainMethod {

public static void main(String[] args) throws IOException {
		try {
			
			AddressBookManagerFunction addressBookManger=new AddressBookManagerFunction();
			
			int choice=display();
		outer:	while(choice<=4) {
				switch (choice) {
				case 1:	addressBookManger.newAddressBook();
					    break;
				case 2:	System.out.println("Enter the name of the Address Book ");
		 				String inputAddressBookName=Utility.getString();
		 				addressBookManger.open(inputAddressBookName);
		 				break;
				case 3:	addressBookManger.close();
			    		break;
				case 4:	addressBookManger.quit();
	    		break outer;
				
				default:System.out.println("InValid Choice");
						break ;
				}
				choice=display();
			}
		
		}catch (Exception e) {
			System.out.println("Somthing Went wrong...");
			e.printStackTrace();
		}
	}
	public static int display() {
		System.out.println("--------------------Address Books-----------------------");
		System.out.println();
		System.out.println("1 . To Create a new Address Book set -1");
		System.out.println("2 . To Open Address Book set - 2");
		System.out.println("3 . To Close the Address Book set - 3");
		System.out.println("4 . To Quit the Address Book set - 4");
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.println("Enter choice ");
		int choice=Utility.getInt();
		return choice;
	}
	
}










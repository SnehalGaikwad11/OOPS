package objectorientedprograms.AddressBook.Service;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import  objectorientedprograms.AddressBook.Model.AddressBook;
import objectorientedprograms.AddressBook.Model.AddressBookManager;
import  objectorientedprograms.AddressBook.Model.Person;


public class AddressBookManagerFunction implements AddressBookManagerInterface {
	ObjectMapper mapper=new ObjectMapper();
	//File file=new File("/home/admin1/Downloads/java-master/jsonAddressBookManager.json");
	AddressBookManager addressManager = new AddressBookManager();
	AddressBooks addressBooks=new AddressBooks();
	/*
	 * Constructor class of Address Book Manager
	 */
	public AddressBookManagerFunction () throws IOException {
		//addressManager=mapper.readValue(file, AddressBookManager.class);
		
	}
	/*
	 * creating new address book(non-Javadoc)
	 * @see com.labz.addressbook.service.AddressManagerInterface#newAddressBook()
	 */

	public void newAddressBook()throws IOException  {
		
		AddressBook addressBook=new AddressBook();
		List<AddressBook>addressbooks=addressManager.getAddressBookList();
 		System.out.println("Enter the name of the Address Book ");
 		String inputAddressBookName=Utility.getString();
 		//boolean flagAddressonBook=addressbooks.stream().filter(name->name.getName().equals(inputAddressBookName)).findFirst().isPresent();
 		
 		List<Person> personList=new ArrayList<Person>();
 		//if(!flagAddressonBook) {
 			addressBook=new AddressBook();
 			addressBook.setName(inputAddressBookName);
 			
	 		Person person=addressBooks.addPerson();
			personList.add(person);
			addressBook.setPersonList(personList);
			
			addressbooks.add(addressBook);
			addressManager.setAddressBookList(addressbooks);
//		}else {
//			System.out.println("Address Book Already Exists");
//		}
		save();
		
	}
/*
 * opening the addre Book in Address Book manager(non-Javadoc)
 * @see com.labz.addressbook.service.AddressManagerInterface#open(java.lang.String)
 */
	
	public void open(String addBkName)throws IOException   {
		List<AddressBook>addressbooks=addressManager.getAddressBookList();
		System.out.println(addressbooks.get(0));
		boolean flagAddressonBook=addressbooks.stream().filter(name->name.getName().equals(addBkName)).findFirst().isPresent();
 		// personList=new ArrayList<Person>();
 		if(flagAddressonBook) {
 			System.out.println("Want to Add Person : y/n");
 			String s=Utility.getString();
 			s=s.toLowerCase();
 			if(s.equals("y")) {
 				AddressBook addressBook=addressbooks.stream().filter(name->name.getName().equals(addBkName)).findFirst().get();
 		 		List<Person>personList=addressBook.getPersonList();
 		 		Person person=addressBooks.addPerson();
 				personList.add(person);
 				
			}else {
				addressBkFunction();
				
			}
 			
 			save();
 			
				
 		}else {
 			System.out.println("Address Book not FOUND");
 		}
 		

	}
/*
 * to close the addressbook(non-Javadoc)
 * @see com.labz.addressbook.service.AddressManagerInterface#close()
 */
	
	public void close() {
		System.out.println("!!!!!....closed.....!!!!");

	}
/*
 * to save to the json file (non-Javadoc)
 * @see com.labz.addressbook.service.AddressManagerInterface#save()
 */

	public void save()throws IOException  {
		mapper.writeValue(new File("/home/admin1/Desktop/AddressBook/addressbook.json"), addressManager);
		
	}
/*
 * to  Write to a new file (non-Javadoc)
 * @see com.labz.addressbook.service.AddressManagerInterface#saveAs(java.lang.String)
 */

	public void saveAs(String aBKname)  {
		File fileSaveAs=new File("/home/admin1/Downloads/java-master/AddressBook.txt");
		List<AddressBook>addressbooks=addressManager.getAddressBookList();
		AddressBook addressBook=addressbooks.stream().filter(name->name.getName().equals(aBKname)).findFirst().get();
 		try(BufferedWriter bw=new BufferedWriter(new FileWriter(fileSaveAs, true))){
 			List<Person>personList=addressBook.getPersonList();
 			int count=0;
 			while (count<personList.size()) {
				Person person=personList.get(count);
				String newFile="Fist Name = "+person.getFirstName()+" Last Name = "+person.getLastName()+" Phone Number = "+person.getPhoneNumber();
				newFile=newFile+"State = "+person.getAddress().getState()+" City = "+person.getAddress().getCity()+" Zip = "+person.getAddress().getZip();
				newFile=newFile+"\n";
				bw.write(newFile);
				count++;
 			}
 			save();
 		 	
		}catch (Exception e) {
			System.out.println("......Not Saved...... ");
		}
	}


	public void quit() {
		System.out.println("Want to save to text File : y/n");
		String s=Utility.getString();
			s=s.toLowerCase();
			if(s.equals("y")) {
				System.out.println("Enter the name of the Address Book ");
 				String inputAddressBookName=Utility.getString();
				saveAs(inputAddressBookName);
				System.out.println("saves to addressBook");
			}else {
				System.out.println("Not saved as addressBook");
			}
		

	}
	public void addressBkFunction() throws IOException  {
		
		
		System.out.println("Want to Update Person set - 1");
		System.out.println("Want to delete Person set - 2");
		System.out.println("Want to Sort person by lastname set - 3");
		System.out.println("Want to Sort person by Zip of Address set - 4");
		System.out.println("Want to print Hit - 5");
		System.out.println("want to Exit - 6 ");
		int choice=Utility.getInt();
		
		switch (choice) {
				
		case 1: System.out.println("Enter Last Name of person");
		 		String lastName=Utility.getString();
		 		addressManager=addressBooks.editInfo(lastName);
		 		save();
		 		break;
		case 2: System.out.println("Enter Last Name of person");
 				String lasTname=Utility.getString();	
 				addressManager=addressBooks.deletePerson(lasTname);
 				save();
				break;
		case 3:	addressBooks.sortByZip();
				break;
		case 4:	addressBooks.sortByName();
		break;
		case 5:	addressBooks.Print();
		break;
				
		default:System.out.println("Invalid Choice");
				break;
		}
		
	}



}
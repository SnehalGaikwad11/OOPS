package objectorientedprograms.AddressBook.Service;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import org.codehaus.jackson.map.ObjectMapper;

import  objectorientedprograms.AddressBook.Model.Address;
import  objectorientedprograms.AddressBook.Model.AddressBook;
import  objectorientedprograms.AddressBook.Model.AddressBookManager;
import  objectorientedprograms.AddressBook.Model.Person;

public class AddressBooks implements AddressNote {
	//File file=new File("/home/admin1/Downloads/java-master/AddressBookManager.json");
	ObjectMapper objectMapper=new ObjectMapper();
	AddressBookManager addressManager;
	public AddressBooks()throws IOException {
		//addressManager=objectMapper.readValue(file, AddressBookManager.class);
	}
	/*
	 * To perform add Function for person
	 * @return Person Object
	 */
	
	
	@Override
	public Person addPerson()
	{
		Person person=new Person();
		System.out.println("Add Person");
		System.out.println("Enter First Name ");
		String firstName=Utility.getString();
		//For incorrect input
		while(firstName.length()>50) {
			System.out.println("Fisrt Name is too long");
			System.out.println("Enter First Name ");
			firstName=Utility.getString();
		}
		person.setFirstName(firstName);
		
		System.out.println("Enter Last Name");
		String lastName=Utility.getString();
		//For incorrect input
		while(lastName.length()>50) {
			System.out.println("Last Name is too long");
			System.out.println("Enter Last Name");
			lastName=Utility.getString();
		}
		person.setLastName(lastName);
		
		//Creating Address object
		Address address=addAddress();
		person.setAddress(address);
		
		System.out.println("Enter Phone Number");
		String phoneNumber=Utility.getString();
		if(phoneNumber.length()==10||phoneNumber.length()==12) {
		 person.setPhoneNumber(phoneNumber);
		}else {
			System.out.println("Incorrect Phone Number");
			System.out.println("Enter Phone Number");
			phoneNumber=Utility.getString();
		}
		return person;	
	}
	/*
	 * To perform add Function for address
	 * @return Address Object
	 */
	private Address addAddress() {
		Address address=new Address();
		System.out.println("Add Address ");
		System.out.println("Enter State ");
		String state=Utility.getString();
		//For incorrect input
		while(state.length()>50) {
			System.out.println("State length is too long");
			System.out.println("Enter State ");
			state=Utility.getString();
		}
		address.setState(state);
		System.out.println("Enter City");
		String city=Utility.getString();
		//For incorrect input
		while(city.length()>50) {
			System.out.println("City name is too long");
			System.out.println("Enter City");
			city=Utility.getString();
		}
		address.setCity(city);
		System.out.println("Enter Zip ");
		String zip=Utility.getString();
		//For incorrect input
		while(zip.length()!=6) {
			System.out.println("Zip should be 0f 6 Characters");
			System.out.println("Enter Zip ");
			zip=Utility.getString();
		}
		address.setZip(zip);
		return address;
	}

	
	public AddressBookManager  editInfo(String lastName)  {
	
		List<AddressBook> addressBooks = addressManager.getAddressBookList();
		AddressBook addressBook=addressBooks.stream().filter(prsn->prsn.getPersonList().stream().filter(name->name.getLastName().equals(lastName)).findAny().isPresent()).findFirst().get();
		Person person=addressBook.getPersonList().stream().filter(name->name.getLastName().equals(lastName)).findFirst().get();
		System.out.println(person);
		System.out.println("Any Change In  Name hit 1 ");
		System.out.println("Any Change in Address hit 2");
		System.out.println("Any Change in Phone Number hit 3");
		int choice=Utility.getInt();
		switch (choice) {
		case 1: System.out.println("First Name - "+person.getFirstName());
				System.out.println("Last Name - "+person.getLastName());
				System.out.println();
				System.out.println("Enter First Name ");
				String firstName=Utility.getString();
				person.setFirstName(firstName);
				
				System.out.println("Enter Last Name ");
				String lasTname=Utility.getString();
				person.setLastName(lasTname);
				break;
		case 2: System.out.println("State - "+person.getAddress().getState());
				System.out.println("City - "+person.getAddress().getCity());
				System.out.println("Zip - "+person.getAddress().getZip());
				System.out.println("Enter State ");
				String state=Utility.getString();
				person.getAddress().setState(state);
				
				System.out.println("Enter City");
				String city=Utility.getString();
				person.getAddress().setCity(city);
				
				System.out.println("Enter Zip ");
				String zip=Utility.getString();
				person.getAddress().setZip(zip);
				break;
		case 3: System.out.println("Phone Number - "+person.getPhoneNumber());
				System.out.println("Enter Phone Number");
				String phoneNumber=Utility.getString();
				person.setPhoneNumber(phoneNumber);
				break;
		default:System.out.println("Invalid Choice");
				break;
		}
		return addressManager;
		
		
		
	}

	
	public AddressBookManager deletePerson(String lastName){
		List<AddressBook> addressBooks=addressManager.getAddressBookList();
		AddressBook addressBook=addressBooks.stream().filter(prsn->prsn.getPersonList().stream().filter(name->name.getLastName().equals(lastName)).findAny().isPresent()).findFirst().get();
		addressBook.getPersonList().removeIf(psn->psn.getLastName().equals(lastName));
		return addressManager;
	}

	
	
	@Override
	public void sortByName() {
		List<AddressBook> addressBooks=addressManager.getAddressBookList();
		for(AddressBook addressBook:addressBooks) {
			List<Person> persons=addressBook.getPersonList();
			TreeSet<Person> personSet=new TreeSet<Person>();
			for (Person person : persons) {
				personSet.add(person);
			}
		
			System.out.println("Address Book Name : "+addressBook.getName());
			System.out.println("-------------------------------------------------");
			for (Person person : personSet) {
				System.out.println("lat name : "+person.lastName);
			}
			System.out.println("------------------------------------------");
			
		}
		
		
	}

	
	
	@Override
	public void sortByZip() {
		SortByZip sortZip=new SortByZip();
		List<AddressBook> addressBooks=addressManager.getAddressBookList();
		for(AddressBook addressBook:addressBooks) {
			List<Person> persons=addressBook.getPersonList();
			TreeSet<Person> personSet=new TreeSet<Person>(sortZip);
			for (Person person : persons) {
				personSet.add(person);
			}
			System.out.println("Address Book Name : "+addressBook.getName());
			System.out.println("-------------------------------------------------");
			for (Person person : personSet) {
				
					
					System.out.println("lat name : "+person.lastName+" Zip : "+person.getAddress().getZip());
					
				
			}
			System.out.println("------------------------------------------");
		}

	}

	
	public void Print()  {
		List<AddressBook> addressBooks=addressManager.getAddressBookList();
		for(AddressBook addressBook:addressBooks) {
			System.out.println("..........................................................");
			System.out.println("Address Book Name - "+addressBook.getName());
			for(Person person:addressBook.getPersonList()) {
				System.out.println("..........................................................");

				System.out.println("First Name - "+person.getFirstName());
				System.out.println("Last Name - "+person.getLastName());
				System.out.println("State - "+person.getAddress().getState());
				System.out.println("City - "+person.getAddress().getCity());
				System.out.println("Zip - "+person.getAddress().getZip());
				System.out.println("Phone Number - "+person.getPhoneNumber());
				System.out.println("..........................................................");

			}
		}
	}


	

	


	
		
	
	

	
	
	

}
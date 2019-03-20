package objectorientedprograms.AddressBook.Service;

import  objectorientedprograms.AddressBook.Model.AddressBookManager;
import  objectorientedprograms.AddressBook.Model.Person;

public interface AddressNote {
	public Person addPerson() ;
	public AddressBookManager editInfo(String lastName) ;
	public AddressBookManager deletePerson(String lastName) ;
	public void sortByName() ;
	public void sortByZip()  ;
	public void Print() ;
	
	

}
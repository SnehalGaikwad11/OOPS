package objectorientedprograms.AddressBook.Service;

import java.io.IOException;

import objectorientedprograms.AddressBook.Model.Address;
import  objectorientedprograms.AddressBook.Model.Person;


public interface AddressBookManagerInterface {
	public void newAddressBook() throws IOException ;
	public  void open(String addBkName)throws IOException ;
	public void close();
	public void save()throws IOException  ;
	public void saveAs(String name) ;
	public void quit();
	
}
package objectorientedprograms.AddressBook.Model;

import java.util.ArrayList;
import java.util.List;

public class AddressBookManager {
	List<AddressBook> addressBookList=new ArrayList<AddressBook>();

	public List<AddressBook> getAddressBookList() {
		return addressBookList;
	}

	public void setAddressBookList(List<AddressBook> addressBookList) {
		this.addressBookList = addressBookList;
	}
}
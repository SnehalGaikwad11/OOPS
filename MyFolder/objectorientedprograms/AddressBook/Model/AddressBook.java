package objectorientedprograms.AddressBook.Model;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private String name;
	List<Person> personList=new ArrayList<Person>();

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
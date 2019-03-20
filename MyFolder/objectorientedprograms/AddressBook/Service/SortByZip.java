package objectorientedprograms.AddressBook.Service;
import java.util.Comparator;
import  objectorientedprograms.AddressBook.Model.Person;


public class SortByZip implements Comparator<Person> {
	@Override
	public int compare(Person person1, Person person2) {
		// TODO Auto-generated method stub
		int p1=Integer.parseInt(person1.getAddress().getZip());
		int p2=Integer.parseInt(person2.getAddress().getZip());
		return (p1-p2);
	}

}








	
	


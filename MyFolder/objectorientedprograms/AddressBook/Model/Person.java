package objectorientedprograms.AddressBook.Model;

public class Person implements Comparable<Person>{
	
	public String firstName;
	public String lastName;
	private Address address;
	private String phoneNumber;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public int compareTo(Person o) {
		return this.lastName.compareTo(o.lastName);
		
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
}
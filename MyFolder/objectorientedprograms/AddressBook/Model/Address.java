package objectorientedprograms.AddressBook.Model;

public class Address implements Comparable<Address>{
	private String state;
	private String city;
	private String zip;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() { 
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public int compareTo(Address o) {
		return this.zip.compareTo(o.zip);
	}

}
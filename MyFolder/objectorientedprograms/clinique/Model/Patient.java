package objectorientedprograms.clinique.Model;

public class Patient implements Comparable<Patient> {
     @Override
	public String toString() {
		return "Patient [count=" + count + ", id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", age="
				+ age + "]";
	}
     private int count;
 	private int id;
 	private String name;
 	private String phonenumber;
 	private int age;
 	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public  Patient()
	{
		count++;
		this.id=count;
	}
	 public int compareTo(Patient d)
	 {
	 return(this.id-d.id);	  
	 }

}

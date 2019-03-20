package objectorientedprograms.clinique.Model;

public class Doctor implements Comparable<Doctor> {
	private  int id;
	private String name;
	private String Specialization;
	private String Avaliability;
	private int number_of_patients;
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public String getAvaliability() {
		return Avaliability;
	}
	public void setAvaliability(String avaliability) {
		Avaliability = avaliability;
	}
	public int getNumber_of_patients() {
		return number_of_patients;
	}
	public void setNumber_of_patients(int number_of_patients) {
		this.number_of_patients = number_of_patients;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", Specialization=" + Specialization + ", Avaliability=" + Avaliability
				+ ", number_of_patients=" + number_of_patients + "]";
	}
	@Override
   public int compareTo(Doctor d)
   {
	   return(this.id-d.id);
   }

}

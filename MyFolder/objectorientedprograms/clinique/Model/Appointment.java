package objectorientedprograms.clinique.Model;

import java.util.List;

public class Appointment {
	private String date;
	private String doctorName;
	private int id;

@Override
public String toString() {
	return "Appointment [doctorName=" + doctorName + ", id=" + id + ", patients=" + patients + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private List<Patient> patients;

public String getDate() {
	return date;
}
public void setDate(String date) {
	 
	this.date =  date;
}
public Appointment() {
	
}

public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public List<Patient> getPatients() {
	return patients;
}
public void setPatients(List<Patient> patients) {
	this.patients = patients;
}

}
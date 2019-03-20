package objectorientedprograms.clinique.Model;

import java.util.List;

public class Appointments {
	List<Appointment> appointments;

	@Override
	public String toString() {
		return "Appointments [appointments=" + appointments + "]";
	}
	public List<Appointment> getappointments(){
	    return appointments;
	
	}
	
	public void setappointments(List<Appointment> appointments) {
		this.appointments=appointments;
	}
}

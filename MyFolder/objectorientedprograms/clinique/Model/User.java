package objectorientedprograms.clinique.Model;

import java.util.List;

public class User {
	List<Doctor> doctors;
    List<Patient> patients;
    public List<Doctor> getdoctors()
    {
    return doctors;
    }
  public void setdoctors(List<Doctor>doctors)
  {
	  this.doctors=doctors;
  }
  public List<Patient> getpatients()
  {
	  return patients;
  }
  public void setpatients(List<Patient>patients)
  {
	  this.patients=patients;
  }


}





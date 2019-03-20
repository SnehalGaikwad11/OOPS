package objectorientedprograms.clinique.Service;

import objectorientedprograms.clinique.Model.Doctor;
import objectorientedprograms.clinique.Model.Patient;

public interface CliniqueInterface {
	public Doctor addDoctor();
	public Patient addPatient();
	public Doctor serachDoctorById(int id) throws	Throwable;
	public Doctor searchDoctorByName (String name) throws Throwable;
	public Doctor searchDoctorBySpecialization(String specialization) throws Throwable;
	public Doctor searchDoctorByAvailability(String availability) throws Throwable;
    public Patient searchPatientById(int id) throws Throwable;
    public Patient searchPatientByName(String name) throws Throwable;
    public Patient searchPatientByPhonenumber(String phonenumber) throws Throwable;
    public void appointment(Doctor doc,Patient pat)throws Throwable;
}

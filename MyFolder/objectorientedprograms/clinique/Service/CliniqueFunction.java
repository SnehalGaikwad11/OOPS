package objectorientedprograms.clinique.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import objectorientedprograms.JsonUtil;
import objectorientedprograms.clinique.Model.Appointment;
import objectorientedprograms.clinique.Model.Appointments;
import objectorientedprograms.clinique.Model.Doctor;
import objectorientedprograms.clinique.Model.Patient;
import objectorientedprograms.clinique.Model.User;

public class CliniqueFunction implements CliniqueInterface {
//File userfile,appointmentFile=new File("/home/admin1/Downloads/java-master/CliniqueAppointment.json");
static ObjectMapper mapper=new ObjectMapper();
static User user;
static Appointments appointments;
static List<Appointment>appoinmentList;	
static Appointment appointment;
static List<Patient> patients;
public CliniqueFunction(File file) throws IOException{
	Appointments appoinments = new Appointments();
	
	//appointments=mapper.readValue(appointmentFile,Appointments.class);
	//ppoinmentList=appointments.getappointments();
	appointment=new Appointment();
	patients=new ArrayList<Patient>();
}
String morning="9Am-12Pm";
String afternoon="12Pm-4Pm";	
String evening="4Pm-9Pm";

public void  displayavailability()
{
	System.out.println("Select the Availability from"+morning+"+set  -->1");
	System.out.println("Select the Availability from"+afternoon+"+set -->2");
	System.out.println("Select the Availablility from"+evening+"+set  -->3");
}
	
	@Override
	public Doctor addDoctor() {
		Doctor doctor=new Doctor();
		System.out.println("Enter the Id for the doctor:");
		int doctorId=JsonUtil.inputInteger();
		//boolean flagId=user.getdoctors().stream().filter(id->id.getId()==doctorId).findFirst().isPresent();
		//if(!flagId)
		{
			doctor.setId(doctorId);
			System.out.println("Enter the name of the doctor:");
			String doctorName=JsonUtil.inputSingleString();
			doctor.setName(doctorName);
			System.out.println("Enter the Specialization: ");
			String doctorspacilaization=JsonUtil.inputSingleString();
			doctor.setSpecialization(doctorspacilaization);
			displayavailability();
			int choice=JsonUtil.inputInteger();
			switch(choice)
			{
			case 1:doctor.setAvaliability(morning);
			       break;
			case 2:doctor.setAvaliability(afternoon);
			        break;
			case 3:doctor.setAvaliability(evening);
			       break;
			default:System.out.println("Invalid Choice........!!!!!");
			}
			
			
		}
//		else
//		{
//			System.out.println("Duplicate Id....!!!!!");
//		}
		
		return doctor;
	}

	@Override
	public Patient addPatient() {
		Patient patient=new Patient();
		System.out.println("Enter the Id for the patient:");
		int patientId=JsonUtil.inputInteger();
		//boolean flagId=user.getpatients().stream().filter(id->id.getId()==patientId).findFirst().isPresent();
		//if(!flagId)
		{
			patient.setId(patientId);
			System.out.println("Enter the name of the patient:");
			String patientName=JsonUtil.inputSingleString();
			patient.setName(patientName);
			System.out.println("Enter the age:");
			int patientAge=JsonUtil.inputInteger();
			patient.setAge(patientAge);
			System.out.println("Enter the phone number:");
			String patientphoneNumber=JsonUtil.inputSingleString();
			patient.setPhonenumber(patientphoneNumber);
			while(!(patientphoneNumber.length()==10||patientphoneNumber.length()==12))
					{
				System.out.println("Invalid Entry...!!!!");
				patientphoneNumber=JsonUtil.inputSingleString();
					}
			patient.setPhonenumber(patientphoneNumber);
	}
			//else
//		{
//			System.out.println("Dublicate Id........!!!!!");
//		}
		
		return patient;
	}

	@Override
	public Doctor serachDoctorById(int id) throws Throwable {
		List<Doctor> doctorList=user.getdoctors();
		Doctor doctor;
		doctor=doctorList.stream().filter(doc->doc.getId()==id).findFirst().orElseThrow(()->new Exception("Doctor not found by Id...!!!"));
				
		
		return doctor;
	}

	@Override
	public Doctor searchDoctorByName(String name) throws Throwable {
		List<Doctor>doctorList=user.getdoctors();
		Doctor doctor;
		doctor=doctorList.stream().filter(doc->doc.getName().equals(name)).findFirst().orElseThrow(()->new Exception("Doctor not found by Name....!!!!"));
		
	
		return doctor;
	}

	@Override
	public Doctor searchDoctorBySpecialization(String specialization) throws Throwable {
		
		List<Doctor>doctorList=user.getdoctors();
		Doctor doctor;
		doctor=doctorList.stream().filter(doc->doc.getSpecialization().equals(specialization)).findFirst().orElseThrow(()->new Exception("Doctor not found by Specialization....!!!!"));
		
	
		return doctor;
		
	}

	@Override
	public Doctor searchDoctorByAvailability(String availability) throws Throwable {
		
		List<Doctor>doctorList=new ArrayList<Doctor>();//user.getdoctors();
		Doctor doctor = null;
		//doctor=doctorList.stream().filter(doc->doc.getAvaliability().equals(availability)).findFirst().orElseThrow(()->new Exception("Doctor not found by Avaliability....!!!!"));
		
	
		return doctor;
	
		
	}

	@Override
	public Patient searchPatientById(int id) throws Throwable {
		List<Patient> patientList=user.getpatients();
		Patient patient;
		patient=patientList.stream().filter(pat->pat.getId()==id).findFirst().orElseThrow(()->new Exception("Patient not found by Id....!!!!!"));
		
		return patient;
	}

	@Override
	public Patient searchPatientByName(String name) throws Throwable {
		List<Patient>patientList=user.getpatients();
		Patient patient;
		patient=patientList.stream().filter(pat->pat.getName().equals(name)).findFirst().orElseThrow(()->new Exception("Patient not found by Name....!!!!"));
		
	
		return patient;
		
	}

	@Override
	public Patient searchPatientByPhonenumber(String phonenumber) throws Throwable {
		
		List<Patient>patientList=user.getpatients();
		Patient patient;
		patient=patientList.stream().filter(pat->pat.getPhonenumber().equals(phonenumber)).findFirst().orElseThrow(()->new Exception("Patient not found by phoneNumber....!!!!"));
		
	
		return patient;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void appointment(Doctor doc, Patient pat) throws Throwable {
		Date date=new Date();
		appointment.setDate(LocalDate.of(date.getYear(), date.getMonth(), date.getDate()).toString());
		//boolean flagDoctor=appoinmentList.stream().filter(doctr->doctr.getId()==doc.getId()).findFirst().isPresent();
		
		
		//if(flagDoctor)
		{
			int num=doc.getNumber_of_patients();
			if(num>5)
			{
				if(num==6||num==11)
				{
					newAppointment(doc,pat);
				}
				else
				{
					appointment=appoinmentList.stream().filter(dat->dat.getDate().equals(LocalDate.of(date.getYear()+1900,date.getMonth()+1,date.getDate()+1).toString())).findFirst().get();
					patients=appointment.getPatients();
					patients.add(pat);
					appointment.setPatients(patients);
					appointments.setappointments(appoinmentList);
					
				}
			}else {
				toPresentAppointment(doc,pat);
			}
		}
//		}else
//			
//			{
//			newAppointment(doc,pat);
//				
//			}
//			mapper.writeValue(new File("/home/admin1/Desktop/CliniqueManagemnet/clique.json"
//					+ ""), appointment);
		}
	public void toPresentAppointment(Doctor doc,Patient pat)
	{
		//appointment=appoinmentList.stream().filter(doctr->doctr.getId()==doc.getId()).findFirst().get();
	    patients=appointment.getPatients();
	    //patients.add(pat);
	    appointment.setPatients(patients);
	    appointments.setappointments(appoinmentList);
	
	}
	public void newAppointment(Doctor doc,Patient pat)
	{
		appointment.setDoctorName(doc.getName());
		appointment.setId(doc.getId());
		patients.add(pat);
		appointment.setPatients(patients);
		appoinmentList.add(appointment);
		appointments.setappointments(appoinmentList);
	}
	
	
	
		
	}



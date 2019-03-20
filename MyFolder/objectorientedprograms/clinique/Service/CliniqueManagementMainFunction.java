package objectorientedprograms.clinique.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import objectorientedprograms.JsonUtil;
import objectorientedprograms.clinique.Model.Doctor;
import objectorientedprograms.clinique.Model.Patient;
import objectorientedprograms.clinique.Model.User;

public class CliniqueManagementMainFunction {
	static ObjectMapper mapper=new ObjectMapper();
	//static User user;
	static CliniqueFunction clinique;
	//static File file=new File("/home/admin1/Downloads/java-master/CliniqueManagement.json");
	static Doctor doctor;
	static Patient patient;
	static Doctor appointdoc;
	static Patient appointpat;
	//	appointdoc=new Doctor();
	//	appointpat=new Patient();
	static User  user = new User();

	public static void main(String args[]) throws Throwable {

		//clinique=new CliniqueFunction(file);
		try {
			CliniqueFunction clinique = new CliniqueFunction(null);
			List<Doctor> doctorList=new ArrayList<Doctor>();
			List<Patient> patientList=new ArrayList<Patient>();
			String doctorNumPatient=null;
			int choice;
			choice=display();
			while(choice<=3)
			{
				switch(choice)
				{
				case 1: 

					doctor=clinique.addDoctor();
					//doctorList= user.getdoctors();
					doctorList.add(doctor);
					user.setdoctors(doctorList);
					save();
					break;
				case 2:
					patient=clinique.addPatient();
					//patientList=user.getpatients();
					patientList.add(patient);
					user.setpatients(patientList);
					save();
					break;
				case 3: int appointChoice=callAppointment();
				while(appointChoice<=3)
				{
					witch:switch(appointChoice)
					{
					case 1: int c=searchDoctor();
					mich:switch(c) {
					case 1: System.out.println("Enter Doctors Id:");
					int id=JsonUtil.inputInteger();
					//doctorList=user.getdoctors();
					//Doctor doctr=clinique.serachDoctorById(id);
					//doctor=doctorList.stream().filter(doc->doc.getId()==doctr.getId()).findFirst().get();
					System.out.println("Wants to add patients: Y/N");
					doctorNumPatient=JsonUtil.inputSingleString();
					doctorNumPatient.toLowerCase();
					if(doctorNumPatient.equals("Y")) {
						int num=doctor.getNumber_of_patients();
						doctor.setNumber_of_patients(num++);
					}
					save();
					break mich;
					case 2: System.out.println("Enter Doctors Name: ");
					String name=JsonUtil.inputSingleString();
					//doctorList=user.getdoctors();
					//Doctor doc=clinique.searchDoctorByName(name);
					//doctor=doctorList.stream().filter(nme->nme.getName().equals(doc.getName())).findFirst().get();
					System.out.println("Wants to add Patients: Y/N");
					doctorNumPatient=JsonUtil.inputSingleString();
					doctorNumPatient.toLowerCase();
					if(doctorNumPatient.equals("Y")) {
						int num=doctor.getNumber_of_patients();
						doctor.setNumber_of_patients(++num);
					}
					save();
					break mich;
					case 3: System.out.println("Enter Doctors Specialization:");
					String specialization=JsonUtil.inputSingleString();
					//doctorList=user.getdoctors();
					//Doctor doc1=clinique.searchDoctorBySpecialization(specialization);
					//doctor=doctorList.stream().filter(spe->spe.getSpecialization().equals(doc1.getSpecialization())).findFirst().get();
					System.out.println("Wants to add Patients: Y/N");
					doctorNumPatient=JsonUtil.inputSingleString();
					doctorNumPatient.toLowerCase();
					if(doctorNumPatient.equals("Y")) {
						int num=doctor.getNumber_of_patients();
						doctor.setNumber_of_patients(++num);
					}
					save();
					break mich;
					case 4: clinique.displayavailability();
					int  set=JsonUtil.inputInteger();
					//doctorList=user.getdoctors();
					switch(set)
					{
					case 1: Doctor doctrclinique=clinique.searchDoctorByAvailability(clinique.morning);
					//doctor=doctorList.stream().filter(availbility->availbility.getAvaliability().equals(doctrclinique.getAvaliability())).findFirst().get();
					break;
					case 2: Doctor doctrclinique1=clinique.searchDoctorByAvailability(clinique.afternoon);
					//doctor=doctorList.stream().filter(availbility->availbility.getAvaliability().equals(doctrclinique1.getAvaliability())).findFirst().get();
					break;

					case 3: Doctor doctrclinique2=clinique.searchDoctorByAvailability(clinique.evening);
					//doctor=doctorList.stream().filter(availbility->availbility.getAvaliability().equals(doctrclinique2.getAvaliability())).findFirst().get();
					break;      
					default:   break mich;

					}
					System.out.println("Want to add patients: Y/N");
					doctorNumPatient=JsonUtil.inputSingleString();
					doctorNumPatient.toLowerCase();
					if(doctorNumPatient.equals("Y")) {
						int num=doctor.getNumber_of_patients();
						if(num<5) {
							doctor.setNumber_of_patients(num+1);
							System.out.println("confirmed appoinment!!");

						}
					}
					save();
					break witch;
					default: System.out.println("Invalid Input for Doctor search.....!!!!!!");
					break witch;
					}
					appointdoc=doctor;
					System.out.println(appointdoc.toString());
					save();
					break;
					case 2: int p=searchPatient();
					switch(p) {
					case 1: System.out.println("Enter the patient Id:");
					int id=JsonUtil.inputInteger();
					//patient=clinique.searchPatientById(id);
					break;
					case 2: System.out.println("Enter the Name Of Patient:");
					String name=JsonUtil.inputSingleString();
					//patient=clinique.searchPatientByName(name);
					break;
					case 3: System.out.println("Enter the Phone Number Of Patient:");
					String phoneNumber=JsonUtil.inputSingleString();
					//patient=clinique.searchPatientByPhonenumber(phoneNumber);
					break;
					default: System.out.println("Invalid Input For Doctor Search:");
					break;
					}
					appointpat=patient;
					System.out.println(appointpat.toString());
					save();
					break;
					case 3:
						//clinique.appointment(appointdoc, appointpat);
					System.out.println("!!!!.....Confirm Appointment.....!!!!");
					break;
					default:
						break;
					}
				appointChoice=callAppointment();
				}
				default: System.out.println("Invalid Choice...");   
				break;
				}
				choice=display();
			}
		}catch(Exception e)
		{
			System.out.println("Invalid Input");
			e.printStackTrace();
		}
	}


	public static int display()
	{
		System.out.println("****************Clinique ManageMent****************************");
		System.out.println("Want to Add Doctor set ->1");
		System.out.println("Want to Add Patient set ->2");
		System.out.println("For Appointment  set-> 3");
		System.out.println("***************************************************************");
		int choice=JsonUtil.inputInteger();
		return choice;
	}

	public static void save() throws Throwable
	{
		mapper.writeValue(new File("/home/admin1/Desktop/CliniqueManagemnet/clinique.json"), user);
	}

	public static int searchDoctor()
	{
		System.out.println("*************************SEARCH DOCTOR**********************");
		System.out.println("Search Doctor By Id  set ->1");
		System.out.println("Search Doctor By Name set ->2");
		System.out.println("Search Doctor By Specialization set ->3");
		System.out.println("Search Doctor By Availbility set ->4");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		int choice=JsonUtil.inputInteger();
		return choice;
	}

	public static int searchPatient()
	{
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("Search Doctor By Id  set ->1");
		System.out.println("Search Doctor By Name set ->2");
		System.out.println("Search Doctor By Phone Number set ->3");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		int choice=JsonUtil.inputInteger();
		return choice;
	}

	public static int callAppointment()
	{
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("Want to Search for Doctor  set ->1");
		System.out.println(" Want to Search for Patient set ->2");
		System.out.println("Confirm Appointment set ->3");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		int choice=JsonUtil.inputInteger();
		return choice;
	}
}












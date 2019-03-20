package objectorientedprograms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import objectorientedprograms.JsonUtil;

/**@purpose: Read in the following message: Hello <<name>>, We have your full
 *            name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx.
 *            Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.
 *            Use Regex to replace name, full name, Mobile#, and Date with proper value.
 * @version:1.0
 * @author:Snehal Gaikwad.
 *@since:13/3/2019
 */



//class for Regular ExpressionDemo
public  class RegularExpressionDemonstration {

	public static void main(String[] args) {
		String name=null,fullName=null,date=null;
		String msg = "Hello <<name>>, We have your full\n" + 
				"name as <<full name>> in our system. your contact number is 91-XXXXXXXXXX.\n" +   //String for the Reading
				"Please,let us know in case of any clarification Thank you BridgeLabz XX/XX/XXXX.";
		
		//printing the details of user
		System.out.println("Enter user name:");
		name=JsonUtil.inputString();
		System.out.println("Enter full name:");
		fullName=JsonUtil.inputString();
		System.out.println("Enter Mobile:");      
		String mobileNo = JsonUtil.inputString();
		LocalDate Date = LocalDate.now();
		String date1=DateTimeFormatter.ofPattern("yyy/MM/dd").format(Date);
		System.out.println("Today's date is :"+date1);

		//Date date2=new Date(date);
		
		
		System.out.println("String Before replacement::");
		System.out.println(msg);
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*");
		
		if(JsonUtil.validateName(name)) {	
			msg=msg.replaceAll("<<name>>", name);
		}
		if(JsonUtil.validateFullName(fullName)) {
			msg=msg.replaceAll("<<full name>>", fullName);
		}if(JsonUtil.validatemobileNumber(mobileNo)) {
			msg=msg.replaceAll("XXXXXXXXXX", mobileNo);
		}if(JsonUtil.validateDate(date1)) {
			msg=msg.replaceAll("XX/XX/XXXX", date1);
		}

		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("String after replacement");
		System.out.println(msg);
}

}
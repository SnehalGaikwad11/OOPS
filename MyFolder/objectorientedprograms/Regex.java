package objectorientedprograms;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
public static void main(String[] args) 
	{

		Date d=new Date();
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		Regex r = new Regex();
		String msg=  "Hello <<name>>, We have your full\n" + 
				"name as <<full name>> in our system. your contact number is 91-XXXXXXXXXX.\n" +   //String for the Reading
				"Please,let us know in case of any clarification Thank you BridgeLabz XX/XX/XXXX.";
		String REGEX_NAME = "<<name>>";
		String REGEX_LASTNAME = "<<full name>> ";
		String REGEX_MOBILE_NO = "xxxxxxxxxx";
		String REGEX_DATE = "12/06/2016";
		System.out.println("String is: "+msg);

		String cDate=sdf.format(d);
		//System.out.println("str "+cDate);


		System.out.print("\nEnter First Name: ");
		String fName=sc.next();
		System.out.print("Enter Your Last Name: ");
		String flName=sc.next();
		System.out.print("Enter Your Contact Number: ");
		String cNumber=sc.next();

		Pattern pn = Pattern.compile(REGEX_NAME);
		Matcher mn = pn.matcher(msg); 
		msg=mn.replaceAll(fName);

		Pattern pl=Pattern.compile(REGEX_LASTNAME);
		Matcher ml=pl.matcher(msg);
		msg=ml.replaceAll(fName+" "+flName);

		Pattern pno=Pattern.compile(REGEX_MOBILE_NO);
		Matcher mno=pno.matcher(msg);
		msg=mno.replaceAll(cNumber);

		Pattern pd=Pattern.compile(REGEX_DATE);
		Matcher md=pd.matcher(msg);
		msg=md.replaceAll(sdf.format(d));
		System.out.println(msg);
		
		r.getFormatedDate(new Date());
		System.out.println(r.getFormatedDate(new Date()));
	}
	public String getFormatedDate(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		return sdf.format(date);
	}
}
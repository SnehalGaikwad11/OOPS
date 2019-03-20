package objectorientedprograms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;



public class JsonUtil {
	static Scanner sc = new Scanner(System.in);
	/**
	* Static Function to check for inputing integer. 
	*
	* @return integer of Scanner Type
	**/
	
	public static int inputInteger() {
		return(sc.nextInt());
	}
	
	/**
	* Static Function to check for inputing double. 
	*
	* @return double of Scanner Type
	**/
	
	public static double inputDouble() {
		return (sc.nextDouble());
	}
	
	/**
	* Static Function to check for inputing float 
	*
	* @return float of Scanner Type
	**/
	
	public static float inputFloat() {
		return(sc.nextFloat());
	}
	
	/**
	* Static Function to check for inputing long. 
	*
	* @return long of Scanner Type
	**/
	
	public static long inputLong() {
		return(sc.nextLong());
	}
	
	/**
	* Static Function to check for inputing String. 
	*
	* @return String of Scanner Type
	**/
	
	public static String inputString() {
		return sc.nextLine();
	}
	
	/**
	* Static Function to check for inputing Single String Word that doesn't contains any spaces. 
	*
	* @return double of Scanner Type
	**/
	
	public static String inputSingleString() {
		return(sc.next());
	}
	
	/**
	* Static Function to check for inputing boolean. 
	*
	* @return boolean of Scanner Type
	**/
	
	public static boolean inputBoolean() {
		return(sc.nextBoolean());
	}
	
	/**
	* Static Function to close the Scanner Object. 
	*
	**/
	public static void closeScanner() {
		sc.close();
	}
	
	/**
	* Purpose : Function to read data from a file 
	* @param filename : Passing file location as an argument
	* @return : data of file as a string 
	* @throws IOException
	*/
	
	public static String readFile(String filename) throws IOException{
		
		//Creating FileReader Object
		
		FileReader fileReader = new FileReader(filename);
		
		//Creating BufferedReader Object
		
		BufferedReader bufferedreader = new BufferedReader(fileReader);
		String line;
		
		//Creating StringBuilder Object
		
		StringBuilder sb = new StringBuilder();
		while ((line = bufferedreader.readLine()) != null){
			
			//Appending line by line 
			
			sb.append(line);
		}
		System.out.println(sb);
		
		//closing the FileReader object
		
		fileReader.close();
		
		//closing the BufferedReader object
		
		bufferedreader.close();
		
		//Returning the String 
		
		return sb.toString();
	}
	
	public static String readFromJsonFile(String path) throws IOException {
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String fullString = "";
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			fullString += line;
		}
		bufferedReader.close();
		return fullString;
	}
	
	public static void writeToJsonFile(String jsonString, String path) throws IOException {
		FileWriter fileWriter = new FileWriter(path);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(jsonString);
		bufferedWriter.close();
	}
	public static void writeToJsonFileWithOutOverWriting(String jsonString, String path) throws IOException {
		FileWriter fileWriter = new FileWriter(path,true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(jsonString);
		bufferedWriter.close();
	}
	
	public static void writeObjectJson(java.util.List lists , String path) throws JsonGenerationException, JsonMappingException, IOException {
		Object[] arr = lists.toArray();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(new File(path), arr);
	}

//	public static<T> void jsonObjectWriteLinkedList(CustomLinkedList<T> list,String path)throws JsonGenerationException, JsonMappingException, IOException 
//	{
//		//Object[] array=list.convertArray(list,list.size());
//		Object[] array=list.convertArray(list,list.size());
//		ObjectMapper objectmapper=new ObjectMapper();
//		objectmapper.writeValue(new File(path), array);
//	}
	
	/**@param: Regex expression validation
	 */

		public static  Scanner scanner=new Scanner(System.in);
		public static Pattern pattern=null;
		
		
		public static long inputLong1() {
			return (scanner.nextLong());
		}
		
		public static String inputString1() {
			return(scanner.nextLine());
		}
		public static boolean validateName(String txt) {
			
			//validation for Name

			String regx = "[a-zA-Z]+\\.?";
			 pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(txt);
			return matcher.find();

		}
         //validation for Mobile number
		public static boolean validatemobileNumber(String mobileNo) {
			String regex = "^[0-9]{10}$";
			 pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher((mobileNo));
			return matcher.find();

		}
        
		//validation for Full name
		public static boolean validateFullName(String fullName) {
			String regex = "^([a-zA-Z]{2,}\\s[a-zA-z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)";
			 pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(fullName);
			return matcher.find();

		}
		
		//validation for Date
		public static boolean validateDate(String Date1) {
			String regex = "\\d{4}/\\d{2}/\\d{2}";
			 pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(Date1);
			return matcher.find();

		}
			

	}
	



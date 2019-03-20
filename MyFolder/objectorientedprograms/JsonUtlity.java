package objectorientedprograms;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtlity {
	private static ObjectMapper mapper;


static
{
	mapper=new  ObjectMapper();
}
public static String convertJavaToJason(Object object)
{
	String jsonResult="";
	try {
		jsonResult= mapper.writeValueAsString(object);
	} catch (JsonGenerationException e) {
		System.out.println("Exception occureed while converting Java Object into Json-->" +e.getMessage());
	}
	catch (JsonMappingException e) {
		System.out.println("Exception occureed while converting Java Object into Json-->" +e.getMessage());
	
     }
	catch (IOException e) {
		System.out.println("Exception occureed while converting Java Object into Json-->" +e.getMessage());
		}
	
	return jsonResult;
}
public static <T> T convertJsonTojava (String jsonString, Class<T> cls)
{
	
	 T result= null;
	 try {
		result=mapper.readValue(jsonString, cls);
	} catch (JsonParseException e)
	 {
	System.out.println("Exception occured while converting Json into Java"+e.getMessage());
	} catch (JsonMappingException e)
	 {
		System.out.println("Exception occured while converting Json into Java"+e.getMessage());
	} 
	 catch (IOException e) 
	 {
		 System.out.println("Exception occured while converting Json into Java"+e.getMessage());
	}
	return result;
	
}


	





}

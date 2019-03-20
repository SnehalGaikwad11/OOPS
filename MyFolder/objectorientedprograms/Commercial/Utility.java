package objectorientedprograms.Commercial;

import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class Utility
{
	
		Scanner scanner = new Scanner(System.in);
		public String inputString() {
			return scanner.next();
		}
		public Integer inputInteger() {
			return scanner.nextInt();
		}
		public void stockDetails()
		{
			JSONParser parser = new JSONParser();
			try
			{
				JSONObject obj = (JSONObject) parser.parse(new FileReader("stock.json"));
				JSONObject jsonObject = (JSONObject) obj;
				JSONArray jsonArr = (JSONArray)jsonObject.get("Stock");
				
				long totalValue=0;
				long total=0;
				
				System.out.println("\n------------------Stock Details----------------------\n");
				System.out.println("Stock Name\tNo Of Shares\tShare Price\tTotal Value Of Stock");
				for(int i=0;i<jsonArr.size();i++) 
				{
					//calculating each stock price
				   JSONObject simple =(JSONObject) jsonArr.get(i);
				   total=(long)simple.get("No of share")*(long)simple.get("Share price");
				   System.out.println(simple.get("Stock Name")+"\t\t"+simple.get("No of share")+"\t\t"+simple.get("Share price")+"\t\t"+total);
				   totalValue=totalValue+total;
				}
				System.out.println("\nTotal value is:- "+totalValue);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	
		
}
package objectorientedprograms;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import objectorientedprograms.Pulses;
import objectorientedprograms.Rice;
import objectorientedprograms.Wheat;

/**@purpose: Create a JSON file having Inventory Details for Rice, Pulses and Wheats
 *            with properties name, weight, price per kg. 

 * @version:1.0
 * @author:Snehal Gaikwad.
 *@since:13/3/2019
 */

public class  JsonInventory implements  Serializable
{

	public static void main(String[] args) throws JsonParseException,JsonMappingException,IOException
	{
		String filename="Rice";
		String filename1="Wheat";
		String filename2="Pulses";
		
		String filepath="Ricewrite.json";
		String filePath1="Wheatwrite.json";
		String filePath2="Pulseswrite.json";
		
		File file=new File(filepath);
		File file1=new File(filePath1);
		File file2=new File(filePath2);
		
		String writeRicePath=("/home/admin1/Desktop/bridgelab/Rice.json");
		String writeWheatPath=("/home/admin1/Desktop/bridgelab/Wheat.json");
		String writePulsesPath=("/home/admin1/Desktop/bridgelab/Pulses.json");
		
		ObjectMapper ObjectMapper=new ObjectMapper();
		List<Rice> riceList=ObjectMapper.readValue(file, new TypeReference <List<Rice>>() {});
		for(int i=0;i<riceList.size();i++)
		{
			System.out.println("Name:"+"  "+riceList.get(i).getName());
			System.out.println("Weight:"+" "+riceList.get(i).getWeight());
			System.out.println("Price"+" "+riceList.get(i).getPrice());
			System.out.println("=======================================");
			
		}
		List<Wheat> wheatList=ObjectMapper.readValue(file1, new TypeReference <List<Wheat>>() {});
		for(int i=0;i<wheatList.size();i++)
		{
			System.out.println("Name:"+" "+wheatList.get(i).getName());
			System.out.println("Weight:"+" "+wheatList.get(i).getWeight());
			System.out.println("Price:"+" "+wheatList.get(i).getPrice());
			System.out.println("=======================================");
			
		}
		List<Pulses> pulsesList=ObjectMapper.readValue(file2, new TypeReference <List<Pulses>>() {});
		for(int i=0;i<pulsesList.size();i++)
		{
			System.out.println("Name:"+" "+pulsesList.get(i).getName());
			System.out.println("Weight:"+" "+pulsesList.get(i).getWeight());
			System.out.println("Price:"+" "+pulsesList.get(i).getPrice());
			System.out.println("=======================================");
			
		}
		
		boolean flag=false;
		while(flag==false)
		{
			 System.out.println("Enter The Choice:");
			 System.out.println("1:Add Inventory \t2:Total \t3:Exit");
			 int choice = JsonUtil.inputInteger();
			 switch(choice)
			{
			case 1: System.out.println("Selelct the Inventory name: 1.Rice \t2.Wheat \t3.Pulses");
			int inventoryName = JsonUtil.inputInteger();
			switch(inventoryName) {
			case 1:
				Rice inventoryRice = new Rice();
				System.out.println("Enter the name:");
				inventoryRice.setName(JsonUtil.inputSingleString());
				System.out.println("Enter the price");
				inventoryRice.setPrice(JsonUtil.inputDouble());
				System.out.println("Enter the weight");
				inventoryRice.setWeight(JsonUtil.inputInteger());                  
				
				riceList.add(inventoryRice);
				System.out.println("Rice inventory added successfully");
				String riceJson = ObjectMapper.writeValueAsString(inventoryRice);
				JsonUtil.writeToJsonFile(riceJson, writeRicePath);
				System.out.println(riceJson);
				System.out.println("File Writted Successfully");
				break;
				
			case 2:
			     Wheat inventoryWheat =new Wheat();
			     System.out.println("Enter the name: ");
			     inventoryWheat.setName(JsonUtil.inputSingleString());
			     System.out.println("Enter the Price:");
			     inventoryWheat.setPrice(JsonUtil.inputDouble());
			     System.out.println("Enter the Weight:");
			     inventoryWheat.setWeight(JsonUtil.inputInteger());
			     
			        wheatList.add(inventoryWheat);
					System.out.println("Wheat inventory added successfully");
					String wheatJson = ObjectMapper.writeValueAsString(inventoryWheat);
					JsonUtil.writeToJsonFile(wheatJson,writeWheatPath);
					System.out.println(wheatJson);
					System.out.println("File Writted Successfully");
					break;
			     
			case 3:
			     Pulses inventoryPulses =new Pulses();
			     System.out.println("Enter the name: ");
			     inventoryPulses.setName(JsonUtil.inputSingleString());
			     System.out.println("Enter the Price:");
			     inventoryPulses.setPrice(JsonUtil.inputDouble());
			     System.out.println("Enter the Weight:");
			     inventoryPulses.setWeight(JsonUtil.inputInteger());
			     
			        pulsesList.add(inventoryPulses);
					System.out.println("Pulses inventory added successfully");
					String pulsesJson = ObjectMapper.writeValueAsString(inventoryPulses);
					JsonUtil.writeToJsonFile(pulsesJson, writePulsesPath);
					System.out.println(pulsesJson);
					System.out.println("File Writted Successfully");
					break;
			     
			}
			
			case 2:
			for (int i = 0; i < riceList.size(); i++) {
					Rice inventoryRice = riceList.get(i);
					double ricePrice = inventoryRice.getWeight()*inventoryRice.getPrice();
					System.out.println("Rice name :" + inventoryRice.getName()+" total price is "+ricePrice);
				}
				for (int i = 0; i < wheatList.size(); i++) {
					Wheat inventoryWheat = wheatList.get(i);
					double wheatPrice = inventoryWheat.getWeight()*inventoryWheat.getPrice();
	
					System.out.println("Wheat name :" + inventoryWheat.getName()+" total price is "+wheatPrice);
					
				}
				for (int i = 0; i < pulsesList.size(); i++) {
					Pulses inventoryPulse = pulsesList.get(i);
					double pulsePrice = inventoryPulse.getWeight()*inventoryPulse.getPrice();
					System.out.println("Pulses name :" + inventoryPulse.getName()+" total price is "+pulsePrice);
					
				}
				break;
			case 3 :
				System.exit(0);
			}
			
			
			
		}

}
}
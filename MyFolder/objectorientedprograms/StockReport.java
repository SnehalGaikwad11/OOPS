package objectorientedprograms;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import objectorientedprograms.JsonUtil;


/**@purpose: Write a program to read in Stock Names, Number of Share, Share Price.
 *            Print a Stock Report with total value of each Stock and the total value of Stock.
 *
 * @version:1.0
 * @author:Snehal Gaikwad.
 *@since:12/3/2019
 */


//class for the stock report
public class StockReport   implements Serializable  {
public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String path="Stockwrite.json";  //json file
		File file=new File(path);
		String StockWritePath=("/home/admin1/Desktop/bridgelab/Stock.json");  //path of the json file
		ObjectMapper object=new ObjectMapper();
		
		List<Stock> stockList = object.readValue(file, new TypeReference<List<Stock>>() {});  //reading file
		for(int i=0;i<stockList.size();i++) {
			//content in json file
			System.out.println("stock_name"+" "+stockList.get(i).getShare_name());  
			System.out.println("number_of_share"+" "+stockList.get(i).getNumber_of_share());
			System.out.println("share of price"+" "+stockList.get(i).getShare_price());	
			System.out.println("**************************************************");
	}
		boolean flag=false;  //boolean data type is for cheked the condition true/false
		while(flag==false) {
		JsonUtil jsonutil=new JsonUtil();
		//users input
		System.out.println("Enter your Choice");
		System.out.println("1.Stock Name \t 2.Total Price \t 3.Exit");
		int choice=JsonUtil.inputInteger();
		switch(choice)
		{
		case 1:
				Stock stock=new Stock();   //created object of stock
				
				System.out.println("Enter the Name of stock");
				stock.setShare_name(JsonUtil.inputSingleString());
				System.out.println("****************************");
				System.out.println("Enter the Number of Shares");
				stock.setNumber_of_share(JsonUtil.inputInteger());
				System.out.println("***************************");
				System.out.println("Enter the Price of Shares");
				stock.setShare_price(JsonUtil.inputDouble());
				System.out.println("***************************");
				stockList.add(stock);
				String jsonstock = object.writeValueAsString(stock);
				JsonUtil.writeToJsonFile(jsonstock, StockWritePath);
				break;
		
				//cheked the stock using list
		case 2:	
				
				for(int i=0;i<stockList.size();i++) {
				Stock stock1 = stockList.get(i);
				double totalStock = stock1.getNumber_of_share()*stock1.getShare_price();
				System.out.println("stock name"+stock1.getShare_name()+"total price:"+totalStock);  //print the total
				}
				break;
		case 3:
			System.exit(0);
		}	
		}
}
}


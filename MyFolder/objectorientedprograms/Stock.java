package objectorientedprograms;

import java.io.Serializable;

public class Stock  implements Serializable{

	private String share_name;
	  private int number_of_share;
	  private double share_price;
	  
	public String getShare_name() {
		return  share_name;
	}
	public void setShare_name(String share_name) {
		this.share_name = share_name;
	}
	public int getNumber_of_share() {
		return number_of_share;
	}
	public void setNumber_of_share(int number_of_share) {
		this.number_of_share = number_of_share;
	}
	public double getShare_price() {
		return share_price;
	}
	public void setShare_price(double share_price) {
		this.share_price = share_price;
	}
	@Override
	public String toString() {
		return "Stock [share_name=" + share_name + ", number_of_share=" + number_of_share + ", share_price="
				+ share_price + "]";
	}
	  
}

package objectorientedprograms;

import java.io.Serializable;

public class Pulses implements Serializable
{
  private String name;
  private int weight;
  private double price;
  
public String getName() {
	return  name;
}
public void setName(String name) {
	this.name = name;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Pulses [name=" + name + ", weight=" + weight + ", price=" + price + "]";
}

  

}

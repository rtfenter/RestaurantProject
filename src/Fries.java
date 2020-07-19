
public class Fries extends FoodItem {
	protected double cost;
	protected String description;
	
	public Fries(){
		description = "1 order Fries";
		cost = 1.95;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		String result = description;
		return result;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}
	
	public double getCost(){
		return cost;
	}
}

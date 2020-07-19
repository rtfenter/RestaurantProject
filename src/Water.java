
public class Water extends FoodItem{
	
	protected double cost;
	protected String description;
	
	public Water(){
		cost = .10;
		description = "1 Cup of Water";
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

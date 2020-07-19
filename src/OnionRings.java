
public class OnionRings extends FoodItem{
	protected double cost;
	protected String description;
	
	public OnionRings(){
		description = "1 Order of Onion Rings";
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

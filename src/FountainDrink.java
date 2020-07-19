
public class FountainDrink extends FoodItem {
	
	protected double cost;
	protected String description;
	
	public FountainDrink(){
		cost = 1.99;
		description = "1 Fountain Drink";
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

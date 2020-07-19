
public abstract class FoodItem {
	private java.util.Date dateCreated;
	
	public FoodItem(){
		dateCreated = new java.util.Date();
	}
	
	public abstract void setDescription(String description);
	public abstract String getDescription();
	public abstract void setCost(double cost);
	public abstract double getCost();
	
}

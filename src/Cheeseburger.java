
public class Cheeseburger extends FoodItem{
	
	protected double cost;
	protected String description;
	protected int tomato, lettuce, onion, cheese, meat;
	
	public Cheeseburger(){
		description = "A beef cheeseburger with tomato, lettuce, and onion served on a wheat bun.";
		cost = 6.95;
		tomato = 1;
		lettuce = 1;
		onion = 1;
		cheese = 1;
		meat = 1;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		String description;
		description = "Cheeseburger with:\n" + cheese + " servings of cheese.";
		description += "\n" + tomato + " servings of tomato";
		description += "\n" + lettuce + " servings of lettuce";
		description += "\n" + onion + " servings of onion";
		return description;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}
	
	public double getCost(){
		return cost;
	}
	
	public void addCheese(){
		cheese = cheese + 1;
		cost = cost + .10;
	}
	
	public void lessCheese(){
		if (cheese == 0){
			cheese = 0;
		}
		else{cheese = cheese - 1;
		cost = cost - .10;
		}
	}
	
	public void addTomato(){
		tomato = tomato + 1;
		cost = cost + .10;
	}
	
	public void lessTomato(){
		if (tomato == 0){
			tomato = 0;
		}
		else{
		tomato = tomato - 1;
		cost = cost - .1;
		}
	}
	
	public void addLettuce(){
		lettuce = lettuce + 1;
		cost = cost + .10;
	}
	
	public void lessLettuce(){
		if (lettuce == 0){
			lettuce = 0;
		}
		else{
		lettuce = lettuce - 1;
		cost = cost - .10;
		}
	}
	
	public void addOnion(){
		onion = onion + 1;
		cost = cost + .10;
	}
	
	public void lessOnion(){
		if (onion == 0){
			onion = 0;
		}
		else{
		onion = onion - 1;
		cost = cost - .10;
		}
	}
	
	public String toString(){
		String r;
		r = "Cheeseburger with:\n" + cheese + " servings of cheese.";
		r += "\n" + tomato + " servings of tomato";
		r += "\n" + lettuce + " servings of lettuce";
		r += "\n" + onion + " servings of onion";
		return r;
	}

}

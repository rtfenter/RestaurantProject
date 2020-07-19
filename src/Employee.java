
public class Employee {
	protected String userId, firstName, lastName, hireDate, position, userPassword;
	protected double salary, hoursWorked;
	protected boolean isEmployee, isManager, isOwner;

	
	public Employee(){
	firstName = null;
	lastName = null;
	hireDate = null;
	position = null;
	salary = 0;
	hoursWorked = 0;
	isEmployee = true;
	}
	
	public Employee(String userId, String lastName, String firstName, String hireDate, String position, boolean isManager){
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.hireDate = hireDate;
		this.position = position;
		this.salary = salary; 
		this.hoursWorked = hoursWorked;
		this.isManager = isManager;
		this.isOwner = isOwner;

		
	}	

	public Employee(String userId, String lastName, String firstName, String hireDate, String position, double salary, double hoursWorked, boolean isManager, boolean isOwner, String userPassword){
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.hireDate = hireDate;
		this.position = position;
		this.salary = salary; 
		this.hoursWorked = hoursWorked;
		this.isManager = isManager;
		this.isOwner = isOwner;
		this.userPassword = userPassword;
		
	}	
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setPassword(String userPassword){
		boolean specialCharacter = false, changeSuccess = false, hasNum = false;
		
		if ((userPassword.length()) < 8 || (userPassword.length() > 24)){
			System.out.println("Password must be 8-24 character's in length");
			changeSuccess = false;
		}
		else{
			//Searches for special character
			for (int i = 0; i < userPassword.length(); i++){
				if (userPassword.charAt(i) == '!' || userPassword.charAt(i) == '@' ||
					userPassword.charAt(i) == '#' || userPassword.charAt(i) == '?' ||
					userPassword.charAt(i) == '*' || userPassword.charAt(i) == '%' ||
					userPassword.charAt(i) == '&'){
					specialCharacter = true;
					break;
				}
				else {
					specialCharacter = false;
				}
			}
			
			if (specialCharacter == false){
				System.out.println("Password must contain one of the characters \"!@#?*%&\" ");
				changeSuccess = false;
			}
			else {
				
				//Searches for number in password
				for (int i = 0; i < userPassword.length(); i++){
					if (userPassword.charAt(i) == '0' || userPassword.charAt(i) == '1' ||
						userPassword.charAt(i) == '2' || userPassword.charAt(i) == '3' ||
						userPassword.charAt(i) == '4' || userPassword.charAt(i) == '5' ||
						userPassword.charAt(i) == '6' || userPassword.charAt(i) == '6' ||
						userPassword.charAt(i) == '7' || userPassword.charAt(i) == '8' ||
						userPassword.charAt(i) == '9'){
						hasNum = true;
						break;
					}
					else {
						hasNum = false;
					}
				

				}
				if (hasNum == true){
					this.userPassword = userPassword;
					System.out.println("Change Successful!");
					}
				else {
					System.out.println("Password must contain one number");
				}
			}
		}

		
	}//Closes Set Password
	
	public String getPassword(){
		return userPassword;
	}
	
	public void setHireDate(String hireDate){
		this.hireDate = hireDate;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	public void setSalary (double salary){
		if (salary < 0){
			System.out.println("Incorrect Salary amount");
			System.out.println("No changes have been made to salary");
		}
		else{
			this.salary = salary;
			System.out.println("Salary has been changed");
		}
		
	}
	public void setHoursWorked(double hoursWorked){
		this.hoursWorked = hoursWorked;
	}
	
	public void increaseHours(double hours){
		hoursWorked = hoursWorked + hours;
	}
	
	public void decreaseHours(double hours){
		hoursWorked = hoursWorked = hours;
	}
	
	public void setManager(){
		isManager = true;
	}
	
	public void setNoManager(){
		isManager = false;
	}
	
	public boolean isManager(){
		return isManager;
	}
	
	
	public void setOwner(){
		isOwner = true;
	}
	
	public void setNoOwner(){
		isOwner = false;
	}
	
	public boolean isOwner(){
		return isOwner;
	}	
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getHireDate(){
		return hireDate;
	}
	
	public String getPosition(){
		return position;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public double getHoursWorked(){
		return hoursWorked;
	}
	
	public boolean isEmployee(){
		return isEmployee;
	}
	
	public String toString(){
		String result;
		result = "User Id: " + userId + " "; 
		result += "Name: " + firstName + " " + lastName + " ";
		result += "Hire Date: " + hireDate + " ";
		result += "Position: " + position + " ";
		result += "Hours Worked: " + hoursWorked + " ";
		result += "Manager: " + isManager;
		return result;
		
	}
}// Closes class

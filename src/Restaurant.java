//********************************************************************************************
// Restaurant Program
//********************************************************************************************

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Restaurant {
	public static void main(String[] args) throws IOException, NumberFormatException {
	String fileLine;
	Scanner fileScan, fileLineScan;	
	fileScan = new Scanner(new File("EmployeeList.txt"));
	ArrayList<Employee> employeeList = new ArrayList();
	NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
	DecimalFormat df = new DecimalFormat("0.##");
	
	String passwordInput = null, idInput = null;
	boolean loginSuccess = false, changeSuccessfull,  endOwnerProfile = false, endManagerProfile = false, loginId = false;
	String employeeFirstName, employeeLastName, employeeHireDate, employeePosition, employeeId = null, employeePassword, logOutNumber;
	String editDataOne, editDataTwo, foodChoice;
	String managerEditChoice;

	double employeeSalary, employeeHours;
	
	String userChoice;

	Scanner scan = new Scanner(System.in);
	
	//Read in Startup Files 
	//Startup files are EmployeeList.txt

	boolean exitProgram = false;
	boolean validAnswer;
	


	//============================================================================================
	//Pre-Program Opening. Should open Employee.txt and load into Employee ArrayList
	//============================================================================================	
	while (fileScan.hasNext()){
		String lastName, firstName, hireDate, position, userPassword;

		
		fileLine = fileScan.nextLine();
		//System.out.println("Line: " + fileLine);
		
		fileLineScan = new Scanner(fileLine);
		fileLineScan.useDelimiter(",");
		
		String userId = fileLineScan.next();
		lastName = fileLineScan.next();
		firstName = fileLineScan.next();
		hireDate = fileLineScan.next();
		position = fileLineScan.next();
		double salary = (Double.parseDouble(fileLineScan.next()));
		double hoursWorked = (Double.parseDouble(fileLineScan.next()));
		boolean isManager = (Boolean.parseBoolean(fileLineScan.next()));
		boolean isOwner = (Boolean.parseBoolean(fileLineScan.next()));
		userPassword = fileLineScan.next();

		Employee employee = new Employee(userId, lastName, firstName, hireDate, position, salary, hoursWorked, isManager, isOwner, userPassword);

		employeeList.add(employee);
	}//closes fileScan.hasNext() Loop
	fileScan.close();

	
	
	
	//============================================================================================
	//Program Overview Screen. 
	//This part of the program allows the employee, manager, or owner to access different parts of the
	//system.
	//============================================================================================
	
	System.out.println("***********************************************************");
	System.out.println("                  RESTAURANT PROGRAM ");
	System.out.println("***********************************************************");
	
	System.out.println();
	System.out.println();
	
	while (exitProgram == false){
		validAnswer = false;
		System.out.println("Welcome to the BLANK Restaurant Management System!");
		System.out.println();
		while (validAnswer == false){
			System.out.println("Please enter a profile:");
			System.out.println("1. Restaurant Ordering");
			System.out.println("2. Employee Profile");
			System.out.println("3. Manager Profile");
			System.out.println("4. Owner Profile");
			System.out.println("5. Exit Program");
			userChoice = scan.next();
			
//===========================================================================================
//Restaurant Ordering Profile (userChoice == "1")
//===========================================================================================			
						
			if (userChoice.equals("1")){

				boolean endOrder;
				boolean logOut = false;	
				
				while (logOut == false){
					endOrder = false;
					
					ArrayList<FoodItem> order = new ArrayList<FoodItem>();
					System.out.println("Welcome to the BLANK RESTAURANT!");
					System.out.println();
				
						while (endOrder != true){				
							System.out.println("Your current Order:");
							double orderCost = 0;
							for (int i = 0; i < order.size(); i++){
								System.out.println(order.get(i).getDescription());
								orderCost = orderCost + order.get(i).getCost();
							}
							System.out.println("Cost: " + fmt1.format(orderCost));
							System.out.println();
							
							System.out.println("Please select what you would like to order:");
							System.out.println("1. Burgers");
							System.out.println("2. Sides");
							System.out.println("3. Drinks");
							System.out.println("4. Complete Order");
							System.out.println("5. Cancel Order");
					
							foodChoice = scan.next();
						
							if (foodChoice.equals("1")){
								String burgerChoice = "0";
								System.out.println("\nWhat kind of burger would you like?");
								System.out.println("1. Cheeseburger ($6.95)");
								System.out.println("2. Chickenburger ($6.95)");
								System.out.println("3. Back");
								burgerChoice = scan.next();
								
								if (burgerChoice.equals("1") || burgerChoice.equals("1.") || burgerChoice.equalsIgnoreCase("Cheeseburger")){
									Cheeseburger burger = new Cheeseburger();
									String cheeseBurgerChoice = "0";
									
									while (cheeseBurgerChoice.equals("10") == false){
										System.out.println("\nPlease modify your Cheeseburger as needed:");
										System.out.println("Your Burger: ");
										System.out.println(burger.toString());
										System.out.println("Cost: " + fmt1.format(burger.getCost()));
										System.out.println();
										System.out.println("1. Add cheese ($.10 extra)");
										System.out.println("2. Add tomato ($.10 extra)");
										System.out.println("3. Add lettuce ($.10 extra)");
										System.out.println("4. Add Onion ($.10 extra)");
										System.out.println("5. Remove cheese");
										System.out.println("6. Remove tomato");
										System.out.println("7. Remove lettuce");
										System.out.println("8. Remove Onion");
										System.out.println("9. Description of your Cheeseburger.");
										System.out.println("10. I'm happy with this cheeseburger.(Complete this burger)");
										cheeseBurgerChoice = scan.next();
										
										if (cheeseBurgerChoice.equals("1")){burger.addCheese();}
										else if (cheeseBurgerChoice.equals("2")){burger.addTomato();}
										else if (cheeseBurgerChoice.equals("3")){burger.addLettuce();}
										else if (cheeseBurgerChoice.equals("4")){burger.addOnion();}
										else if (cheeseBurgerChoice.equals("5")){burger.lessCheese();}
										else if (cheeseBurgerChoice.equals("6")){burger.lessTomato();}
										else if (cheeseBurgerChoice.equals("7")){burger.lessLettuce();}
										else if (cheeseBurgerChoice.equals("8")){burger.lessOnion();}
										else if (cheeseBurgerChoice.equals("9")){System.out.println(burger.toString());}
										else if (cheeseBurgerChoice.equals("10")){order.add(burger);}
									}//Closes cheeseBurgerChoice loop
									
								}//Closes burgerChoice == 1 loop
								
								else if (burgerChoice.equals("2") || (burgerChoice.equals("2."))){
									Chickenburger burger = new Chickenburger();
									String chickenBurgerChoice = "0";
									
									while (chickenBurgerChoice.equals("10") == false){
										System.out.println("\nPlease modify your Chickenburger as needed:");
										System.out.println("Your Chickenburger: ");
										System.out.println(burger.toString());
										System.out.println("Cost: " + fmt1.format(burger.getCost()));
										System.out.println();
										System.out.println("1. Add cheese ($.10 extra)");
										System.out.println("2. Add tomato ($.10 extra)");
										System.out.println("3. Add lettuce ($.10 extra)");
										System.out.println("4. Add Onion ($.10 extra)");
										System.out.println("5. Remove cheese");
										System.out.println("6. Remove tomato");
										System.out.println("7. Remove lettuce");
										System.out.println("8. Remove Onion");
										System.out.println("9. Description of your Chickenburger.");
										System.out.println("10. I'm happy with this chickenburger. (Complete this burger)");
										chickenBurgerChoice = scan.next();
										
										if (chickenBurgerChoice.equals("1")){burger.addCheese();}
											else if (chickenBurgerChoice.equals("2")){burger.addTomato();}
											else if (chickenBurgerChoice.equals("3")){burger.addLettuce();}
											else if (chickenBurgerChoice.equals("4")){burger.addOnion();}
											else if (chickenBurgerChoice.equals("5")){burger.lessCheese();}
											else if (chickenBurgerChoice.equals("6")){burger.lessTomato();}
											else if (chickenBurgerChoice.equals("7")){burger.lessLettuce();}
											else if (chickenBurgerChoice.equals("8")){burger.lessOnion();}
											else if (chickenBurgerChoice.equals("9")){System.out.println(burger.toString());}
											else if (chickenBurgerChoice.equals("10")){
													order.add(burger);
										}
									}//Closes chickenBurgerChoice loop
									
								}//Closes burgerChoice == 2 loop
								else if (burgerChoice.equals("3")){}
							}//Closes foodChoice ==1 Loop
							
							else if (foodChoice.equals("2")){
								String sideChoice = "0";
								System.out.println("\nWhat kind of side would you like?");
								System.out.println("1. Fries ($1.95)");
								System.out.println("2. Onion Rings ($1.95)");
								System.out.println("3. Back");
								sideChoice = scan.next();
								
								if (sideChoice.equals("1")){
									Fries fries = new Fries();
									order.add(fries);
								}
								else if (sideChoice.equals("2")){
									OnionRings rings = new OnionRings();
									order.add(rings);
								}
								else if (sideChoice.equals("3")){
								}
								
							}//Closes foodChoice == 2 Loop
							
							else if (foodChoice.equals("3")){
								String drinkChoice = "0";
								
								System.out.println("\nWhat kind of drink would you like?");
								System.out.println("1. Water ($.10)");
								System.out.println("2. Fountain Drink ($1.99)");
								System.out.println("3. Back");
								drinkChoice = scan.next();
								
								if (drinkChoice.equals("1")){
									Water water = new Water();
									order.add(water);
								}
								else if (drinkChoice.equals("2")){
									FountainDrink drink = new FountainDrink();
									order.add(drink);
								}
								else if (drinkChoice.equals("3")){}
							}//Closes foodChoice == 3 Loop
							
							else if (foodChoice.equals("4")){
								System.out.println("You ordered: ");
								orderCost = 0;
								for (int i = 0; i < order.size(); i++){

									System.out.println(order.get(i).getDescription());
									orderCost = orderCost + order.get(i).getCost();
								}
								System.out.println("Your total cost is: " + fmt1.format(orderCost));
								System.out.println("Please pay cashier:");
								System.out.println("Press any key to continue:");
								scan.next();
								System.out.println();
								endOrder = true;
								break;
							}//Closes foodChoice == 4 loop
							
							else if (foodChoice.equals("5")){
								order.clear();
								System.out.println("Your order has been cancelled.");
								System.out.println("Press any key to continue:");
								scan.next();
								System.out.println();
								endOrder = true;
								break;
								}
								
							}
						System.out.println();
						System.out.println("Please press any key to place next order.");
						logOutNumber = scan.next();
						
						for (int i = 0; i<employeeList.size(); i++){
							if (logOutNumber.equals(employeeList.get(i).getUserId())){
								System.out.println("Please enter your password: ");
								employeePassword = scan.next();
								if (employeePassword.equals(employeeList.get(i).getPassword())){
									logOut = true;
									break;
								}
							}
						}	
					
						}//Closes endOrder Loop

						
				}//Close Restaurant Order 
				

//===================================================================================
// Employee Profile
//===================================================================================		
			else if (userChoice.equals("2")){
				
				loginSuccess = false;
				endManagerProfile = false;
				loginId = false; 
				//===============================
				//Verifies userId and Password
				//===============================
				while (endManagerProfile == false){
					
					if (loginId == false){
					System.out.println("Please enter user ID: ");
					idInput = scan.next();
					System.out.println("Please enter password: ");
					passwordInput = scan.next();
					loginId = true;
					

					for (int i = 0; i < employeeList.size(); i++){
						if ((employeeList.get(i).getUserId().equals(idInput)) && (employeeList.get(i).getPassword().equals(passwordInput))){
								System.out.println("Login Successfull!");
								loginSuccess = true;
								loginId = true;
								break;
								}//Closes if loop
						}
					
					if (loginSuccess == false){
						if (endManagerProfile == false){
						System.out.println("User login/Password is incorrect.");
						endManagerProfile = true;}
						else {
							endManagerProfile = true;
						}
						}
					}
					//====================================
					//	User Id/Password verification is accepted. Manager can now make changes.
					//====================================	
					if (loginSuccess == true){
						System.out.println("Here are options you can do:");	
						System.out.println("1. Get Your Information Summary");
						System.out.println("2. Edit Your Work Hours");
						System.out.println("3. Reset Your Password");
						System.out.println("4. Save Changes");
						System.out.println("5. Log Out");
						
						managerEditChoice = scan.next();
						//=======================
						//Get An Employee's Information Summary(managerEditChoice.equals("1"))
						//=======================
						if (managerEditChoice.equals("1")){
							changeSuccessfull = true;
							System.out.println("Employee ID\tLast Name, First Name\tHire Date"
									+ "\tPosition\tHours\tManager?\tOwner?\tSalary");
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(idInput)){
									System.out.println(employeeList.get(i).getUserId() + "\t\t" + employeeList.get(i).getLastName().substring(0, 8)
										+ ", " + employeeList.get(i).getFirstName().substring(0, 11) + "\t" + employeeList.get(i).getHireDate()
										+ "\t" + employeeList.get(i).getPosition().substring(0, 7) + "\t" 
										+ "\t" + df.format(employeeList.get(i).getHoursWorked()) + "\t" + employeeList.get(i).isManager()
										+ "\t\t" + employeeList.get(i).isOwner() + "\t" + fmt1.format(employeeList.get(i).getSalary()));
										break;
								}
							}
						}// Closes managerEditChoice == 1 loop aka Get Employee Information Summary
						
						//=======================
						//Edit An Employee's Hours (managerEditChoice.equals("2"))
						//=======================
						else if (managerEditChoice.equals("2")){

							System.out.println("Please enter the new Hours:");
							employeeHours = scan.nextDouble();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(idInput)){
									employeeList.get(i).setHoursWorked(employeeHours);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 2 loop aka Change Hours Worked
							
						
						//=======================
						//Reset Password (managerEditChoice.equals("3"))
						//=======================
						if (managerEditChoice.equals("3")){
							changeSuccessfull = true;
							System.out.println("Please enter the new Password:");
							editDataOne = scan.next();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(idInput)){
									employeeList.get(i).setPassword(editDataOne);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}

						}// Closes managerEditChoice == 3 loop aka Change Password
						//=======================
						//Save Employee List to a File (managerEditChoice.equals("4"))
						//=======================		
						else if (managerEditChoice.equals("4")){
							PrintWriter out = new PrintWriter("EmployeeList.txt");
							
							for (int i = 0; i < employeeList.size(); i++){
								out.println(employeeList.get(i).getUserId() + "," 
							+ employeeList.get(i).getLastName() + "," + employeeList.get(i).getFirstName() + ","
							+ employeeList.get(i).getHireDate() + "," + employeeList.get(i).getPosition()
							+ "," + employeeList.get(i).getSalary() + "," + employeeList.get(i).getHoursWorked()
							+ "," + employeeList.get(i).isManager() + "," + employeeList.get(i).isOwner() 
								+ "," + employeeList.get(i).getPassword());
							}
							System.out.println("Changes Saved");
							
							out.close();
						}//Closes managerEditChoice == 4 or Saving Employee List to File
					
						//=======================
						//Log Out (managerEditChoice.equals("5"))
						//=======================		
						else if (managerEditChoice.equals("5")){
							endManagerProfile = true;
						}
						
					}//closes loginSuccess == true
				}//Closes while loginSuccess==false and endManagerProfile == false loop
		}	

//===================================================================================
// Manager Profile
//===================================================================================	
			else if (userChoice.equals("3")){
				loginId = false;
				loginSuccess = false;
				endManagerProfile = false;
				//===============================
				//Verifies userId and Password
				//===============================
				while (endManagerProfile == false){
					if (loginId == false){
					System.out.println("Please enter user ID: ");
					idInput = scan.next();
					System.out.println("Please enter password: ");
					passwordInput = scan.next();
					
					
					
					for (int i = 0; i < employeeList.size(); i++){
						if ((employeeList.get(i).getUserId().equals(idInput)) && (employeeList.get(i).getPassword().equals(passwordInput)) && (employeeList.get(i).isManager() == true)){
								System.out.println("Login Successfull!");
								loginSuccess = true;
								endManagerProfile = false;
								loginId = true;
								break;	
								}//Closes if loop
						else if ((employeeList.get(i).getUserId().equals(idInput)) && (employeeList.get(i).getPassword().equals(passwordInput)) && (employeeList.get(i).isManager() == false)){
								System.out.println("You do not have the neccesary permissions to log into this page.");
								endManagerProfile = true;
								}
						}
					}
					if (loginSuccess == false){
						if (endManagerProfile == false){
						System.out.println("User login/Password is incorrect.");
						endManagerProfile = true;}
						else {
							endManagerProfile = true;
						}
						}

					
					//====================================
					//	User Id/Password verification is accepted. Manager can now make changes.
					//====================================	
					if (loginSuccess == true){
						System.out.println("Here are options you can do:");	
						System.out.println("1. Get An Employee's Information Summary");
						System.out.println("2. See All Employees' Information");
						System.out.println("3. Edit An Employee's Hours");
						System.out.println("4. Edit An Employee's Password");
						System.out.println("5. Save Employee List to File");
						System.out.println("6. Log Out");
						
						managerEditChoice = scan.next();
						//=======================
						//Get An Employee's Information Summary(managerEditChoice.equals("1"))
						//=======================
						if (managerEditChoice.equals("1")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to view.");
							employeeId = scan.next();
							System.out.println("Employee ID\tLast Name, First Name\tHire Date"
									+ "\tPosition\tHours\tManager?\tOwner?");
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									System.out.println(employeeList.get(i).getUserId() + "\t\t" + employeeList.get(i).getLastName().substring(0, 8)
										+ ", " + employeeList.get(i).getFirstName().substring(0, 11) + "\t" + employeeList.get(i).getHireDate()
										+ "\t" + employeeList.get(i).getPosition().substring(0, 7) + "\t" 
										+ "\t" + df.format(employeeList.get(i).getHoursWorked()) + "\t" + employeeList.get(i).isManager()
										+ "\t\t" + employeeList.get(i).isOwner() + "\t")
										
									//Removed to prevent Manager from seeing Salaries. Not necessary for a Manager. 
										/*+ fmt1.format(employeeList.get(i).getSalary()))*/;
										break;
								}
							}
						}// Closes managerEditChoice == 1 loop aka Get Employee Information Summary
						
						//=======================
						//See All Employee's Information (managerEditChoice.equals("2"))
						//=======================
						else if (managerEditChoice.equals("2")){
							changeSuccessfull = true;
							System.out.println("Employee ID\tLast Name, First Name\tHire Date"
									+ "\tPosition\tHours\tManager?\tOwner?");
							for (int i = 0; i < employeeList.size(); i++){
									
									System.out.println(employeeList.get(i).getUserId() + "\t\t" + employeeList.get(i).getLastName().substring(0, 8) + 
										 ", " + employeeList.get(i).getFirstName().substring(0, 11) + "\t" + employeeList.get(i).getHireDate()
										+ "\t" + employeeList.get(i).getPosition().substring(0, 7) + "\t" 
										+ "\t" + df.format(employeeList.get(i).getHoursWorked()) + "\t" + employeeList.get(i).isManager()
										+ "\t\t" + employeeList.get(i).isOwner() + "\t");
							}
						}// Closes managerEditChoice == 2 loop aka See all Employee Information
						
						
						//=======================
						//Edit An Employee's Hours (managerEditChoice.equals("3"))
						//=======================
						else if (managerEditChoice.equals("3")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter the new Hours:");
							employeeHours = scan.nextDouble();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									employeeList.get(i).setHoursWorked(employeeHours);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 3 loop aka Change Hours Worked
							
						
						//=======================
						//Reset Password (managerEditChoice.equals("4"))
						//=======================
						if (managerEditChoice.equals("4")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee whose password you would like to change:");
							employeeId = scan.next();
							System.out.println("Please enter the new Password:");
							editDataOne = scan.next();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									if (employeeList.get(i).isOwner == true){
										System.out.println("You don't have permissions to change an owner's password.");
										changeSuccessfull = false;
										break;
									}
									else{
										employeeList.get(i).setPassword(editDataOne);
										changeSuccessfull = true;
									break;
									}
									
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
						}// Closes managerEditChoice == 4 loop aka Change Password
						//=======================
						//Save Employee List to a File (managerEditChoice.equals("5"))
						//=======================		
						else if (managerEditChoice.equals("5")){
							PrintWriter out = new PrintWriter("EmployeeList.txt");
							
							for (int i = 0; i < employeeList.size(); i++){
								out.println(employeeList.get(i).getUserId() + "," 
							+ employeeList.get(i).getLastName() + "," + employeeList.get(i).getFirstName() + ","
							+ employeeList.get(i).getHireDate() + "," + employeeList.get(i).getPosition()
							+ "," + employeeList.get(i).getSalary() + "," + employeeList.get(i).getHoursWorked()
							+ "," + employeeList.get(i).isManager() + "," + employeeList.get(i).isOwner() 
								+ "," + employeeList.get(i).getPassword());
							}
							
							System.out.println("Changes Saved");
							
							out.close();
						}//Closes managerEditChoice == 5 or Saving Employee List to File
					
						//=======================
						//Log Out (managerEditChoice.equals("6"))
						//=======================		
						else if (managerEditChoice.equals("6")){
							endManagerProfile = true;
						}
						
					}//closes loginSuccess == true
				}//Closes while loginSuccess==false and endManagerProfile == false loop
			}
			
//===================================================================================
// Owner Profile
//===================================================================================				
			else if (userChoice.equals("4")){
				loginId = false;
				loginSuccess = false;
				endOwnerProfile = false;
				//===============================
				//Verifies userId and Password
				//===============================
				while (endOwnerProfile == false){
					if (loginId == false){
					System.out.println("Please enter user ID: ");
					idInput = scan.next();
					System.out.println("Please enter password: ");
					passwordInput = scan.next();
					
					
					
					for (int i = 0; i < employeeList.size(); i++){
						if ((employeeList.get(i).getUserId().equals(idInput)) && (employeeList.get(i).getPassword().equals(passwordInput)) && (employeeList.get(i).isOwner() == true)){
								System.out.println("Login Successfull!");
								loginSuccess = true;
								endManagerProfile = false;
								loginId = true;
								break;	
								}//Closes if loop
						else if ((employeeList.get(i).getUserId().equals(idInput)) && (employeeList.get(i).getPassword().equals(passwordInput)) && (employeeList.get(i).isOwner() == false)){
								System.out.println("You do not have the neccesary permissions to log into this page.");
								endOwnerProfile = true;
								}
						}
					}
					if (loginSuccess == false){
						if (endOwnerProfile == false){
						System.out.println("User login/Password is incorrect.");
						endOwnerProfile = true;}
						else {
							endOwnerProfile = true;
							}
						}
					
				//====================================
				//	User Id/Password verification is accepted. Owner can now make changes.
				//====================================	

					if (loginSuccess == true){

						System.out.println("Here are options you can do:");
						System.out.println("1. Add Employee");		
						System.out.println("2. Change Employee Name");
						System.out.println("3. Change Employee Hire Date");
						System.out.println("4. Change Employee Position");
						System.out.println("5. Add/Remove Manager Permissions");
						System.out.println("6. Add/Remove Owner Permissions");
						System.out.println("7. Edit Salary");
						System.out.println("8. Edit Hours");
						System.out.println("9. Edit Employee Password");
						System.out.println("10. Get Employee Information Summary");
						System.out.println("11. See all Employee's Information");
						System.out.println("12. Save Employee List to File");
						System.out.println("13. Log Out");

						
						managerEditChoice = scan.next();
						//=======================
						//Add Employee Option
						//=======================
						if (managerEditChoice.equals("1")){
							boolean idSuccess = false;
							
							while (idSuccess == false){
							System.out.println("Please enter user ID of new associate: ");
							employeeId = scan.next();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeId.equals(employeeList.get(i).getUserId())){
									System.out.println("User ID Already exists! Please try again.");
									idSuccess = false;
									break;
								}
								else{
									idSuccess = true;
								}
								
							}
							}
							
							System.out.println("Please enter new employee Last Name: ");
							employeeLastName = scan.next();
							System.out.println("Please enter new employee First Name: ");
							employeeFirstName = scan.next();
							if (employeeLastName.length() < 20){
								employeeLastName = employeeLastName.concat("                    ").substring(0, 20);
							}
							if (employeeFirstName.length() < 20){
								employeeFirstName = employeeFirstName.concat("                    ").substring(0, 20);
							}
							System.out.println("Please enter new employee Hire Date: (MM/DD/YY) ");
							employeeHireDate = scan.next();
							System.out.println("Please enter new employee Position:");
							System.out.println("No Spaces Allowed. Please use an underscore instead.");
							System.out.println("Ex. Assistant Manager should be entered as \"Asst_Manager\"");
							employeePosition = scan.next();
							if (employeePosition.length() < 7){
								employeePosition = employeePosition.concat("                    ").substring(0, 7);
							}
							else{
								employeePosition = employeePosition.substring(0,7);
							}
								

							System.out.println("Is the new associate a Manager? Press \"y\" or \"yes\" for YES. Otherwise"
									+ "press any key for NO");
							String isNewManager = scan.next();
							boolean isNewManagerBoolean;
							if (isNewManager.equalsIgnoreCase("y") || (isNewManager.equalsIgnoreCase("yes"))){
								isNewManagerBoolean = true;
							}
							else{
								isNewManagerBoolean = false;
							}
							
							
							Employee employee = new Employee(employeeId, employeeLastName, employeeFirstName, employeeHireDate, employeePosition, isNewManagerBoolean);
							employeeList.add(employee);
							System.out.println("Employee Added");
							System.out.println("IMPORTANT!!!! YOU MUST SET THE EMPLOYEES PASSWORD BEFORE THE EMPLOYEE WILL BE ABLE TO LOG ON");
							System.out.println("PLEASE SET THE EMPLOYEES SALARY IN THE OWNER'S MENU");
							
							
						}
						
						//=======================
						//Change Employee Name
						//=======================
						else if (managerEditChoice.equals("2")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter the new first name.");
							editDataOne = scan.next();
							System.out.println("Please enter the new last name.");
							editDataTwo = scan.next();
							if (editDataOne.length() < 8){
								editDataOne = editDataOne.concat("                    ").substring(0, 20);
							}
							if (editDataTwo.length() < 8){
								editDataTwo = editDataTwo.concat("                    ").substring(0, 20);
							}
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									employeeList.get(i).setFirstName(editDataOne);
									employeeList.get(i).setLastName(editDataTwo);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}
								
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 2 loop aka Change name loop
						
						
						//=======================
						//Change Employee Hire Date (managerEditChoice.equals("3"))
						//=======================
						else if (managerEditChoice.equals("3")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter the new Hire Date (MM/DD/YY):");
							editDataOne = scan.next();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									employeeList.get(i).setHireDate(editDataOne);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 3 loop aka Change Hire Date
						
						//=======================
						//Change Employee Position (managerEditChoice.equals("4"))
						//=======================
						else if (managerEditChoice.equals("4")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter the new Position:");
							editDataOne = scan.next();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									if (editDataOne.length() < 7){
										editDataOne = editDataOne.concat("                    ").substring(0, 7);
									}
									else{
										editDataOne = editDataOne.substring(0, 7);
									}
									employeeList.get(i).setPosition(editDataOne);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 4 loop aka Change Position
						
						
						//=======================
						//Add/remove Manager Permission (managerEditChoice.equals("5"))
						//=======================
						else if (managerEditChoice.equals("5")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter \"add\" to give employee manager permissions.");
							System.out.println("Please enter \"remove\" to remove an employee's manager permissions.");
							editDataOne = scan.next();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									if (editDataOne.equalsIgnoreCase("add")){
										employeeList.get(i).setManager();
									}
									else if (editDataOne.equalsIgnoreCase("remove")){
										employeeList.get(i).setNoManager();
									}
									else{
										System.out.println("Adding permissions failed. Please try again.");
									}
									

									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 5 loop aka Add/Remove Manager Permissions
						
						//=======================
						//Add/remove Owner Permission (managerEditChoice.equals("6"))
						//=======================
						else if (managerEditChoice.equals("6")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter \"add\" to give employee owner permissions.");
							System.out.println("Please enter \"remove\" to remove an employee's owner permissions.");
							editDataOne = scan.next();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									if (editDataOne.equalsIgnoreCase("add")){
										employeeList.get(i).setOwner();
									}
									else if (editDataOne.equalsIgnoreCase("remove")){
										employeeList.get(i).setNoOwner();
									}
									else{
										System.out.println("Adding permissions failed. Please try again.");
									}
									

									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 6 loop aka Add/Remove Owner Permissions					
						//=======================
						//Edit Salary (managerEditChoice.equals("7"))
						//=======================
						else if (managerEditChoice.equals("7")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter the new Salary:");
							employeeSalary = scan.nextDouble();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									employeeList.get(i).setSalary(employeeSalary);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 7 loop aka Change Salary
						
						//=======================
						//Edit Hours (managerEditChoice.equals("8"))
						//=======================
						else if (managerEditChoice.equals("8")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter the new Hours:");
							employeeHours = scan.nextDouble();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									employeeList.get(i).setHoursWorked(employeeHours);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}
							
							if (changeSuccessfull = false){
								System.out.println("Change was not successful.");
							}
							else{
								System.out.println("Change successful");}
						}// Closes managerEditChoice == 8 loop aka Change Hours Worked
						
						//=======================
						//Reset Password (managerEditChoice.equals("9"))
						//=======================
						else if (managerEditChoice.equals("9")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to edit.");
							employeeId = scan.next();
							System.out.println("Please enter the new Password:");
							editDataOne = scan.next();
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									employeeList.get(i).setPassword(editDataOne);
									changeSuccessfull = true;
									break;
								}
								
								else{ 
									changeSuccessfull = false;}		
							}

						}// Closes managerEditChoice == 9 loop aka Change Password
						
						//=======================
						//Get Employee Information Summary (managerEditChoice.equals("10"))
						//=======================
						else if (managerEditChoice.equals("10")){
							changeSuccessfull = true;
							System.out.println("Please enter user ID of employee you would like to view.");
							employeeId = scan.next();
							System.out.println("Employee ID\tLast Name, First Name\tHire Date"
									+ "\tPosition\tHours\tManager?\tOwner?\tSalary");
							for (int i = 0; i < employeeList.size(); i++){
								if (employeeList.get(i).getUserId().equals(employeeId)){
									System.out.println(employeeList.get(i).getUserId() + "\t\t" + employeeList.get(i).getLastName().substring(0, 8)
										+ ", " + employeeList.get(i).getFirstName().substring(0, 11) + "\t" + employeeList.get(i).getHireDate()
										+ "\t" + employeeList.get(i).getPosition().substring(0, 7) + "\t" 
										+ "\t" + df.format(employeeList.get(i).getHoursWorked()) + "\t" + employeeList.get(i).isManager()
										+ "\t\t" + employeeList.get(i).isOwner() + "\t" + fmt1.format(employeeList.get(i).getSalary()));
										break;
								}
							}
						}// Closes managerEditChoice == 10 loop aka Get Employee Information Summary
							
						//=======================
						//See all Employee Information (managerEditChoice.equals("11"))
						//=======================
						else if (managerEditChoice.equals("11")){
							changeSuccessfull = true;
							System.out.println("Employee ID\tLast Name, First Name\tHire Date"
									+ "\tPosition\tHours\tManager?\tOwner?\tSalary");
							for (int i = 0; i < employeeList.size(); i++){
									
									System.out.println(employeeList.get(i).getUserId() + "\t\t" + employeeList.get(i).getLastName().substring(0, 8) + 
										 ", " + employeeList.get(i).getFirstName().substring(0, 11) + "\t" + employeeList.get(i).getHireDate()
										+ "\t" + employeeList.get(i).getPosition().substring(0, 7) + "\t" 
										+ "\t" + df.format(employeeList.get(i).getHoursWorked()) + "\t" + employeeList.get(i).isManager()
										+ "\t\t" + employeeList.get(i).isOwner() + "\t" + fmt1.format(employeeList.get(i).getSalary()));
							}
						}// Closes managerEditChoice == 11 loop aka See all Employee Information
						
						//=======================
						//Save Employee List to File (managerEditChoice.equals("12"))
						//=======================
						else if (managerEditChoice.equals("12")){
							PrintWriter out = new PrintWriter("EmployeeList.txt");
							
							for (int i = 0; i < employeeList.size(); i++){
								out.println(employeeList.get(i).getUserId() + "," 
							+ employeeList.get(i).getLastName() + "," + employeeList.get(i).getFirstName() + ","
							+ employeeList.get(i).getHireDate() + "," + employeeList.get(i).getPosition()
							+ "," + employeeList.get(i).getSalary() + "," + employeeList.get(i).getHoursWorked()
							+ "," + employeeList.get(i).isManager() + "," + employeeList.get(i).isOwner() 
								+ "," + employeeList.get(i).getPassword());
							}
							
							System.out.println("Changes Saved");
							
							out.close();
						}//Closes managerEditChoice == 12 or Saving Employee List to File
						

						//=======================
						//Log Out (managerEditChoice.equals("13"))
						//=======================
						else if (managerEditChoice.equals("13")){
							endOwnerProfile = true;
						}
						
					}//closes loginSuccess == true loop	
					//===============================================
					//End owner profile options list.
					//===============================================
						
				validAnswer = true;
			}// Closes while endOwnerProfile = false loop
			}//Closes Owner Profile
//===================================================================================
// Owner Profile Ends
//===================================================================================
			
			else if (userChoice.equals("5")){
				validAnswer = true;
				exitProgram = true;
			}
			
		}//Closes validAnswer == false loop
	}//Closes exitProgram == false loop
	
	PrintWriter out = new PrintWriter("EmployeeList.txt");
	
	for (int i = 0; i < employeeList.size(); i++){
		if (employeeList.get(i).getLastName().length() < 20){
			employeeList.get(i).setLastName(employeeList.get(i).getLastName().concat("                    ").substring(0, 20));
		}
		else{
			employeeList.get(i).setLastName(employeeList.get(i).getLastName().substring(0,20));
		}
		
		if (employeeList.get(i).getFirstName().length() < 20){
			employeeList.get(i).setFirstName(employeeList.get(i).getFirstName().concat("                    ").substring(0, 20));
		}
		else{
			employeeList.get(i).setFirstName(employeeList.get(i).getFirstName().substring(0,20));
		}
		
		if (employeeList.get(i).getPosition().length() < 7){
			employeeList.get(i).setPosition(employeeList.get(i).getPosition().concat("                    ").substring(0, 7));
		}
		else{
			employeeList.get(i).setPosition(employeeList.get(i).getPosition().substring(0,7));
		}
		
		out.println(employeeList.get(i).getUserId() + "," 
	+ employeeList.get(i).getLastName() + "," + employeeList.get(i).getFirstName() + ","
	+ employeeList.get(i).getHireDate() + "," + employeeList.get(i).getPosition()
	+ "," + employeeList.get(i).getSalary() + "," + employeeList.get(i).getHoursWorked()
	+ "," + employeeList.get(i).isManager() + "," + employeeList.get(i).isOwner()
	+ "," + employeeList.get(i).getPassword());
	
	}
		
	out.close();
	scan.close();
	
	System.out.println("******************************************************************************");
	System.out.println("                       PROGRAM TERMINATED                                     ");
	System.out.println("******************************************************************************");
	
	}
	}//closes Class
	
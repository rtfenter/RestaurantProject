import java.util.ArrayList;

public class EmployeeList {

ArrayList<Employee> employeeList;

	public EmployeeList(){
		employeeList = new ArrayList<Employee>();
	}
	
	public void add(Employee e){
		employeeList.add(e);
	}
	
	public String toString(){
		String result = "";
		result += " ";
		return result;
	}
}

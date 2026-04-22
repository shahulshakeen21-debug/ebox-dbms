import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit = false;
        EmployeeDAO edo = new EmployeeDAO();
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        while (!isExit) {
            System.out.println("1.Insert\n2.Select\n3.Update\n4.Delete\n5.Exit\nEnter your choice:");
            int n = Integer.parseInt(br.readLine());
            switch(n) {
                case 1:
            		System.out.println("Enter the employee id:");
	            	int empId = Integer.parseInt(br.readLine());
	            	System.out.println("Enter the employee name:");
	            	String name = br.readLine();
	            	System.out.println("Enter the email address:");
	            	String email = br.readLine();
	            	System.out.println("Enter the contact number:");
	            	String contactNo = br.readLine();
	            	System.out.println("Enter the salary:");
            		Double salary = Double.parseDouble(br.readLine());
	            	// write your code for insertion
					Employee emp = new Employee(empId, name, email, contactNo, salary);
					edo.insert(emp);
					System.out.println("Record Inserted");
            		break;
            	case 2:
            		// write your code for selection
					employeeList = edo.getAllEmployees();
					if(employeeList.isEmpty()){
						System.out.println("Table is empty");
					} else{
						System.out.format("%-15s %-15s %-20s %-15s %s\n","Emp Id","Name","Email","Contact No","Salary");
						for (Employee e: employeeList){
							System.out.format("%-15d %-15s %-20s %-15s %.2f\n",e.getEmpId(), e.getName(), e.getEmail(), e.getContactNumber(), e.getSalary());
						}
					}
            		break;
            	case 3:
            		// write your code for updation
					System.out.println("Enter the employee id to be updated:");
					int updateId = Integer.parseInt(br.readLine());
					System.out.println("Enter the salary:");
					Double newSalary = Double.parseDouble(br.readLine());
					if(edo.update(updateId,newSalary)){
						System.out.println("Record updated");
					}else{
						System.out.println("Employee Record not found");
					}
            		break;
            	case 4:
            		// write your code for deletion
					System.out.println("Enter the employee id to be deleted:");
					int deleteId = Integer.parseInt(br.readLine());
					if(edo.delete(deleteId)){
						System.out.println("Record deleted");
					} else{
						System.out.println("Employee Record not found");
					}
            		break;
            	case 5:
            		// write your code here
					System.exit(0);
					System.out.println("Exiting program....");
            		break;
        	default:
        		// write your code here
				System.out.println("Invalid choice. please try again.");
                    	break;
        			
            }
        }
    }

}

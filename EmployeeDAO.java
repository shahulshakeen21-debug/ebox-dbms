import java.sql.*;
import java.util.*;
public class EmployeeDAO {
public EmployeeDAO() throws SQLException, ClassNotFoundException {
Connection conn DBConnection.obtainConnection();
Statement stmt1 = conn.createStatement();
stmt1.execute("DROP TABLE IF EXISTS employee;");
Statement stmt conn.createStatement();
String query = "CREATE TABLE employee (emp_id INT(10), name VARCHAR(25), email VARCHAR(25), contact_number VARCHAR(25), salary double);";
stmt.execute(query);
}
public void insert (Employee employee) throws SQLException, ClassNotFoundException {
Connection conn DBConnection.obtainConnection();
String query "INSERT INTO employee (emp_id,name, email,contact_number, salary) VALUES (?,?,?,?,?)";
PreparedStatement ps conn.prepareStatement(query);
ps.setInt(1, employee.getEmpId());
ps.setString(2,employee.getName());
ps.setString(3,employee.getEmail());
ps.setString(4,employee.getContactNumber());
ps.setDouble(5, employee.getSalary());
ps.executeUpdate();
System.out.println("Record Inserted");
}


public boolean update(int empId, Double salary) throws SQLException, ClassNotFoundException {
Connection conn = DBConnection.obtainConnection();
String query = "UPDATE employee SET salary =? WHERE emp_id=?";
PreparedStatement ps = conn.prepareStatement (query);
ps.setDouble(1, salary);
ps.setInt(2,empId);
int rows = ps.executeUpdate();
if (rows>0){
   return true;
}else{
   return false;
}
}


public boolean delete(int empId) throws SQLException, ClassNotFoundException {
Connection conn = DBConnection.obtainConnection();
String query ="DELETE FROM employee WHERE emp_id =?";
PreparedStatement ps = conn.prepareStatement (query);
ps.setInt(1,empId);
int rows = ps.executeUpdate();
if(rows>0){
   return true;
}
return false;
}


public ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
Connection conn = DBConnection.obtainConnection();
String query = "SELECT * FROM employee";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
ArrayList<Employee> list = new ArrayList<Employee>();
while(rs.next()){
    Employee emp = new Employee();
    emp.setEmpId(rs.getInt("emp_id"));
    emp.setName(rs.getString("name"));
    emp.setEmail(rs.getString("email"));
    emp.setContactNumber(rs.getString("contact_number"));
    emp.setSalary(rs.getDouble("salary"));
	list.add(emp);
}
return list;
}
}

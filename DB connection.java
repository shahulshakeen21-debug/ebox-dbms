import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class DBConnection {
    public static Connection obtainConnection() throws ClassNotFoundException, SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("mysql");
        String url = rb.getString("db.url");
        String username = rb.getString("db.username");
        String password = rb.getString("db.password");
        String drivername= "com.mysql.jdbc.Driver";
        Connection connection=null;

        //fill your code here
        try{
            Class.forName(drivername);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}

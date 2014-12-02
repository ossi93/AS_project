import java.lang.*;
import java.sql.*;

public class DBConnector {

    // Variables
    public String password;
    public String user;
    public String connectionString;

    // Constructor
    public DBConnector() {
    }

    // Constructor with parameters
    public DBConnector(String xconnectionString, String xuser, String xpassword) {
        password = xpassword;
        user = xuser;
        connectionString = xconnectionString;
    }

    // Set and Get Methods
    public void setUser(String xuser){
        this.user = xuser;
    }
    public void setPassword(String xpassword){
        password = xpassword;
    }
    public void setConnectionString(String xconnectionString) {
        connectionString = xconnectionString;
    }

    public String getPassword() {
        return password;
    }
    public String getUser() {
        return user;
    }
    public String getConnectionString() {
        return connectionString;
    }

    // Connect to Database
    public void connectToMSSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection sqlDBCon = DriverManager.getConnection(connectionString, user, password);
            System.out.println("connected to " + connectionString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Database Querys
    public boolean getItemByID(double id) {

        return false;
    }

    public boolean getRowsByValue(double String) {

        return false;
    }

    public boolean createItem() {return false;}

    public boolean deleteItem() {return true;}

    public boolean setEmp() {return true;}
}




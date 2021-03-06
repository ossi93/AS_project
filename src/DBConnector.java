import javax.xml.transform.Result;
import java.lang.*;
import java.sql.*;

public class DBConnector {
  
  // Variables
  public String password;
  public String user;
  public String connectionString;
  Connection conn = null;
  PreparedStatement prepQ = null;
  ResultSet rsSet = null;
  
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
  public Connection connectToMSSQL() {
    Connection sqlDBCon = null;
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      sqlDBCon = DriverManager.getConnection(connectionString, user, password);
      System.out.println("connected to " + connectionString);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return sqlDBCon;
  }
  
  /// Database Querys ////////////////////////////////////////////////////////////////////////////////////////////////////
  public void getEmpByID(Connection conn, double id) {
    // Setting Query
    String query = "SELECT * FROM T_EMP WHERE EMP_ID = ?";
    try {
      prepQ = conn.prepareStatement(query);
      // Replace "?" in Query
      prepQ.setDouble(1, id);
      // Save Result in rsSet
      rsSet = prepQ.executeQuery();
      // If result is not empty
      if (rsSet != null && rsSet.next()) {
        System.out.println(rsSet.getString("EMP_ID") + " | " + rsSet.getString("Name") + " | " + rsSet.getString("PreName"));
        prepQ.close();
      }
      else {
        System.out.println("EMP ID does not exist");
      }
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
  public void getItemByID(Connection conn, double id) {
    // Setting Query
    String query = "SELECT * FROM T_INV WHERE INV_ID = ?";
    try {
      prepQ = conn.prepareStatement(query);
      // Replace "?" in Query
      prepQ.setDouble(1, id);
      // Save Result in rsSet
      rsSet = prepQ.executeQuery();
      // If result is not empty
      if (rsSet != null && rsSet.next()) {
        System.out.println(rsSet.getString("INV_ID") + " | " + rsSet.getString("Name") + " | " + rsSet.getString("Type"));
        prepQ.close();
      }
      else {
        System.out.println("INV ID does not exist");
      }
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
    catch (NullPointerException nex) {
      nex.printStackTrace();
    }
    
  }
  
  public void setItemByID(Connection conn, double id) {
    // Setting Query
    String query = "INSERT INTO T_INV (Inv_ID) VALUES (?)";
    try {
      prepQ = conn.prepareStatement(query);
      // Replace "?" in Query
      prepQ.setDouble(1, id);
      prepQ.execute();
      System.out.println("Die INV ID wurde in die Tabelle eingetragen!");
      prepQ.close();
    }
    
    catch (SQLException ex) {
      ex.printStackTrace();
    }
    catch (NullPointerException nex) {
      nex.printStackTrace();
    }
    
  }
  
  public void setEmpByID(Connection conn, double id) {
    // Setting Query
    String query = "INSERT INTO T_EMP (EMP_ID) VALUES (?)";
    try {
      prepQ = conn.prepareStatement(query);
      // Replace "?" in Query
      prepQ.setDouble(1, id);
      prepQ.execute();
        System.out.println("Die EMP ID wurde in die Tabelle eingetragen!");
        prepQ.close();
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
    catch (NullPointerException nex) {
      nex.printStackTrace();
    }
    
  }

  public void deleteEmpByID(Connection conn, double id) {
    // Setting Query
    String query = "DELETE FROM T_EMP WHERE EMP_ID = (?)";
    try {
      prepQ = conn.prepareStatement(query);
      prepQ.setDouble(1, id);
      prepQ.execute();
      System.out.println("EMP " + id + " has been deleted.");
      prepQ.close();
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public void deleteInvByID(Connection conn, double id) {
    // Setting Query
    String query = "DELETE FROM T_INV WHERE INV_ID = (?)";
    try {
      prepQ = conn.prepareStatement(query);
      prepQ.setDouble(1, id);
      prepQ.execute();
      System.out.println("Item with ID " + id + " has been deleted.");
      prepQ.close();
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  

  
  
  
}
  
  
  

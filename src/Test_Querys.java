import java.sql.*;

/**
 * Created by rostwald on 03.12.2014.
 */
public class Test_Querys {

    public boolean getRowsByEmpID(double empID)
    {
        // Resultset zum Abfragen der Ergebnisse
        ResultSet sqlResultSet;
        try {
            //  (a) erzeuge preparedStatement mit Platzhalter
            // sqlDBCon is an object of class "Connection" (ref. DBConnector method connectToMSSQL)
            PreparedStatement getEmp = sqlDBCon.prepareStatement("SELECT * FROM T_EMP WHERE PK_ID = ?");
            //  (b) ersetze Platzhalter
            getEmp.setDouble(1, empID);
            //  (c) starte Abfrage
            sqlResultSet = getEmp.executeQuery();
            // (d) Verarbeite (alle) Ergebnisse
            while (sqlResultSet.next())
            {
                System.out.println("[ID=" + sqlResultSet.getDouble("EmployeeID")  + "] Name: " + sqlResultSet.getString("Name"));
            }
        } catch (SQLException e) {
            System.out.println("SQL SELECT Error:");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

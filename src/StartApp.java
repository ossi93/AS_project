/**
 * Created by rostwald on 02.12.2014.
 */
public class StartApp {

    public static void main(String[] args) {

        // Create Objects
        userGUI mainWindow = new userGUI();
        DBConnector obj_db = new DBConnector("jdbc:sqlserver://DEFR2APP31\\BO_TEST;databaseName=Test", "asproject", "Blumen99");

        // Connecting to Database
        obj_db.connectToMSSQL();

        // Showing GUI
        mainWindow.setBounds(100,100,520,400);
        mainWindow.show();

    }
}

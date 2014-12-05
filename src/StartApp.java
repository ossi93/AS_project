import java.sql.*;

/**
 * Created by rostwald on 02.12.2014.
 */
public class StartApp {

    public static void main(String[] args) {

        // Create Objects
        userGUI mainWindow = new userGUI();

        // Showing GUI
        mainWindow.setBounds(100,100,520,400);
        mainWindow.show();

    }
}

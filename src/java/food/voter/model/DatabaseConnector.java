/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.voter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author stkerr
 */
public class DatabaseConnector
{
    public static Connection openDatabaseConnection()
    {
        try
        {
            /* This needs to be changed for each individual server */

            /*
             * DO NOT COMMIT YOUR PASSWORD
             */
            return DriverManager.getConnection("jdbc:mysql://*", "*", "*");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());

            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return null;
        }
    }
}

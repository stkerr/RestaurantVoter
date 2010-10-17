
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.voter.model;

//~--- JDK imports ------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author stkerr
 */
public class RestaurantModel
{
    public static ArrayList<String> retrieveNames()
    {
        try
        {
            Connection connection = DatabaseConnector.openDatabaseConnection();
            Statement statement = connection.createStatement();

            /* Execute the query */
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM restaurant");

            ArrayList<String> theList = new ArrayList<String>();

            /* Insert the results into the map */
            while (rs.next())
            {
                theList.add(rs.getString("name"));
            }
            return theList;
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

    public static Map<String, Integer> retrieveResultsMap()
    {
        try
        {
            Connection connection = DatabaseConnector.openDatabaseConnection();
            Statement statement = connection.createStatement();

            /* Execute the query */
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name, votes FROM restaurant");

            /* Insert the results into the map */
            Map<String, Integer> resultMap = new HashMap<String, Integer>();

            while (rs.next())
            {
                resultMap.put(rs.getString("name"), rs.getInt("votes"));
            }

            return resultMap;
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

    public static boolean incrementRestaurantVote(String name)
    {
        try
        {

            /* Increment the value that we received */
            Connection connection = DatabaseConnector.openDatabaseConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE restaurant SET votes = votes + 1 WHERE name = \"" + name + "\"");

            /* Close the database */
            connection.close();

            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
//~ Formatted by Jindent --- http://www.jindent.com


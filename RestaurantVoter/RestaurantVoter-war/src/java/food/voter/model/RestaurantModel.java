
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.voter.model;

//~--- JDK imports ------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static void deleteEntry(String name)
    {
        try
        {
            Connection connection = DatabaseConnector.openDatabaseConnection();
            String query = "DELETE FROM restaurant WHERE name = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);

            /* Execute the query */
            statement.addBatch();
            statement.execute();

            /* Close the database */
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception in deleteEntry(): " + e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void resetAllVotes()
    {
        try
        {
            Connection connection = DatabaseConnector.openDatabaseConnection();
            Statement statement = connection.createStatement();

            /* Execute the query */
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE restaurant SET votes = 0;");

        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception in resetAllVotes(): " + e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void insertNewRestaurant(String name)
    {
        try
        {
            Connection connection = DatabaseConnector.openDatabaseConnection();

            String query = "INSERT INTO restaurant (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);

            /* Execute the query */
            statement.addBatch();
            statement.execute();

            /* Close the database */
            connection.close();

        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception in insertNewRestaurant(): " + e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> retrieveNames()
    {
        try
        {
            Connection connection = DatabaseConnector.openDatabaseConnection();
            Statement statement = connection.createStatement();

            /* Execute the query */
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM restaurant;");

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
            System.out.println("SQL Exception in retrieveNames(): " + e.getMessage());
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
            ResultSet rs = statement.executeQuery("SELECT name, votes FROM restaurant;");

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
            System.out.println("SQL Exception in retrieveResultsMap(): " + e.getMessage());
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
            Connection connection = DatabaseConnector.openDatabaseConnection();
            String query = "UPDATE restaurant SET votes = votes + 1 WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);

            /* Execute the query */
            statement.addBatch();
            statement.execute();

            /* Close the database */
            connection.close();

            return true;
        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception in incrementRestaurantVote(" + name + "): " + e.getMessage());
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}

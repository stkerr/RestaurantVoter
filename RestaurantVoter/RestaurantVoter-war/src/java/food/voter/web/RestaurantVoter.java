/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.voter.web;

import food.voter.model.DatabaseConnector;
import food.voter.model.RestaurantModel;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stkerr
 */
public class RestaurantVoter extends HttpServlet
{

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            /* Insert the names into a list */
            List<String> choiceList = RestaurantModel.retrieveNames();
            
            /* Pass the list along */
            request.setAttribute("choices", choiceList.toArray(new String[0]));

            /* Forward the request */
            RequestDispatcher dispatch = request.getRequestDispatcher("/voteform.jsp");
            dispatch.forward(request, response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            out.close();
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        System.out.println(request.getParameterMap().keySet().toString());
        System.out.println(request.getParameter("choiceNumber"));


        try
        {
            /* Figure out which choice was made */
            String choice = request.getParameter("choiceNumber");

            /* Increment the choice */
            RestaurantModel.incrementRestaurantVote(choice);

            /* Insert the results into the map */
            Map<String, Integer> resultMap = RestaurantModel.retrieveResultsMap();

            /* Pass the map along */
            request.setAttribute("results", resultMap);

            /* Forward to the results page */
            RequestDispatcher dispatch = request.getRequestDispatcher("/voteresults.jsp");
            dispatch.forward(request, response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            out.close();
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}

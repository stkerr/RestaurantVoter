/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.voter.web.admin;

import food.voter.model.RestaurantModel;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CRUD extends HttpServlet
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
            /* Get the list of names to send along */
             Map<String, Integer> names = RestaurantModel.retrieveResultsMap();

            /* Assign the names to the request */
            request.setAttribute("choices", names);

            /* Forward to the JSP */
            RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/admin/crud.jsp");
            dispatch.forward(request, response);
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
        PrintWriter out =
                response.getWriter();

        System.out.println(request.getParameterMap().keySet().toString());
        System.out.println(request.getParameter("choiceNumber"));

        try
        {
            if(request.getParameter("new_entry") != null)
            {
                RestaurantModel.insertNewRestaurant(request.getParameter("new_entry"));
            }
            else if(request.getParameter("delete_entry") != null)
            {
                RestaurantModel.deleteEntry(request.getParameter("delete_entry"));
            }
            else if(request.getParameter("reset_votes") != null)
            {
                RestaurantModel.resetAllVotes();
            }
            
            /* Redirect to CRUD as a GET page*/
            response.sendRedirect("admin");
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

<%--
    Document   : crud
    Created on : Oct 18, 2010, 9:55:57 AM
    Author     : stkerr
--%>

<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>
<%@page import="java.util.Iterator" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../style.css" />
    </head>
    <body>
        <%
            /* Validate that we got the available choices */
            if (request.getAttribute("choices") == null)
            {
        %>
        Choices not available!
        <%
            }
            else
            {
        %>
        <table>
            <thead>
                <tr>
                    <td>Restaurant Name</td>
                    <td>Votes</td>
                </tr>
            </thead>
            <tbody>
            <%
                /* Fetch the results map */
                Map<String,Integer> resultList = (Map<String, Integer>)(request.getAttribute("choices"));

                /* Get a list of all the names */
                Set<String> names = resultList.keySet();

                /* Iterate over all the names */
                Iterator it = names.iterator();
                while(it.hasNext())
                {
                    String currentElement = (String)it.next();
            %>
                <tr>
                    <form method="post">
                        <td><%= currentElement %></td>
                        <td><%= resultList.get(currentElement) %></td>
                        <td><input type="submit" value ="Delete" name="<%= currentElement %>"</td>
                    </form>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <%
            }
        %>
    </body>
</html>

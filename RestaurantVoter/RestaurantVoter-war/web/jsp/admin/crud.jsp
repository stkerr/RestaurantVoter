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
        <link rel="stylesheet" type="text/css" href="/css/style.css" />
        <link rel="stylesheet" type="text/css" href="/css/threecolumn.css" />
    </head>
    <body>
        <div class="colmask threecol"><div class="colmid"><div class="colleft">
                    <div class="col1">
                        <h2>Create a New Entry</h2>
                        <form method="post">
                            Restaurant Name<input type="text" name="new_entry">
                            <input type="submit">
                        </form>
                    </div>
                    <div class="col2">
                        <h2>Delete Existing Data</h2>
                        <%
                                    /* Validate that we got the available choices */
                                    if (request.getAttribute("choices") == null)
                                    {
                        %>
                        Choices not available!
                        <%                    }
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
                                                                                                Map<String, Integer> resultList = (Map<String, Integer>) (request.getAttribute("choices"));

                                                                                                /* Get a list of all the names */
                                                                                                Set<String> names = resultList.keySet();

                                                                                                /* Iterate over all the names */
                                                                                                Iterator it = names.iterator();
                                                                                                while (it.hasNext())
                                                                                                {
                                                                                                    String currentElement = (String) it.next();
                                %>
                                <tr>
                            <form method="post">
                                <input type="hidden" name="delete_entry" value="<%= currentElement%>">
                                <td><%= currentElement%></td>
                                <td><%= resultList.get(currentElement)%></td>
                                <td><input type="submit" value="Delete Entry" name="<%= currentElement%>"</td>
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
                    </div>
                    <div class="col3">
                        <h2>Update Data</h2>
                        <form method="post">
                            <input type="hidden" name="reset_votes" value="YES">
                            <input type="submit" value="Reset All Votes">
                        </form>
                    </div>
                </div>
            </div></div>
        <div id="footer">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </body>
</html>

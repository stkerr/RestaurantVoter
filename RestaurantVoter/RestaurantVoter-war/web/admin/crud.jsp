<%-- 
    Document   : crud
    Created on : Oct 18, 2010, 9:55:57 AM
    Author     : stkerr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
        <%
            String[] resultList = (String[]) (request.getAttribute("choices"));

            for (int i = 0; i < resultList.length; i++)
            {
        %>
    <tr>
        <td><%= i %></td>
        <td><%= resultList[i] %></td>
    </tr>
        <%  }
        %>
        </table>
    </body>
</html>

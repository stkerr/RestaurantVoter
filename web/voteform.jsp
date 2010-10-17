<%-- 
    Document   : voteform
    Created on : Oct 16, 2010, 9:16:49 AM
    Author     : stkerr
--%>

<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vote for a restaurant!</h1>
        <form method="post">
            <%
            String[] resultList = (String[])(request.getAttribute("choices"));

            for(int i = 0; i < resultList.length; i++)
            {
                String next = resultList[i];
                out.print("<input type=\"radio\" name=\"choiceNumber\" value=\"" + next + "\">\n");
                out.print(next);
            }
            %>
            
            <input type="submit" value="Vote!"/>
        </form>
    </body>
</html>

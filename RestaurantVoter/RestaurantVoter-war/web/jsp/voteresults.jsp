<%-- 
    Document   : voteresults
    Created on : Oct 16, 2010, 9:53:21 AM
    Author     : stkerr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Map<String, Integer> resultMap = (Map<String, Integer>)request.getAttribute("results");
            Iterator it = resultMap.keySet().iterator();
            while(it.hasNext()) {
                String next = (String)it.next();
                out.print("<p>" + next + ":" + resultMap.get(next) + "</p>");
            }
        %>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

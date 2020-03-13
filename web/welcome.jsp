<%-- 
    Document   : welcome
    Created on : 6 Mar, 2020, 9:02:00 PM
    Author     : THE IRON MAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revallidate");//http 1.1
            response.setHeader("Pragma", "no-cache");//http 1.0
            response.setHeader("Expires", "0");
            if(session.getAttribute("username")==null)
            {
                response.sendRedirect("login.jsp");
            }
        %>
        Welcome ${username}
        <form action="Logout" method="post">
            <input type="submit" value="Logout"/>
        </form>
    </body>
</html>

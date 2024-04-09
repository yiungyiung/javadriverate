<%-- 
    Document   : main
    Created on : Apr 3, 2024, 10:37:59 PM
    Author     : yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello main!</h1>
        <a href="/">index</a>
        <p>${varchange}</p>
        <table>
            <tr>
                <td>Name</td>
                <td>age</td>
                <td>email</td>
            </tr>
        <c:forEach items="${users1}" var="users1">
            <tr>    
                <td>${users1.name}</td>
                <td>${users1.age}</td>
                <td>${users1.email}</td>
            </tr>            
        </c:forEach>
        </table>
    </body>
</html>

<%-- 
    Document   : rankings
    Created on : Apr 9, 2024, 6:48:55 PM
    Author     : yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>DriveRate</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <style>
            .ranking-item {
                margin-bottom: 10px;
                padding: 10px;
                border-radius: 5px;
                background-color: #f8f9fa;
            }
            .good-vote-icon {
                color: #28a745;
            }
            .bad-vote-icon {
                color: #dc3545;
            }
        </style>
    </head>
    <body class="bg-secondary text-white">
        <%@include file="navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h2>Best Ranking/Drivers</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Vehicle Number</th>
                                <th>Number of Votes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="entry" items="${bestRankings}">
                                <tr class="ranking-item">
                                    <td><a href="/addcomment?vehicleNumber=${entry.key}">${entry.key}</a></td>
                                    <td>${entry.value}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Worst Ranking/Drivers</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Vehicle Number</th>
                                <th>Number of Votes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="entry" items="${worstRankings}">
                                <tr class="ranking-item">
                                    <td><a href="/addcomment?vehicleNumber=${entry.key}">${entry.key}</a></td>
                                    <td>${entry.value}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

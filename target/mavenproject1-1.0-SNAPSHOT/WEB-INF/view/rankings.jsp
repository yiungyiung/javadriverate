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
            /* Adjust margins and paddings as needed */
            .left-side, .right-side {
                padding: 20px;
            }
        </style>
    </head>
    <body class="bg-secondary text-white">
        <%@include file="navbar.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <!-- Left Side - Best Ranking/Drivers -->
                <div class="col-md-6 left-side">
                    <h2>Best Ranking/Drivers</h2>
                    <ul class="list-group">
                        <!-- List of best ranking/drivers -->
                        <li class="list-group-item">Driver 1</li>
                        <li class="list-group-item">Driver 2</li>
                        <li class="list-group-item">Driver 3</li>
                        <!-- Add more items as needed -->
                    </ul>
                </div>
                <!-- Right Side - Worst Ranking/Drivers -->
                <div class="col-md-6 right-side">
                    <h2>Worst Ranking/Drivers</h2>
                    <ul class="list-group bg-transparent">
                        <!-- List of worst ranking/drivers -->
                        <li class="list-group-item">Driver A</li>
                        <li class="list-group-item">Driver B</li>
                        <li class="list-group-item">Driver C</li>
                        <!-- Add more items as needed -->
                    </ul>
                </div>
            </div>
        </div>

    </body>
</html>

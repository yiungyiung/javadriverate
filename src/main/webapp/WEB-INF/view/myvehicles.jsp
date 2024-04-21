<%-- 
    Document   : myvehicles
    Created on : Apr 21, 2024, 11:56:19 AM
    Author     : yash
--%>
<%@ taglib  prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DriveRate</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body class="bg-secondary text-white">
        <%@include file="navbar.jsp" %>
        <div class="container mt-4">
            <h2>My Vehicles</h2>
            <div class="row row-cols-1 row-cols-md-2 g-4">
                <c:forEach var="vehicle" items="${vehicles}">
                    <div class="col">
                        <div class="card h-100">
                            <div class="card-body">
                                <h5 class="card-title">${vehicle.manufacturer} ${vehicle.model}  ${vehicle.vehicleNumber}</h5>
                                <p class="card-text">Year: ${vehicle.year}</p>
                                <p class="card-text">Color: ${vehicle.color}</p>
                                <p class="card-text">Category: ${vehicle.vehicleCategory}</p>
                                <p class="card-text">Rating: ${vehicle.rating}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>

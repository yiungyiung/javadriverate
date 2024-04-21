<%-- 
    Document   : comments
    Created on : Apr 21, 2024, 7:35:24 PM
    Author     : yash
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h2>Search Results</h2>
            <div class="row">
                <c:forEach var="rating" items="${ratings}">
                    <div class="col-md-4">
                        <div class="card mb-3">
                            <div class="card-header text-end">${rating.ratingTimestamp}</div>
                            <div class="card-body">
                                <h5 class="card-title">
                                    <a href="/addcomment?vehicleNumber=${rating.vehicleNumber}">
                                        Vehicle Number: ${rating.vehicleNumber}
                                    </a>
                                </h5>

                                <p class="card-text">Rating ID: ${rating.ratingId}</p>
                                <p class="card-text">Good Rating: ${rating.goodRating}</p>
                                <p class="card-text">Bad Rating: ${rating.badRating}</p>
                                <p class="card-text">Comment: ${rating.comment}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>

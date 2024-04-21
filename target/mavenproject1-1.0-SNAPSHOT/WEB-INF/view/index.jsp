<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>DriveRate</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script> <script src="closeListener.js"></script>
        <style>
            body {
                background-color: #343a40; /* Updated background color */
                color: #fff;
            }
            .jumbotron-left {
                background-color: #343a40; /* Same as body background */
                color: #fff;
                height: 100%;
            }
            .jumbotron-right {
                background-color: #343a40;
                color: #fff;
                height: 100%;
            }
            .btn-primary, .btn-secondary {
                margin-top: 20px;
                width: 150px;
            }
            .container{
                padding :20px;
            }
            .latest-rating-card {
                background-color: #f8f9fa;
                border-radius: 10px;
                padding: 10px;
                margin-top: 20px;
                width: 350px;
            }
            .rating-details {
                margin-bottom: 10px;
                color: black; /* Set the text color to black */

            }
            .detail-label {
                color: #007bff; /* Blue color for labels */
                font-weight: bold; /* Make labels bold */
            }

            .detail-value {
                color: #000; /* Black color for values */
                font-style: italic; /* Make values italic */
                margin-left: 10px; /* Add some space between labels and values */
            }
        </style>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="jumbotron jumbotron-left">
                        <h1 class="display-4">Welcome to DriveRate</h1>
                        <p class="lead">Elevating road safety through community-driven driver ratings</p>
                        <hr class="my-4">
                        <p>Navigating India's diverse and dynamic roadways presents a myriad of challenges, where ensuring safe and responsible driving practices is paramount—introducing DriveRate, a groundbreaking driver rating platform designed to harness the collective observations of bystanders and passengers alike.</p>
                        <hr class="my-4">
                        <h3>How to Use DriveRate</h3>
                        <p>DriveRate allows users to submit ratings and comments about vehicles based on their observations. You can contribute anonymously or register to access additional features, such as adding and viewing vehicles and viewing complete ratings. To get started, simply navigate to the relevant sections of the platform and follow the prompts.</p>
                        <div class="row justify-content-center align-items-center">
                            <div class="col-md-8">
                                <div class="latest-rating-card ">
                                    <h2 style="color: black;">Latest Rating</h2>
                                    <div class="rating-details">
                                        <span style="color: black;">Vehicle Number: ${ratingindex.getVehicleNumber()}</span><br>
                                        <span style="color: black;">Rating Timestamp: ${ratingindex.getRatingTimestamp()}</span><br>
                                        <span style="color: black;">Latitude: ${ratingindex.getLatitude()}</span><br>
                                        <span style="color: black;">Longitude: ${ratingindex.getLongitude()}</span><br>
                                        <span style="color: black;">Comment: ${ratingindex.getComment()}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="jumbotron jumbotron-right">
                        <h1 class="display-4">Problem Statement</h1>
                        <p class="lead">The need for a collaborative approach to promoting road safety</p>
                        <hr class="my-4">
                        <p>India's roadways are bustling with activity, but this vibrant energy often comes with its own set of challenges. From reckless driving to lack of awareness about traffic rules, there's a pressing need to address these issues collectively. DriveRate aims to fill this gap by empowering individuals to contribute to the improvement of road safety through shared observations and ratings.</p>
                        <hr class="my-4">
                        <h3>SQL and Java Maven Integration</h3>
                        <p>DriveRate leverages the power of SQL databases and Java Maven to manage and process vast amounts of data efficiently. With robust database management and seamless Java integration, DriveRate offers a reliable and scalable solution for road safety management.</p>
                    </div>
                </div>
            </div>
            <%-- Latest Rating Card --%>

    </body>
</html>
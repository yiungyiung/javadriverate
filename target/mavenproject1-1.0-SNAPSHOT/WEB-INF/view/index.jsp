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
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="jumbotron jumbotron-right">
                        <h1 class="display-4">Problem Statement</h1>
                        <p class="lead">The need for a collaborative approach to promoting road safety</p>
                        <hr class="my-4">
                        <p>India's roadways are bustling with activity, but this vibrant energy often comes with its own set of challenges. From reckless driving to lack of awareness about traffic rules, there's a pressing need to address these issues collectively. DriveRate aims to fill this gap by empowering individuals to contribute to the improvement of road safety through shared observations and ratings.</p>
                    </div>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-md-6">
                    <h2>Select User Type</h2>
                    <a class="btn btn-primary btn-lg" href="/register" role="button">Registered User</a>
                </div>
                <div class="col-md-6">
                    <h2>&nbsp;</h2>
                    <a class="btn btn-primary btn-lg" href="/anomuser" role="button">Anonymous User</a>
                </div>
            </div>
        </div>
    </body>
</html>

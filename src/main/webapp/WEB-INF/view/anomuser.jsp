<%-- 
    Document   : anomuser
    Created on : Apr 20, 2024, 3:45:40 PM
    Author     : yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>DriveRate</title>
        <style>
            body {
                background-color: #343a40; /* Updated background color */
                color: #fff; /* Text color */
                font-family: Arial, sans-serif; /* Optional: Choose a suitable font */
                margin: 0; /* Remove default margin */
                padding: 0; /* Remove default padding */
            }

            .container {
                width: 100%;
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                box-sizing: border-box;
            }

            h2 {
                text-align: center;
            }

            input[type="text"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: none;
                border-radius: 5px;
                background-color: #555; /* Dark background color for input fields */
                color: #fff; /* Text color for input fields */
                box-sizing: border-box;
            }

            input[type="submit"] {
                width: 100%;
                padding: 10px;
                border: none;
                border-radius: 5px;
                background-color: #007bff; /* Button background color */
                color: #fff; /* Button text color */
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            input[type="submit"]:hover {
                background-color: #0056b3; /* Button background color on hover */
            }
        </style>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container">
            <h2>Anonymous Login</h2>
            <form action="/anomuser" method="post">
                <input type="text" name="username" placeholder="Username">
                <input type="submit" value="Login">
            </form>
        </div>

    </body>
</html>
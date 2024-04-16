<%-- 
    Document   : register
    Created on : Apr 10, 2024, 12:20:29 AM
    Author     : yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DriveRate</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <style>
            .cont {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;

            }
            .container {
                max-width: 800px;
                margin: 50px auto;
                text-align: center;
            }
            h1 {

            }
            p {

            }
            img{
                width: 960px;
                height:540px;

            }
            blockquote {
                font-style: italic;
                margin-top: 20px;

            }
        </style>
    </head>
    <body class="bg-secondary text-white">
        <div class="cont">
            <%@include file="navbar.jsp" %> 
            <div class="container">
                <h1>Oops! Page Not Found</h1>
                <p>We're sorry, but the page you are looking for seems to be missing. It may have been moved, deleted, or never existed.</p>
                <p>Here are a few things you can try:</p>
                <ul>
                    <li>Double-check the URL for any typos.</li>
                    <li>Go back to the <a href="/">homepage</a>.</li>
                </ul>
                <blockquote>"In the midst of difficulty lies opportunity." - Albert Einstein</blockquote>
            </div>
        </div>
    </body>
</html>

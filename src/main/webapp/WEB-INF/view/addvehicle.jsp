<%-- 
    Document   : addvehicle
    Created on : Apr 20, 2024, 8:45:24 PM
    Author     : yash
--%>
<%@ taglib  prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>DriveRate</title>
  <style>
        body {
            background-color: #343a40; /* Updated background color */
            color: #fff;
            font-family: Arial, sans-serif; /* Optional: Choose a suitable font */
            margin: 0; /* Remove default margin */
            padding: 0; /* Remove default padding */
        }
        .container {
            width: 50%;
            margin: auto;
            padding: 20px;
            border-radius: 10px;
            background-color: #555;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }
        h1 {
            text-align: center;
        }
        form {
            margin-top: 20px;
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 10px;
            font-size: 18px;
        }
        input[type="text"], select {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: none;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Vehicle Registration Form</h1>
        <form action="/addvehicle" method="post">
            <label for="vehicleNumber">Vehicle Number:</label>
            <input type="text" id="vehicleNumber" name="vehicleNumber" required>

            <label for="year">Year:</label>
            <select id="year" name="year" required>
                <option value="">Select Year</option>
                <%
                    for (int i = 2024; i >= 1900; i--) {
                %>
                <option value="<%= i %>"><%= i %></option>
                <%
                    }
                %>
            </select>

            <label for="manufacturer">Manufacturer:</label>
            <input type="text" id="manufacturer" name="manufacturer" required>

            <label for="model">Model:</label>
            <input type="text" id="model" name="model" required>

            <label for="color">Color:</label>
            <input type="text" id="color" name="color" required>

            <label for="vehicleCategory">Vehicle Category:</label>
            <select id="vehicleCategory" name="vehicleCategory" required>
                <option value="">Select Category</option>
                <option value="Car">Car</option>
                <option value="Motorcycle">Motorcycle</option>
                <option value="Truck">Truck</option>
                <!-- Add more options as needed -->
            </select>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
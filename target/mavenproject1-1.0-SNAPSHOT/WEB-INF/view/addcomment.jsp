<%-- 
    Document   : addcomment
    Created on : Apr 9, 2024, 6:01:10 PM
    Author     : yash
--%>

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
            <form>
                <div class="mb-3">
                    <label for="number" class="form-label">Number</label>
                    <input type="text" class="form-control" name="number" placeholder="Enter Vehicle Number" required>
                </div>
                <div class="mb-3">
                    <label for="state" class="form-label">State</label>
                    <select class="form-select" name="state" required>
                        <option value="">Select State</option>
                        <option value="AP">AP - Andhra Pradesh</option>
                        <option value="AR">AR - Arunachal Pradesh</option>
                        <option value="AS">AS - Assam</option>
                        <option value="BR">BR - Bihar</option>
                        <option value="CG">CG - Chhattisgarh</option>
                        <option value="GA">GA - Goa</option>
                        <option value="GJ">GJ - Gujarat</option>
                        <option value="HR">HR - Haryana</option>
                        <option value="HP">HP - Himachal Pradesh</option>
                        <option value="JK">JK - Jammu and Kashmir</option>
                        <option value="JH">JH - Jharkhand</option>
                        <option value="KA">KA - Karnataka</option>
                        <option value="KL">KL - Kerala</option>
                        <option value="MP">MP - Madhya Pradesh</option>
                        <option value="MH">MH - Maharashtra</option>
                        <option value="MN">MN - Manipur</option>
                        <option value="ML">ML - Meghalaya</option>
                        <option value="MZ">MZ - Mizoram</option>
                        <option value="NL">NL - Nagaland</option>
                        <option value="OD">OD - Odisha</option>
                        <option value="PB">PB - Punjab</option>
                        <option value="RJ">RJ - Rajasthan</option>
                        <option value="SK">SK - Sikkim</option>
                        <option value="TN">TN - Tamil Nadu</option>
                        <option value="TS">TS - Telangana</option>
                        <option value="TR">TR - Tripura</option>
                        <option value="UK">UK - Uttarakhand</option>
                        <option value="UP">UP - Uttar Pradesh</option>
                        <option value="WB">WB - West Bengal</option>
                        <!-- Add more options for other states -->
                    </select>
                </div>
                <div class="mb-3">
                    <label for="comment" class="form-label">Comment</label>
                    <textarea class="form-control" id="comment" rows="3" placeholder="Enter Comment" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Add Comment</button>
            </form>
        </div>

    </body>
</html>

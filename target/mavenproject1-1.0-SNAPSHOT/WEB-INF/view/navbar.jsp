<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">DriveRate</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/comments">Comments</a>
                </li>
                <li class="nav-item">
                    <button class="btn bg-transparent text-white" onclick="location.href = '/addcomment'">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
                        </svg>
                    </button>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rankings">Rankings</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        States
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/search?value=AP">AP - Andhra Pradesh</a></li>
                        <li><a class="dropdown-item" href="/search?value=AR">AR - Arunachal Pradesh</a></li>
                        <li><a class="dropdown-item" href="/search?value=AS">AS - Assam</a></li>
                        <li><a class="dropdown-item" href="/search?value=BR">BR - Bihar</a></li>
                        <li><a class="dropdown-item" href="/search?value=CG">CG - Chhattisgarh</a></li>
                        <li><a class="dropdown-item" href="/search?value=GA">GA - Goa</a></li>
                        <li><a class="dropdown-item" href="/search?value=GJ">GJ - Gujarat</a></li>
                        <li><a class="dropdown-item" href="/search?value=HR">HR - Haryana</a></li>
                        <li><a class="dropdown-item" href="/search?value=HP">HP - Himachal Pradesh</a></li>
                        <li><a class="dropdown-item" href="/search?value=JK">JK - Jammu and Kashmir</a></li>
                        <li><a class="dropdown-item" href="/search?value=JH">JH - Jharkhand</a></li>
                        <li><a class="dropdown-item" href="/search?value=KA">KA - Karnataka</a></li>
                        <li><a class="dropdown-item" href="/search?value=KL">KL - Kerala</a></li>
                        <li><a class="dropdown-item" href="/search?value=MP">MP - Madhya Pradesh</a></li>
                        <li><a class="dropdown-item" href="/search?value=MH">MH - Maharashtra</a></li>
                        <li><a class="dropdown-item" href="/search?value=MN">MN - Manipur</a></li>
                        <li><a class="dropdown-item" href="/search?value=ML">ML - Meghalaya</a></li>
                        <li><a class="dropdown-item" href="/search?value=MZ">MZ - Mizoram</a></li>
                        <li><a class="dropdown-item" href="/search?value=NL">NL - Nagaland</a></li>
                        <li><a class="dropdown-item" href="/search?value=OD">OD - Odisha</a></li>
                        <li><a class="dropdown-item" href="/search?value=PB">PB - Punjab</a></li>
                        <li><a class="dropdown-item" href="/search?value=RJ">RJ - Rajasthan</a></li>
                        <li><a class="dropdown-item" href="/search?value=SK">SK - Sikkim</a></li>
                        <li><a class="dropdown-item" href="/search?value=TN">TN - Tamil Nadu</a></li>
                        <li><a class="dropdown-item" href="/search?value=TS">TS - Telangana</a></li>
                        <li><a class="dropdown-item" href="/search?value=TR">TR - Tripura</a></li>
                        <li><a class="dropdown-item" href="/search?value=UK">UK - Uttarakhand</a></li>
                        <li><a class="dropdown-item" href="/search?value=UP">UP - Uttar Pradesh</a></li>
                        <li><a class="dropdown-item" href="/search?value=WB">WB - West Bengal</a></li>
                    </ul>
                </li>
            </ul>
            <!-- Register and Login Buttons -->

            <form class="d-flex" action="/search">
                <input class="form-control me-2" name="value" type="search" placeholder="Enter Plate Number" aria-label="Search">
                    <button class="btn btn-outline-info type="submit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                        </svg>
                    </button>
            </form>
            <%
// Check if the user is logged in
String username = (String) request.getSession().getAttribute("username");
String anom = (String) request.getSession().getAttribute("anom");
String id = (String) request.getSession().getAttribute("id");
System.out.println(username+" "+id+" "+anom);
if (username != null && anom.equals("0")) {
            %>
            <!-- Display username and logout button -->
            <div class="d-flex align-items-center ps-3">
                <span class="text-white me-3">Welcome, <%= username %></span>
                <div class="dropdown">
                    <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M2 2.5A.5.5 0 0 1 2.5 2h11a.5.5 0 0 1 .5.5v11a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11zM1 2.5A1.5 1.5 0 0 1 2.5 1h11A1.5 1.5 0 0 1 15 2.5v11A1.5 1.5 0 0 1 13.5 15h-11A1.5 1.5 0 0 1 1 13.5v-11z"/>
                            <path fill-rule="evenodd" d="M2.5 6a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1h-10a.5.5 0 0 1-.5-.5zM2 9.5a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1h-10a.5.5 0 0 1-.5-.5z"/>
                            <path fill-rule="evenodd" d="M2.5 13a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1h-10a.5.5 0 0 1-.5-.5z"/>
                        </svg>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton">
                        <li><a class="dropdown-item" href="/addvehicle">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-car-front" viewBox="0 0 16 16">
                                    <path d="M4 9a1 1 0 1 1-2 0 1 1 0 0 1 2 0m10 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0M6 8a1 1 0 0 0 0 2h4a1 1 0 1 0 0-2zM4.862 4.276 3.906 6.19a.51.51 0 0 0 .497.731c.91-.073 2.35-.17 3.597-.17s2.688.097 3.597.17a.51.51 0 0 0 .497-.731l-.956-1.913A.5.5 0 0 0 10.691 4H5.309a.5.5 0 0 0-.447.276"/>
                                    <path d="M2.52 3.515A2.5 2.5 0 0 1 4.82 2h6.362c1 0 1.904.596 2.298 1.515l.792 1.848c.075.175.21.319.38.404.5.25.855.715.965 1.262l.335 1.679q.05.242.049.49v.413c0 .814-.39 1.543-1 1.997V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.338c-1.292.048-2.745.088-4 .088s-2.708-.04-4-.088V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.892c-.61-.454-1-1.183-1-1.997v-.413a2.5 2.5 0 0 1 .049-.49l.335-1.68c.11-.546.465-1.012.964-1.261a.8.8 0 0 0 .381-.404l.792-1.848ZM4.82 3a1.5 1.5 0 0 0-1.379.91l-.792 1.847a1.8 1.8 0 0 1-.853.904.8.8 0 0 0-.43.564L1.03 8.904a1.5 1.5 0 0 0-.03.294v.413c0 .796.62 1.448 1.408 1.484 1.555.07 3.786.155 5.592.155s4.037-.084 5.592-.155A1.48 1.48 0 0 0 15 9.611v-.413q0-.148-.03-.294l-.335-1.68a.8.8 0 0 0-.43-.563 1.8 1.8 0 0 1-.853-.904l-.792-1.848A1.5 1.5 0 0 0 11.18 3z"/>

                                </svg>
                                Add Vehicle
                            </a></li>
                        <li><a class="dropdown-item" href="/myvehicles">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-car" viewBox="0 0 16 16">
                                    <path d="M2.52 3.515A2.5 2.5 0 0 1 4.82 2h6.362c1 0 1.904.596 2.298 1.515l.792 1.848c.075.175.21.319.38.404.5.25.855.715.965 1.262l.335 1.679q.05.242.049.49v.413c0 .814-.39 1.543-1 1.997V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.338c-1.292.048-2.745.088-4 .088s-2.708-.04-4-.088V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.892c-.61-.454-1-1.183-1-1.997v-.413a2.5 2.5 0 0 1 .049-.49l.335-1.68c.11-.546.465-1.012.964-1.261a.8.8 0 0 0 .381-.404l.792-1.848ZM3 10a1 1 0 1 0 0-2 1 1 0 0 0 0 2m10 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2M6 8a1 1 0 0 0 0 2h4a1 1 0 1 0 0-2zM2.906 5.189a.51.51 0 0 0 .497.731c.91-.073 3.35-.17 4.597-.17s3.688.097 4.597.17a.51.51 0 0 0 .497-.731l-.956-1.913A.5.5 0 0 0 11.691 3H4.309a.5.5 0 0 0-.447.276L2.906 5.19Z"/>

                                </svg>
                                My Vehicle
                            </a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><form action="/logout"><button class="dropdown-item" type="submit">Logout</button></form></li>
                    </ul>
                </div>
            </div>

            <% } else if (username != null && anom.equals("1")) { %> 
            <!-- Display username and logout button -->
            <div class="d-flex align-items-center ps-3">
                <span class="text-white me-3">Welcome, <%= username %></span>
                <form action="/logoutanom?id=<%= id %>">
                    <button class="btn btn-outline-light" type="submit">Logout</button>
                </form>
            </div>
            <% System.out.println("ui");} else { %>
            <!-- Display register and login buttons -->
            <div class="d-flex align-items-center ps-3">
                <button class="btn btn-outline-light me-3" onclick="location.href = '/register'">Register</button>
                <button class="btn btn-outline-light me-3" onclick="location.href = '/login'">Login</button>
            </div>
            <% } %>
        </div>
    </div>
</nav>

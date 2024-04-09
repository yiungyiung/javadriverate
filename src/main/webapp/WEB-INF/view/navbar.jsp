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
                        <li><a class="dropdown-item" href="/?state=AP">AP - Andhra Pradesh</a></li>
                        <li><a class="dropdown-item" href="/?state=AR">AR - Arunachal Pradesh</a></li>
                        <li><a class="dropdown-item" href="/?state=AS">AS - Assam</a></li>
                        <li><a class="dropdown-item" href="/?state=BR">BR - Bihar</a></li>
                        <li><a class="dropdown-item" href="/?state=CG">CG - Chhattisgarh</a></li>
                        <li><a class="dropdown-item" href="/?state=GA">GA - Goa</a></li>
                        <li><a class="dropdown-item" href="/?state=GJ">GJ - Gujarat</a></li>
                        <li><a class="dropdown-item" href="/?state=HR">HR - Haryana</a></li>
                        <li><a class="dropdown-item" href="/?state=HP">HP - Himachal Pradesh</a></li>
                        <li><a class="dropdown-item" href="/?state=JK">JK - Jammu and Kashmir</a></li>
                        <li><a class="dropdown-item" href="/?state=JH">JH - Jharkhand</a></li>
                        <li><a class="dropdown-item" href="/?state=KA">KA - Karnataka</a></li>
                        <li><a class="dropdown-item" href="/?state=KL">KL - Kerala</a></li>
                        <li><a class="dropdown-item" href="/?state=MP">MP - Madhya Pradesh</a></li>
                        <li><a class="dropdown-item" href="/?state=MH">MH - Maharashtra</a></li>
                        <li><a class="dropdown-item" href="/?state=MN">MN - Manipur</a></li>
                        <li><a class="dropdown-item" href="/?state=ML">ML - Meghalaya</a></li>
                        <li><a class="dropdown-item" href="/?state=MZ">MZ - Mizoram</a></li>
                        <li><a class="dropdown-item" href="/?state=NL">NL - Nagaland</a></li>
                        <li><a class="dropdown-item" href="/?state=OD">OD - Odisha</a></li>
                        <li><a class="dropdown-item" href="/?state=PB">PB - Punjab</a></li>
                        <li><a class="dropdown-item" href="/?state=RJ">RJ - Rajasthan</a></li>
                        <li><a class="dropdown-item" href="/?state=SK">SK - Sikkim</a></li>
                        <li><a class="dropdown-item" href="/?state=TN">TN - Tamil Nadu</a></li>
                        <li><a class="dropdown-item" href="/?state=TS">TS - Telangana</a></li>
                        <li><a class="dropdown-item" href="/?state=TR">TR - Tripura</a></li>
                        <li><a class="dropdown-item" href="/?state=UK">UK - Uttarakhand</a></li>
                        <li><a class="dropdown-item" href="/?state=UP">UP - Uttar Pradesh</a></li>
                        <li><a class="dropdown-item" href="/?state=WB">WB - West Bengal</a></li>
                    </ul>
                </li>
            </ul>
            <!-- Register and Login Buttons -->

            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Enter Plate Number" aria-label="Search">
                    <button class="btn btn-outline-info type="submit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                        </svg>
                    </button>
            </form>
            <div class="d-flex align-items-center ps-3 ">
                <button class="btn btn-outline-light me-3" onclick="location.href = '/register'">Register</button>
                <button class="btn btn-outline-light me-3" onclick="location.href = '/login'">Login</button>
            </div>
        </div>
    </div>
</nav>

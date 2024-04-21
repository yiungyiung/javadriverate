window.onbeforeunload = function() {
    // Send an AJAX request to notify the server
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/notifyClose", true);
    xhr.send();
};
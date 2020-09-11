function validate() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("password-again").value;
    console.log(password);
    console.log(confirmPassword);
    if (password != confirmPassword) {
        alert("Passwords do not match.");
        return false;
    }
    return true;
}
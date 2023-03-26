function validateForm() {
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var contact = document.getElementById("contact");
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    var contactPattern = /^\d{10}$/;

    if (email.value.trim() === "") {
        alert("Please enter your email address");
        email.focus();
        return false;
    }

    if (!emailPattern.test(email.value)) {
        alert("Please enter a valid email address");
        email.focus();
        return false;
    }

    if (password.value.trim() === "") {
        alert("Please enter your password");
        password.focus();
        return false;
    }

    if (password.value.length > 25) {
        alert("Password must be less than 20 characters");
        password.focus();
        return false;
    }

    if (contact.value.trim() === "") {
        alert("Please enter your contact number");
        contact.focus();
        return false;
    }

    if (!contactPattern.test(contact.value)) {
        alert("Please enter a valid 10-digit contact number");
        contact.focus();
        return false;
    }

    return true;
}


// Get the password fields and error message element
const passwordField = document.getElementById('password');
const repeatPasswordField = document.getElementById('repeat_password');
const errorMsg = document.getElementById('errorMsg');

// Function to check if passwords match
function checkPasswordMatch() {
    if (passwordField.value !== repeatPasswordField.value) {
        errorMsg.style.display = 'block';  // Show the error message
    } else {
        errorMsg.style.display = 'none';   // Hide the error message
    }
}

// Attach event listeners to the password fields
passwordField.addEventListener('input', checkPasswordMatch);
repeatPasswordField.addEventListener('input', checkPasswordMatch);

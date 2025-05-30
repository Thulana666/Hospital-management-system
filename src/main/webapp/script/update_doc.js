// Validate password must be lower than or equal into 8 characters

document.getElementById("passwordInput").addEventListener("input", function () {
    const password = this.value;
    const errorMsg = document.getElementById("errorMsg3");

    // Check if input length exceeds 8 characters (this check is just for extra safety)
    if (password.length > 8) {
        this.value = password.slice(0, 8);  // Truncate the input to 8 characters
    }

    // If input length is 8, show the message
    if (password.length === 8) {
        errorMsg.style.display = "block";  // Show the error message when reaching the limit
    } else {
        errorMsg.style.display = "none";   // Hide the message otherwise
    }
});


// Function for prompt box

function confirmDeletion(event) {
    // Display the confirmation dialog
    var userConfirmed = confirm("Do you want to delete this permanently?");

    // If the user clicks "OK", allow form submission
    if (userConfirmed) {
        alert("Deleted successfully.");
        return true;  // Form will submit
    } else {
        // If the user clicks "Cancel", prevent form submission
        event.preventDefault();
        return false;
    }
}
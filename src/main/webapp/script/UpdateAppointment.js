/**
 * 
 */
function validateTime() {
    const timeInput = document.getElementById('timeInput').value;
    const message = document.getElementById('message');
    
    // Regular expression to match HH:MM format
    const timePattern = /^(?:[01]\d|2[0-3])\.[0-5]\d$/;

    if (!timePattern.test(timeInput)) {
        message.textContent = 'Please enter a valid time in HH:MM format.';
    } else {
        message.textContent = ''; // Clear any previous message
    }
}

function validateVenue() {
    const venueInput = document.getElementById('venueInput').value.trim(); // Trim whitespace
    const venueMessage = document.getElementById('venueMessage');

    // Check if the venue input is empty
    if (venueInput === '') {
        venueMessage.textContent = 'Venue cannot be empty.';
    } else {
        venueMessage.textContent = ''; // Clear any previous message
    }
}

function myFunction() {
  alert("Appointment updated successfully");
}


// Get the "My Appointments" button and the appointments container
const myAppointmentsBtn = document.getElementById('navScrollBtn');
const appointmentContainer = document.querySelector('.scroll-down');

// Add click event listener to scroll to the appointments container
myAppointmentsBtn.onclick = function () {
    appointmentContainer.scrollIntoView({
        behavior: 'smooth'  // Enable smooth scrolling
    });
};

// Get the modal and button elements
const modal = document.getElementById("loginModal");
const openModalBtn = document.getElementById("openModalBtn");
const closeModalBtn = document.querySelector(".close-btn");

// Open modal when the button is clicked
openModalBtn.onclick = function () {
  modal.style.display = "flex"; // Show the modal using flexbox
};

// Close modal when the close button is clicked
closeModalBtn.onclick = function () {
  modal.style.display = "none"; // Hide the modal
};

// Close modal when clicking outside the modal content
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};

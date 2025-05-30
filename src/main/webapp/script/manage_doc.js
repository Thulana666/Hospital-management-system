const submitBtn = document.getElementById("submitBtn");

// Validate phone number by removing non numaric characters and length

document.getElementById("phone").addEventListener("input", function () {
  const phoneInputField = this;
  const errorMsg = document.getElementById("errorMsg1");

  // Remove any non-numeric characters from the input
  phoneInputField.value = phoneInputField.value.replace(/\D/g, '');  // \D matches any non-digit characters

  // Regular expression to check if input is exactly 10 digits
  const phonePattern = /^\d{10}$/;

  // Check if the input has exactly 10 digits
  if (!phonePattern.test(phoneInputField.value)) {
    errorMsg.style.display = "block"; // Show the error message
	submitBtn.disabled = true; // Disable the submit button
  } else {
    errorMsg.style.display = "none"; // Hide the error message
	submitBtn.disabled = false; // Enable the submit button
  }
});



// Validate doctor experience by input only above 1

document.getElementById("experience").addEventListener("input", function () {
  const experienceInput = this;
  const errorMsg = document.getElementById("errorMsg2");

  // Ensure that the value is not less than 1
  if (experienceInput.value < 1) {
    errorMsg.style.display = "block";  // Show error message
    experienceInput.value = "";        // Clear the input if it's less than 1
	submitBtn.disabled = true; // Disable the submit button
  } else {
    errorMsg.style.display = "none";   // Hide error message if valid
	submitBtn.disabled = false; // Enable the submit button
  }
});



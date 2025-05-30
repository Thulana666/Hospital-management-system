

function onAddRow(event) {
    tbodyEl = document.querySelector("tbody");
    event.preventDefault();
    console.log('method');
    tbodyEl.innerHTML += `
        <br><tr>
                    <center><label>Next Appointment Date :<input type="date"></input></label></center>
        </tr>`;
}

function checkPatientID() {
   	 // check if input is less than 3 or greater than 3
   	 var value = document.getElementById("patientID").value;
   	 if (value.length < 3 || value.length > 3) {
   	   alert("Patient ID must be 3 digits");
   	 } 
}

function enableButton(){
    if(document.getElementById("treatment").value == null){
        document.getElementById("submitBtn").disabled = true;
    }else{
        document.getElementById("submitBtn").disabled = false;
    }
   
}

function checkInputs(){
	var mg = document.getElementById("mg").value;
	var dose = document.getElementById("dose").value;
	var day = document.getElementById("day").value;
	
	if(mg < 0){
		alert("Invalid mg");
	}
	if(dose < 0){
		alert("Invalid dosage");
	}
	if(day < 0){
		alert("Invalid days format");
	}
}

function disableButton(){
    if(document.getElementById("addBtn").clicked){
        document.getElementById("addBtn").disabled=false;
    }
    else{
        document.getElementById("addBtn").disabled=true;
    }
}

function myFunction() {
  alert("Prescription added successfully");
}

function checkPatientID() {
	 // check if input is less than 3 or greater than 3
	 var value = document.getElementById("patientID").value;
	 if (value.length < 3 || value.length > 3) {
	   alert("Patient ID must be 3 digits");
	 } 
}



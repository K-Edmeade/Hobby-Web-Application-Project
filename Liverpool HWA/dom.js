'use strict';

// Selectors

// Divs
let resultsDiv = document.querySelector("#resultsDiv");

// Inputs

let fName = document.querySelector("#firstNameInput");
let lName = document.querySelector("#lastNameInput");
let dob = document.querySelector("#dateOfBirthInput");
let tFee = document.querySelector("#transferFeeInput");
let nat = document.querySelector("#nationalityInput");
let pos = document.querySelector("#positionInput");
let id = document.querySelector("#idInput");

// Buttons

let creBtn = document.querySelector("#creBtn");
let updateBtn = document.querySelector("#updBtn");
let delBtn = document.querySelector("#delBtn");

// Functions
let printResults = (results) => {
    let entryDiv = document.createElement("div")
    entryDiv.setAttribute("class", "entry-div")
    entryDiv.textContent = 
    `${results.id} | ${results.firstName} | ${results.lastName} | ${results.dateOfBirth} 
    | £${results.transferFee} | ${results.nationality} | ${results.position}`;

    let entryParent = document.createElement("div");
    entryParent.setAttribute("class", "entry-parent");

    let delBtn = document.createElement("button");
    delBtn.textContent = "Delete";
    delBtn.type = "button";
    delBtn.setAttribute("Class", "btn btn-danger btn-sm");
    delBtn.setAttribute("onClick", `deleteById(${results.id})`);

    entryParent.appendChild(entryDiv);
    entryParent.appendChild(delBtn);
    resultsDiv.appendChild(entryParent);
}

let getAll = () => {
    axios.get("http://localhost:8080/players/getAll")
        .then(res => {
            resultsDiv.innerHTML = "";

            let results = res.data;

            for (let result of results) {
                printResults(result);
            }
        }).catch(err => { console.log(err); });
}

let create = () => {
    let obj = {
        "firstName": fName.value,
        "lastName": lName.value,
        "dateOfBirth": dob.value,
        "transferFee": tFee.value,
        "nationality": nat.value,
        "position": pos.value

    }
    axios.post("http://localhost:8080/players/create", obj)
        .then(res => {
            getAll();
        })
        .catch(err => { console.log(err); });
}

let update = () => {
    let obj = {
        "firstName": fName.value,
        "lastName": lName.value,
        "dateOfBirth": dob.value,
        "transferFee": tFee.value,
        "nationality": nat.value,
        "position": pos.value

    }
    axios.put(`http://localhost:8080/players/update/${id.value}`, obj)
        .then((res) => {
            getAll();
        })
        .catch((err) => { console.error(err); })
}

let deleteById = (id) => {

    axios.delete(`http://localhost:8080/players/delete/${id}`)
        .then((res) => {
            getAll();
        })
        .catch((err) => {console.log(err); })

}

creBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
delBtn.addEventListener("click", deleteById);
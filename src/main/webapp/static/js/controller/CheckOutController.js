
export let CheckOutController = {
    inputEmail: null,
    inputFirstName: null,
    inputLastName: null,
    inputAddress1: null,
    inputAddress2: null,
    inputCity: null,
    inputZipCode: null,
    checkOutButton: null,
    initCheckOutController: function () {
        CheckOutController.inputEmail = document.getElementById("inputEmail");
        CheckOutController.inputFirstName = document.getElementById("inputFirstName");
        CheckOutController.inputLastName = document.getElementById("inputLastName");
        CheckOutController.inputAddress1 = document.getElementById("inputAddress");
        CheckOutController.inputAddress2 = document.getElementById("inputAddress2");
        CheckOutController.inputCity = document.getElementById("inputCity");
        CheckOutController.inputZipCode = document.getElementById("inputZip");
        CheckOutController.checkOutButton = document.getElementById("checkoutButton");
        CheckOutController.checkOutButton.addEventListener('click', CheckOutController.startCheckOut);
    },
    startCheckOut: function () {
        validateInputFields();
    }
}

function validateInputFields() {
    validateEmailInputField();
}

function validateEmailInputField() {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(CheckOutController.inputEmail.value))
    {
        return true;
    }
    alert("You have entered an invalid email address!");
    return false;
}

function validateFirstNameInputField() {

}

function validateLastNameInputField() {

}

function validateAddress1InputField() {

}

function validateCityInputField() {

}

function validateZipCodeInputField() {

}

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
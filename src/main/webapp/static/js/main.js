import {CartController} from "./controller/CartController.js";
import {CheckOutController} from "./controller/CheckOutController.js";
import {PaymentController} from "./controller/PaymentController.js";
import {ProductController} from "./controller/ProductController.js";

function init() {
    setEventListenersToFilterButtons();
    CartController.initCart();
    CheckOutController.initCheckOutController();
    PaymentController.initPayment();
    ProductController.initProducts();
}


function setEventListenersToFilterButtons() {
    const filterByCategoryButtons = document.querySelectorAll(".filterCategory");
    filterByCategoryButtons.forEach((button) => button.addEventListener('click', searchByCategory));

    const filterBySupplierButtons = document.querySelectorAll(".filterSupplier");
    filterBySupplierButtons.forEach((button) => button.addEventListener('click', searchBySupplier));

    const getAllButton = document.getElementById("getAllButton");
    getAllButton.addEventListener('click', getAllProducts);

}

function searchByCategory(clickEvent) {
    let categoryId = clickEvent.currentTarget.dataset.categoryId;
    ProductController.filterProductsByCategory(categoryId);
}


function searchBySupplier(clickEvent) {
    let supplierId = clickEvent.currentTarget.dataset.supplierId;
    ProductController.filterProductBySupplier(supplierId);
}

function getAllProducts() {
    ProductController.getAllProducts();
}


init();
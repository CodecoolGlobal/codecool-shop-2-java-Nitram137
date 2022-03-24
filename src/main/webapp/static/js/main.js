import {filterByCategoryController} from "./controller/filterByCategoryController.js";
import {filterBySupplierController} from "./controller/filterBySupplierController.js";
import {CartController} from "./controller/CartController.js";

function init() {
    setEventListenersToFilterButtons();
    CartController.initCart();
}


function setEventListenersToFilterButtons() {
    const filterByCategoryButtons = document.querySelectorAll(".filterCategory");
    filterByCategoryButtons.forEach((button) => button.addEventListener('click', searchByCategory));

    const filterBySupplierButtons = document.querySelectorAll(".filterSupplier");
    filterBySupplierButtons.forEach((button) => button.addEventListener('click', searchBySupplier));

}

function searchByCategory(clickEvent) {
    let categoryId = clickEvent.currentTarget.dataset.categoryId;
    filterByCategoryController.filterByCategory(categoryId);
}


function searchBySupplier(clickEvent) {
    let supplierId = clickEvent.currentTarget.dataset.supplierId;
    filterBySupplierController.filterBySupplier(supplierId);
}


init();
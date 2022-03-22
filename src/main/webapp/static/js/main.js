import {filterByCategoryController} from "./controller/filterByCategoryController.js";

function init() {
    setEventListenersToFilterButtons();
}


function setEventListenersToFilterButtons() {
    const buttons = document.querySelectorAll(".filterCategory");
    buttons.forEach((button) => button.addEventListener('click', searchByCategory));
}

function searchByCategory(clickEvent) {
    let categoryId = clickEvent.currentTarget.dataset.categoryId;
    filterByCategoryController.filterByCategory(categoryId);
}


init();
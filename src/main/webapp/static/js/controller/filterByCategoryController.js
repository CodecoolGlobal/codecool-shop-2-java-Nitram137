import {dataHandler} from "../data/dataHandler.js";
import {cardBuilder} from "../view/cardBuilder.js";
import {CartController} from "./CartController.js";

export let filterByCategoryController = {
    filterByCategory: function (categoryId) {
        dataHandler.getProductsByCategory(categoryId).then((response) => {
            cardBuilder.buildCards(response);
            CartController.updateAddToCartButtons();
        }).catch((error) => {
            alert(error);
        });
    }
}
import {dataHandler} from "../data/dataHandler.js";
import {cardBuilder} from "../view/cardBuilder.js";

export let filterByCategoryController = {
    filterByCategory: function (categoryId) {
        dataHandler.getProductsByCategory(categoryId).then((response) => {
            cardBuilder.buildCards(response);
        });
    }
}
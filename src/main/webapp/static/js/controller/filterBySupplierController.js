import {dataHandler} from "../data/dataHandler.js";
import {cardBuilder} from "../view/cardBuilder.js";
import {CartController} from "./CartController.js";


export let filterBySupplierController = {
    filterBySupplier: function (supplierId) {
        dataHandler.getProductsBySupplier(supplierId).then((response) => {
            cardBuilder.buildCards(response);
            CartController.updateAddToCartButtons();
        }).catch((error) => {
            alert(error);
        });
    }
}
import {dataHandler} from "../data/dataHandler.js";
import {cardBuilder} from "../view/cardBuilder.js";


export let filterBySupplierController = {
    filterBySupplier: function (supplierId) {
        dataHandler.getProductsBySupplier(supplierId).then((response) => {
            cardBuilder.buildCards(response);
        }).catch((error) => {
            alert(error);
        });
    }
}
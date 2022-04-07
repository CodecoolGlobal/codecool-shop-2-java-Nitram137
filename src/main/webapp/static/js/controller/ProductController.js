import {dataHandler} from "../data/dataHandler.js";
import {cardBuilder} from "../view/cardBuilder.js";
import {CartController} from "./CartController.js";

export let ProductController = {
    initProducts: function() {
        dataHandler.getProducts().then((response) => {
            ProductController.products = response;
        }).catch((error) => {
            alert(error);
        });
    },
    products: null,
    filterProductsByCategory: function(categoryId) {
        let filteredProducts = ProductController.products.filter(product => product.categoryId.toString() === categoryId);
        cardBuilder.buildCards(filteredProducts);
        CartController.updateAddToCartButtons();
    },
    filterProductBySupplier: function (supplierId) {
        let filteredProducts = ProductController.products.filter(product => product.supplierId.toString() === supplierId);
        cardBuilder.buildCards(filteredProducts);
        CartController.updateAddToCartButtons();
    },
    getAllProducts: function() {
        cardBuilder.buildCards(ProductController.products);
        CartController.updateAddToCartButtons();
    }
}

export let CartController = {
    container: new Map(),
    initCart: function () {
        initAddToCartButtons();
    },
    updateAddToCartButtons: function() {
        initAddToCartButtons();
    },
    addToCart: function (productId) {

    },
    removeProduct: function (productId) {

    },
    updateContent: function () {

    },
    showCart: function () {

    }
}

function initAddToCartButtons() {
    const buttons = document.querySelectorAll(".cart-button");
    buttons.forEach((button) => button.addEventListener('click', addProductToCart));
}

function addProductToCart(clickEvent) {
    const productId = clickEvent.currentTarget.dataset.productId;
    CartController.addToCart(productId);
}
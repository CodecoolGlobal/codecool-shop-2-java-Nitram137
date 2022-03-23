
export let CartController = {
    container: new Map(),
    modal: null,
    cartItem: null,
    initCart: function () {
        initAddToCartButtons();
        CartController.modal = document.getElementById('modal');
        CartController.cartItem = document.getElementById("cartItem");
    },
    updateAddToCartButtons: function() {
        initAddToCartButtons();
    },
    addToCart: function (productId) {
        if (CartController.container.has(productId)) {
            CartController.container.set(productId, CartController.container.get(productId) + 1);
            addNewItemToCart(productId);
        } else {
            CartController.container.set(productId, 1);
            refreshCart();
        }
    },
    removeProduct: function (productId) {

    },
    updateContent: function () {

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

function addNewItemToCart(productId) {

}

function refreshCart() {

}
import {domManager} from "./domManager.js";

export let cardBuilder = {
    buildCards: function (products) {
        let cardContainer = document.getElementById("cardContainer");
        let cardTemplate = document.getElementById("cardTemplate");
        domManager.clearElement(cardContainer);
        products.forEach(product =>  {
            let productDiv = buildCard(product, cardTemplate);
            cardContainer.appendChild(productDiv);
        })
    }
}

function buildCard(product, template) {
    template = template.content.cloneNode(true);
    let image = template.getElementById("cardImage");
    image.setAttribute("src", `/static/img/product_${product.id}.png`)
    let title = template.getElementById("productName");
    title.textContent = product.name;
    let supplier = template.getElementById("productSupplier");
    supplier.textContent = product.supplier;
    let price = template.getElementById("productPrice");
    price.textContent = product.price;
    let description = template.getElementById("productDescription");
    description.textContent = product.description;

    let addToCartButton = template.querySelector(".cart-button");
    addToCartButton.setAttribute("data-product-id", product.id);

    return template;
}
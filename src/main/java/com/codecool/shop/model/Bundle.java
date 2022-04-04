package com.codecool.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bundle extends BaseModel {

    private final List<Product> products = new ArrayList<>();
    private BigDecimal defaultPrice;
    private final String defaultCurrency;

    public Bundle(String name, String description, Product... products) {
        super(name, description);
        this.products.addAll(Arrays.asList(products));
        defaultPrice = new BigDecimal(0);
        defaultCurrency = products[0].getDefaultCurrency();
        for(Product product : this.products) {
            defaultPrice = defaultPrice.add(product.getDefaultPrice());
        }
        defaultPrice = defaultPrice.multiply(BigDecimal.valueOf(0.9));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public String getPrice() {
        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
    }

}

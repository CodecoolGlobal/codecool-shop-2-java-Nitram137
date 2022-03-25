package com.codecool.shop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codecool.shop.dao.BundleDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.BundleDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Bundle;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.CartItem;
import com.codecool.shop.model.Product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@WebServlet(name = "CartController", urlPatterns = "/api/cart", loadOnStartup = 2)
public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        BundleDao bundleDaoMem = BundleDaoMem.getInstance();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(request.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        Map<String, Integer> reqCart = new ObjectMapper().readValue(content.toString(), HashMap.class);

        List<CartItem> cartItems = new ArrayList<>();

        for (String key : reqCart.keySet()) {
            Product product = productDataStore.find(Integer.parseInt(key));
            Bundle bundle = bundleDaoMem.find(Integer.parseInt(key));
            if (product == null && bundle == null) {
                throw new ServletException("Invalid product id");
            }
            else if (bundle != null) {
                cartItems.add(new CartItem(
                        40,
                        bundle.getName(),
                        "",
                        reqCart.get(key),
                        bundle.getDefaultPrice()
                ));
            } else {
                cartItems.add(new CartItem(
                        product.getId(),
                        product.getName(),
                        product.getSupplier().getName(),
                        reqCart.get(key),
                        product.getDefaultPrice()
                ));
            }
        }

        Cart cart = new Cart(cartItems);

        Gson gson = new Gson();
        String cartAsString = gson.toJson(cart);

        PrintWriter out = response.getWriter();
        out.println(cartAsString);

    }
}
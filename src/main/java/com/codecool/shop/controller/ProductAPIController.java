package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductJSON;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ProductAPI", urlPatterns = "/api/product")
public class ProductAPIController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ProductDao productDataStore = ProductDaoMem.getInstance();

        List<Product> products = productDataStore.getAll();

        List<ProductJSON> productJSONS = products.stream().map(product -> new ProductJSON(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getSupplier().getName(),
                product.getProductCategory().getName(),
                product.getProductCategory().getId(),
                product.getSupplier().getId())).collect(Collectors.toList());

        Gson gson = new Gson();

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(productJSONS));
    }
}


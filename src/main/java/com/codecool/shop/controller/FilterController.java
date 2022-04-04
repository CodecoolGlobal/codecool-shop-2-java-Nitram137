package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.ProductJSON;
import com.codecool.shop.model.Supplier;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "filterByCategory", urlPatterns = "/api/filter")
public class FilterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDao = SupplierDaoMem.getInstance();
        List<Product> products;

        if (request.getParameterMap().containsKey("category")) {
            int categoryId = Integer.parseInt(request.getParameter("category"));
            ProductCategory productCategory = productCategoryDataStore.find(categoryId);
            if (productCategory != null) {
                products = productCategory.getProducts();
            } else {
                throw new ServletException("Invalid Category Id");
            }
        } else if (request.getParameterMap().containsKey("supplier")) {
            int supplierId = Integer.parseInt(request.getParameter("supplier"));
            Supplier supplier = supplierDao.find(supplierId);
            if (supplier != null) {
                products = supplier.getProducts();
            } else {
                throw new ServletException("Invalid Supplier Id");
            }
        } else {
            throw new ServletException("Invalid url");
        }

        List<ProductJSON> productJSONS = products.stream().map(product -> new ProductJSON(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getSupplier().getName()
        )).collect(Collectors.toList());

        Gson gson = new Gson();

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(productJSONS));
    }
}

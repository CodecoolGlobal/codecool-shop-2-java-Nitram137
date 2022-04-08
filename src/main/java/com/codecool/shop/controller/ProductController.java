package com.codecool.shop.controller;

import com.codecool.shop.dao.BundleDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends HttpServlet {

    private final ProductDao productDataStore;
    private final ProductCategoryDao productCategoryDataStore;
    private final BundleDao bundleDao;
    private final SupplierDao supplierDao;

    public ProductController(ProductDao productDataStore, ProductCategoryDao productCategoryDataStore, BundleDao bundleDao, SupplierDao supplierDao) {
        this.productDataStore = productDataStore;
        this.productCategoryDataStore = productCategoryDataStore;
        this.bundleDao = bundleDao;
        this.supplierDao = supplierDao;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = new ProductService(productDataStore, productCategoryDataStore, supplierDao);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("category", productService.getProductCategory(1));
        context.setVariable("products", productService.getAll());
        context.setVariable("bundles", bundleDao.getAll());
        context.setVariable("categories", productCategoryDataStore.getAll());
        context.setVariable("suppliers", supplierDao.getAll());
        // // Alternative setting of the template context
        // Map<String, Object> params = new HashMap<>();
        // params.put("category", productCategoryDataStore.find(1));
        // params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));
        // context.setVariables(params);
        engine.process("product/index.html", context, resp.getWriter());
    }

}

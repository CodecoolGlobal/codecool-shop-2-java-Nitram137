package com.codecool.shop.dao.db_implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.util.List;

public class ProductDaoJdbc implements ProductDao {

    private DataSource dataSource;
    private ProductCategoryDao categoryDao;
    private SupplierDao supplierDao;

    public ProductDaoJdbc(DataSource dataSource, ProductCategoryDao categoryDao, SupplierDao supplierDao) {
        this.dataSource = dataSource;
        this.categoryDao = categoryDao;
        this.supplierDao = supplierDao;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }

}

package com.codecool.shop.dao.db_implementation;

import com.codecool.shop.dao.BundleDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Bundle;

import javax.sql.DataSource;
import java.util.List;

public class BundleDaoJdbc implements BundleDao {

    private DataSource dataSource;
    private ProductDao productDao;

    public BundleDaoJdbc(DataSource dataSource, ProductDao productDao) {
        this.dataSource = dataSource;
        this.productDao = productDao;
    }

    @Override
    public void add(Bundle bundle) {

    }

    @Override
    public Bundle find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Bundle> getAll() {
        return null;
    }
}

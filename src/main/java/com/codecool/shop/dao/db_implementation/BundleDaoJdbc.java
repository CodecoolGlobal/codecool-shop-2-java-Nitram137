package com.codecool.shop.dao.db_implementation;

import com.codecool.shop.dao.BundleDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Bundle;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT name, description, STRING_AGG(CAST(pb.product_id AS varchar), ' ') FROM bundles JOIN products_bundles pb on bundles.id = pb.bundle_id WHERE bundles.id = ? GROUP BY bundles.id, name, description";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id + 1);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()) return null;
            List<Product> productList = new ArrayList<>();
            String productIdString = resultSet.getString(3);
            String[] productIDs = productIdString.split(" ", 3);
            for(String productID : productIDs) { productList.add(productDao.find(Integer.parseInt(productID))); }
            Bundle bundle = new Bundle(resultSet.getString(1), resultSet.getString(2), productList);
            bundle.setId(id);
            return bundle;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Bundle> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT bundles.id, name, description, STRING_AGG(CAST(pb.product_id AS varchar), ' ') FROM bundles JOIN products_bundles pb on bundles.id = pb.bundle_id GROUP BY bundles.id, name, description";
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            List<Bundle> bundleList = new ArrayList<>();
            while(resultSet.next()) {
                List<Product> productList = new ArrayList<>();
                String productIdString = resultSet.getString(4);
                String[] productIDs = productIdString.split(" ", 3);
                for(String productID : productIDs) { productList.add(productDao.find(Integer.parseInt(productID))); }
                Bundle bundle = new Bundle(resultSet.getString(2), resultSet.getString(3), productList);
                bundle.setId(resultSet.getInt(1) - 1);
                bundleList.add(bundle);
            }
            return bundleList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

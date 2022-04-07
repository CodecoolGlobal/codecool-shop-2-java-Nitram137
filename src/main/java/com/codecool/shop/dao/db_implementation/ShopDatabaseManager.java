package com.codecool.shop.dao.db_implementation;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

import com.codecool.shop.dao.BundleDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import org.postgresql.ds.PGSimpleDataSource;

public class ShopDatabaseManager {

    private static ShopDatabaseManager dbManager = null;
    private ProductDao productDao;
    private SupplierDao supplierDao;
    private ProductCategoryDao categoryDao;
    private BundleDao bundleDao;

    private ShopDatabaseManager() {
    }

    public static ShopDatabaseManager getInstance() {
        if(dbManager == null) {
            dbManager = new ShopDatabaseManager();
        }
        return dbManager;
    }

    public void setup() throws SQLException, IOException {
        Properties properties = initProperties();
        DataSource dataSource = connect(properties);
        supplierDao = new SupplierDaoJdbc(dataSource);
        categoryDao = new ProductCategoryDaoJdbc(dataSource);
        productDao = new ProductDaoJdbc(dataSource, categoryDao, supplierDao);
        bundleDao = new BundleDaoJdbc(dataSource, productDao);
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public SupplierDao getSupplierDao() {
        return supplierDao;
    }

    public ProductCategoryDao getCategoryDao() {
        return categoryDao;
    }

    public BundleDao getBundleDao() {
        return bundleDao;
    }

    private Properties initProperties() throws IOException {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + "connection.properties";

        Properties properties = new Properties();
        properties.load(new FileInputStream(appConfigPath));
        return properties;
    }

    private DataSource connect(Properties properties) throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName = properties.getProperty("database");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }
}

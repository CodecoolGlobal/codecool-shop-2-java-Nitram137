package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    ProductDao mockedProductDataStore;
    ProductCategoryDao mockedProductCategoryDataStore;
    SupplierDao mockedSupplierDao;
    ProductService serviceUnderTest;
    Product mockedProduct;
    List<Product> mockList;

    @BeforeEach
    void initProductService() {
        mockedProductDataStore = mock(ProductDao.class);
        mockedProductCategoryDataStore = mock(ProductCategoryDao.class);
        mockedSupplierDao = mock(SupplierDao.class);
        serviceUnderTest = new ProductService(mockedProductDataStore, mockedProductCategoryDataStore, mockedSupplierDao);
        mockedProduct = mock(Product.class);
        mockList = new ArrayList<>();
        mockList.add(mockedProduct);
    }

    @Test
    void testGetProductCategory_returnsProductCategory() {
        ProductCategory mockedProductCategory = mock(ProductCategory.class);
        when(mockedProductCategoryDataStore.find(anyInt())).thenReturn(mockedProductCategory);
        assertEquals(mockedProductCategory, serviceUnderTest.getProductCategory(anyInt()));
    }

    @Test
    void testGetProductsForCategory_returnsList() {
        when(mockedProductDataStore.getBy((ProductCategory) any())).thenReturn(mockList);
        assertEquals(mockList, serviceUnderTest.getProductsForCategory(anyInt()));
    }

    @Test
    void testGetProductSupplier_returnsSupplier() {
        Supplier mockedSupplier = mock(Supplier.class);
        when(mockedSupplierDao.find(anyInt())).thenReturn(mockedSupplier);
        assertEquals(mockedSupplier, serviceUnderTest.getProductSupplier(anyInt()));
    }

    @Test
    void testGetProductsForSupplier_returnsList() {
        when(mockedProductDataStore.getBy((Supplier) any())).thenReturn(mockList);
        assertEquals(mockList, serviceUnderTest.getProductsForSupplier(anyInt()));
    }

    @Test
    void testGetAll_returnsList() {
        when(mockedProductDataStore.getAll()).thenReturn(mockList);
        assertEquals(mockList, serviceUnderTest.getAll());
    }

    @Test
    void testGetProductCategory_returnsNull() {
        when(mockedProductCategoryDataStore.find(anyInt())).thenReturn(null);
        assertNull(serviceUnderTest.getProductCategory(anyInt()));
    }

    @Test
    void testGetProductsForCategory_returnsNull() {
        when(mockedProductDataStore.getBy((ProductCategory) any())).thenReturn(null);
        assertNull(serviceUnderTest.getProductsForCategory(anyInt()));
    }

    @Test
    void testGetProductSupplier_returnsNull() {
        when(mockedSupplierDao.find(anyInt())).thenReturn(null);
        assertNull(serviceUnderTest.getProductSupplier(anyInt()));
    }

    @Test
    void testGetProductsForSupplier_returnsNull() {
        when(mockedSupplierDao.find(anyInt())).thenReturn(null);
        when(mockedProductDataStore.getBy((Supplier) any())).thenReturn(null);
        assertNull(serviceUnderTest.getProductsForSupplier(anyInt()));
    }

    @Test
    void testGetAll_returnsNull() {
        when(mockedProductDataStore.getAll()).thenReturn(null);
        assertNull(serviceUnderTest.getAll());
    }

    @Test
    void testGetAll_throwsError() {
        when(mockedProductDataStore.getAll()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> serviceUnderTest.getAll());
    }
}
package com.codecool.shop.dao;

import com.codecool.shop.model.Bundle;

import java.util.List;

public interface BundleDao {

    void add(Bundle bundle);
    Bundle find(int id);
    void remove(int id);

    List<Bundle> getAll();
}

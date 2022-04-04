package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.BundleDao;
import com.codecool.shop.model.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BundleDaoMem implements BundleDao {

    private List<Bundle> data = new ArrayList<>();

    private static BundleDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private BundleDaoMem() {
    }

    public static BundleDaoMem getInstance() {
        if (instance == null) {
            instance = new BundleDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Bundle bundle) {
        bundle.setId(data.size() + 1);
        data.add(bundle);
    }

    @Override
    public Bundle find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Bundle> getAll() {
        return data;
    }
}

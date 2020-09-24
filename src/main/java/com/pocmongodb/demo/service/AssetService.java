package com.pocmongodb.demo.service;

import com.pocmongodb.demo.model.AssetDevice;
import com.pocmongodb.demo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepository;

    public List<AssetDevice> getAllAsset() {
        return assetRepository.findAll();
    }

    public AssetDevice saveAsset(AssetDevice asset) {
        return assetRepository.save(asset);
    }
}

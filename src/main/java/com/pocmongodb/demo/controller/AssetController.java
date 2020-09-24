package com.pocmongodb.demo.controller;

import com.pocmongodb.demo.model.AssetDevice;
import com.pocmongodb.demo.repository.AssetRepository;
import com.pocmongodb.demo.service.AssetService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssetController {

    @Autowired
    AssetService assetService;

    @GetMapping(path = "api/asset/getall")
    public ResponseEntity getAllAsset() {

        List<AssetDevice> assets = assetService.getAllAsset();
        return new ResponseEntity(assets, HttpStatus.OK);
    }

    @PostMapping(path = "api/asset/save")
    public ResponseEntity saveAsset(@RequestBody AssetDevice asset) {
        asset = assetService.saveAsset((asset));
        return new ResponseEntity(asset, HttpStatus.OK);
    }
}

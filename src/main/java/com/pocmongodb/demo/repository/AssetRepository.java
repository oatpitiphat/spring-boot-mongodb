package com.pocmongodb.demo.repository;

import com.pocmongodb.demo.model.AssetDevice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends MongoRepository<AssetDevice, String> {

}

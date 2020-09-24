package com.pocmongodb.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asset_device")
@Data
public class AssetDevice {
    @Id
    private String assetId;
    private String assetName;
    private String assetSerial;
    private String assetPrice;
}

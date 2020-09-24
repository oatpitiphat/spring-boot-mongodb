package com.pocmongodb.demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Role {
    private String roleName;
    private String roleDescription;
}

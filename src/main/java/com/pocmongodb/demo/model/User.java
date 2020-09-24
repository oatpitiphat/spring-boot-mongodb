package com.pocmongodb.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "user")
@Data
@Validated
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;
    private Double money;

    private List<Role> roles;
}

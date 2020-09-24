package com.pocmongodb.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class UserGroupAge {
    private Integer count;
    private List<User> users;
}

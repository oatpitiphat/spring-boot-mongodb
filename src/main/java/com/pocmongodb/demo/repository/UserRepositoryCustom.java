package com.pocmongodb.demo.repository;

import com.pocmongodb.demo.model.UserGroupAge;

import java.util.List;

public interface UserRepositoryCustom {

    List<UserGroupAge> groupAge();
}

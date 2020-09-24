package com.pocmongodb.demo.repository;

import com.pocmongodb.demo.model.User;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository <User, String> {

    User findByName(String name);

    @Query("{ 'roles.roleName' : ?0, 'roles.roleDescription' : ?1 }")
    List<User> findAllDataByRole(String roleName, String roleDesc);
}

package com.pocmongodb.demo.repository;

import com.pocmongodb.demo.model.User;
import com.pocmongodb.demo.model.UserGroupAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;

import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserGroupAge> groupAge() {
        TypedAggregation<User> agg = Aggregation.newAggregation(User.class,
                Aggregation.group("age").
                        count().as("count").
                push("$$ROOT").as("users"));

        AggregationResults<UserGroupAge> results = mongoTemplate.aggregate(agg, UserGroupAge.class);
        List<UserGroupAge> groupAges = results.getMappedResults();
        return groupAges;
    }
}

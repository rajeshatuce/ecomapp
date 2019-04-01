package com.rt.repository;

import com.rt.model.CustomerQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerQueryRepository extends MongoRepository<CustomerQuery, String> {

}

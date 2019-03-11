package com.rt.repository;

import com.rt.model.ProductGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupsRepository extends MongoRepository<ProductGroup, String> {

}

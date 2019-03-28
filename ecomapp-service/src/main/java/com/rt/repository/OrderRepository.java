package com.rt.repository;

import com.rt.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

  @Query("{createdBy:'?0'}")
  Page<Order> fetchOrdersForCustomer(String createdBy, Pageable pageable);
}

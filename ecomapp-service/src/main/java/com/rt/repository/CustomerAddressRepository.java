package com.rt.repository;

import com.rt.model.CustomerAddress;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends MongoRepository<CustomerAddress, String> {

  @Query("{customerAddressForEmailId:'?0'}")
  List<CustomerAddress> findAddressForCustomerEmailId(String customerAddressForEmailId);

}

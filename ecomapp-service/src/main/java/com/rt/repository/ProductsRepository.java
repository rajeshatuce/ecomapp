package com.rt.repository;

import com.rt.model.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Product, String> {

  @Query("{status:'?0'}")
  List<Product> findProductsByStatus(String status);

  @Query("{$and: [{_id: { $in: ?0 } } ,{status:'?0'}]}")
  List<Product> findProductByIdsAndStatus(List<String> productIds, String status);

}

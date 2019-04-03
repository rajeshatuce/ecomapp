package com.rt.repository;

import com.rt.model.UserRoleMapping;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMappingRepository extends MongoRepository<UserRoleMapping, String> {

  @Query("{emailId:'?0'}")
  List<UserRoleMapping> findRolesForUser(String emailId);
}

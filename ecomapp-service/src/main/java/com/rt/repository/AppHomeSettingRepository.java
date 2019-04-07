package com.rt.repository;

import com.rt.model.AppHomeSetting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppHomeSettingRepository extends MongoRepository<AppHomeSetting, String> {

}

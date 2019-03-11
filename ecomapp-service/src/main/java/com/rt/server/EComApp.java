package com.rt.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * EComApp main class for ecomapp
 */

@SpringBootApplication(scanBasePackages = {"com.rt"})
@EnableOAuth2Sso // Without this, basic authentication is invoked
@EnableMongoRepositories(basePackages = "com.rt.repository")
public class EComApp {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComApp.class);

  /**
   * EComApp method to be invoked from command line
   */
  public static void main(String[] args) {
    LOGGER.info("Starting ecomapp server");
    SpringApplication.run(EComApp.class, args);

  }


}

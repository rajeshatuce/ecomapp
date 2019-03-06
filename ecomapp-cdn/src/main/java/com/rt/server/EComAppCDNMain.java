package com.rt.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for EComAppCDN
 */
@SpringBootApplication(scanBasePackages = {"com.rt"})
public class EComAppCDNMain {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppCDNMain.class);

  /**
   * Main method for the CDN App
   */
  public static void main(String[] args) {
    LOGGER.info("Starting ecomapp server");
    SpringApplication.run(EComAppCDNMain.class, args);
  }

}

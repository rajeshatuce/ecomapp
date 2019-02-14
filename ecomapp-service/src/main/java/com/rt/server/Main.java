package com.rt.server;

import com.englishtown.vertx.hk2.HK2JerseyBinder;
import com.englishtown.vertx.hk2.HK2VertxBinder;
import com.englishtown.vertx.jersey.JerseyServer;
import com.rt.controller.EComAppController;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for ecomapp
 */
public class Main {

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  /**
   * Main method to be invoked from command line
   */
  public static void main(String[] args) throws Exception {
    LOGGER.info("Starting ecomapp server on environment [ {} ]", args[0]);
    Properties prop = loadEnvironmentPropertyFile(args[0]);
    initializeVertx(Integer.parseInt(prop.getProperty("port")));
    LOGGER.info("Server started successfully");
  }

  private static Properties loadEnvironmentPropertyFile(String arg) throws IOException {
    String propertyFile = String.format("application_%s.properties", arg.toLowerCase());
    Properties prop = new Properties();
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    InputStream stream = loader.getResourceAsStream(propertyFile);
    prop.load(stream);
    return prop;
  }

  /**
   * Utility API to initialize vertx
   */
  private static void initializeVertx(int portNumber) {
    Vertx vertx = Vertx.vertx();
    vertx.runOnContext(aVoid -> {

      // Set up the jersey configuration
      // The minimum config required is a package to inspect for JAX-RS endpoints
      vertx.getOrCreateContext().config()
          .put("jersey", new JsonObject()
              .put("port", portNumber)
              .put("features", new JsonArray()
                  .add("org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature"))
              .put("instances", new JsonArray()
                  .add(EComAppController.class.getCanonicalName())));

      // Use a service locator (HK2 or Guice are supported by default) to create the jersey server
      ServiceLocator locator = ServiceLocatorUtilities
          .bind(new HK2JerseyBinder(), new HK2VertxBinder(vertx));
      JerseyServer server = locator.getService(JerseyServer.class);
      // Start the server
      server.start();
    });
  }

}

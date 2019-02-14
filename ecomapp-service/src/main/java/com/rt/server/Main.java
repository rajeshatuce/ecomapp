package com.rt.server;

import com.englishtown.vertx.hk2.HK2JerseyBinder;
import com.englishtown.vertx.hk2.HK2VertxBinder;
import com.englishtown.vertx.jersey.JerseyServer;
import com.rt.controller.EComAppController;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.logging.Logger;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class Main {

  private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.runOnContext(aVoid -> {

      // Set up the jersey configuration
      // The minimum config required is a package to inspect for JAX-RS endpoints
      vertx.getOrCreateContext().config()
          .put("jersey", new JsonObject()
              .put("port", 8080)
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
      LOGGER.info("Server started successfully");
    });
  }

}

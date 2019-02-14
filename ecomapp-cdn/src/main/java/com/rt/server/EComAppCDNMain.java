package com.rt.server;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for EComAppCDN
 */
public class EComAppCDNMain {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppCDNMain.class);

  /**
   * Main method for the CDN App
   */
  public static void main(String[] args) throws Exception {
    LOGGER.info("Starting ecomapp server on environment [ {} ]", args[0]);
    Properties prop = loadEnvironmentPropertyFile(args[0]);
    initializeVertxForCDNServer(Integer.parseInt(prop.getProperty("port")));
  }

  /**
   * utility api to load environment specific properties file
   */
  private static Properties loadEnvironmentPropertyFile(String arg) throws IOException {
    String propertyFile = String.format("application_%s.properties", arg.toLowerCase());
    Properties prop = new Properties();
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    InputStream stream = loader.getResourceAsStream(propertyFile);
    prop.load(stream);
    return prop;
  }

  /**
   * initializeVertxForCDNServer
   */
  private static void initializeVertxForCDNServer(int port) throws IOException {
    System.setProperty("vertx.disableFileCaching", "true");
    Vertx vertx = Vertx.vertx();
    Router router = Router.router(vertx);

    // Serve the static pages
    router.route().handler(StaticHandler.create());

    vertx.createHttpServer().requestHandler(router::accept).listen(port);

    LOGGER.info("Server is started");
    LOGGER.debug("Path:" + new File("").getCanonicalPath());
    File file = new File(new File("").getCanonicalPath()
        + "\\ecomapp-cdn\\target\\classes\\webroot\\images\\jeans.jpg");
    LOGGER.info("Exists:" + file.exists());
  }

}

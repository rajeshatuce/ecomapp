package com.rt.server;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import java.io.File;

public class EComAppCDNMain {

  public static void main(String[] args) throws Exception {
    System.setProperty("vertx.disableFileCaching", "true");
    Vertx vertx = Vertx.vertx();
    Router router = Router.router(vertx);

    // Serve the static pages
    router.route().handler(StaticHandler.create());

    vertx.createHttpServer().requestHandler(router::accept).listen(8081);

    System.out.println("Server is started");
    System.out.println("Path:" + new File("").getCanonicalPath());
    File file = new File(new File("").getCanonicalPath()
        + "\\ecomapp-cdn\\target\\classes\\webroot\\images\\jeans.jpg");
    System.out.println("Exists:" + file.exists());

  }

}

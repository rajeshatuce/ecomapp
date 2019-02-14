package com.rt.controller;

import static com.rt.constant.EComAppConstant.CDN_URL;

import com.google.inject.Inject;
import com.rt.util.EComAppUtil;
import com.rt.util.EComAppUtilImpl;
import io.vertx.core.Vertx;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 * ECom app main controller
 */
@Path("/")
public class EComAppController {

  private EComAppUtil eComAppUtil;

  @Inject
  public EComAppController() {
    this.eComAppUtil = new EComAppUtilImpl();
  }


  @GET
  @Produces(MediaType.TEXT_HTML)
  public Viewable doGet(@Context Vertx vertx) {
    final Map<String, Object> map = new HashMap<String, Object>();
    map.put(CDN_URL, eComAppUtil.getEComCDNUrlForImages());
    return new Viewable("/templates/index.ftl", map);

  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  @Path("/test")
  public String doTest(@Context Vertx vertx) {

    return "I love java";

  }

}

package com.rt.constant;

public class EComAppConstant {

  public static final String CDN_SERVER_PROTOCOL = "${cdn.server.protocol}";
  public static final String CDN_SERVER_HOST = "${cdn.server.host}";
  public static final String CDN_SERVER_PORT = "#{new Integer('${cdn.server.port}')}";
  public static final String CDN_IMG_URL = "CDN_IMG_URL";
  public static final String CDN_JS_URL = "CDN_JS_URL";
  public static final String CDN_CSS_URL = "CDN_CSS_URL";


}

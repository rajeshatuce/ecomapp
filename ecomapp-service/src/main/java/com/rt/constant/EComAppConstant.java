package com.rt.constant;

import java.io.Serializable;

public class EComAppConstant {

  public static final String CDN_SERVER_PROTOCOL = "${cdn.server.protocol}";
  public static final String CDN_SERVER_HOST = "${cdn.server.host}";
  public static final String CDN_SERVER_PORT = "#{new Integer('${cdn.server.port}')}";
  public static final String CDN_IMG_URL = "CDN_IMG_URL";
  public static final String CDN_JS_URL = "CDN_JS_URL";
  public static final String CDN_CSS_URL = "CDN_CSS_URL";

  public static final String ACTIVE_PRODUCTS = "ACTIVE_PRODUCTS";


  public static final String ECOMAPP_HOMEPAGE = "homepage/ecomapp_homepage";
  public static final String ECOMAPP_CHECKOUT_PAGE = "checkout_page/ecomapp_checkout_page";
  public static final String ECOMAPP_MY_ORDERS_PAGE = "orders_page/ecomapp_my_orders_page";
  public static final String CURRENCY_FORMAT_STRING = "%,.2f";
  public static final String EMAIL = "email";
  public static final String ORDER = "Order";

  public enum Status implements Serializable {
    Active("Active"),
    Inactive("Inactive");

    private final String status;

    Status(String status) {
      this.status = status;
    }

    public String toString() {
      return this.status;
    }
  }
}

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
  public static final String CUSTOMER_ADDRESS_ID = "customerAddressId";
  public static final String CUSTOMER_ADDRESS = "CUSTOMER_ADDRESS";

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

  public enum PaymentType implements Serializable {
    Cash_On_Delivery("COD"),
    Credit_Card_Net_Banking("CCD");

    private final String paymentType;

    PaymentType(String paymentType) {
      this.paymentType = paymentType;
    }

    public String toString() {
      return this.paymentType;
    }
  }

  public enum PaymentStatus implements Serializable {
    Done("Done"),
    Refunded("Refunded"),
    Failed("Failed");

    private final String paymentStatus;

    PaymentStatus(String paymentStatus) {
      this.paymentStatus = paymentStatus;
    }

    public String toString() {
      return this.paymentStatus;
    }
  }

  public enum OrderStatus implements Serializable {
    Done("Done"),
    In_Progress("In_Progress"),
    Cancelled("Cancelled");

    private final String orderStatus;

    OrderStatus(String orderStatus) {
      this.orderStatus = orderStatus;
    }

    public String toString() {
      return this.orderStatus;
    }
  }

  public enum DeliveryStatus implements Serializable {
    Done("Done"),
    In_Progress("In_Progress"),
    Cancelled("Cancelled");

    private final String deliveryStatus;

    DeliveryStatus(String deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
    }

    public String toString() {
      return this.deliveryStatus;
    }
  }

  public enum CustomerAddressType implements Serializable {
    Home("Home"),
    Office("Office"),
    Other("Other");

    private final String customerAddressType;

    CustomerAddressType(String customerAddressType) {
      this.customerAddressType = customerAddressType;
    }

    public String toString() {
      return this.customerAddressType;
    }
  }
}

package com.rt.util;

public class EComAppUtilImpl implements EComAppUtil {

  public String getEComCDNUrlForImages() {
    return "http://localhost:8081/images/";
  }

  @Override
  public String getEComCDNUrlForJS() {
    return "http://localhost:8081/js/";
  }

  @Override
  public String getEComCDNUrlForCSS() {
    return "http://localhost:8081/css/";
  }


}

package com.rt.util;

import static com.rt.constant.EComAppConstant.CDN_CSS_URL;
import static com.rt.constant.EComAppConstant.CDN_IMAGES_LOCATION;
import static com.rt.constant.EComAppConstant.CDN_IMG_URL;
import static com.rt.constant.EComAppConstant.CDN_JS_URL;
import static com.rt.constant.EComAppConstant.CDN_SERVER_HOST;
import static com.rt.constant.EComAppConstant.CDN_SERVER_PORT;
import static com.rt.constant.EComAppConstant.CDN_SERVER_PROTOCOL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class EComAppCDNUrlBuilder {

  private String cdnProtocol;
  private String host;
  private int port;

  @Autowired
  public EComAppCDNUrlBuilder(@Value(CDN_SERVER_PROTOCOL) String cdnProtocol,
      @Value(CDN_SERVER_HOST) String host,
      @Value(CDN_SERVER_PORT) int port) {
    this.cdnProtocol = cdnProtocol;
    this.host = host;
    this.port = port;
  }

  private String getEComCDNUrlForImages() {
    return prepareCDNUrl() + CDN_IMAGES_LOCATION;
  }

  private String getEComCDNUrlForJS() {
    return prepareCDNUrl() + "app/js/";
  }

  private String getEComCDNUrlForCSS() {
    return prepareCDNUrl() + "app/css/";
  }

  private String prepareCDNUrl() {
    return String.format("%s://%s:%d/", cdnProtocol, host, port);
  }

  public void addCDNUrlToModel(Model model) {
    model.addAttribute(CDN_IMG_URL, getEComCDNUrlForImages());
    model.addAttribute(CDN_JS_URL, getEComCDNUrlForJS());
    model.addAttribute(CDN_CSS_URL, getEComCDNUrlForCSS());
  }

}

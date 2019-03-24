package com.rt.controller;

import static com.rt.constant.EComAppCDNConstant.CDN_WEBROOTPATH;
import static com.rt.constant.EComAppCDNConstant.CSS;
import static com.rt.constant.EComAppCDNConstant.JS;
import static com.rt.constant.EComAppCDNConstant.TEXT_CSS;
import static com.rt.constant.EComAppCDNConstant.TEXT_JAVASCRIPT;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

/**
 * EComAPPCDN REST controller API to
 */
@RestController
public class EComAppCDNController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EComAppCDNController.class);

  private String webRootPath;
  private Tika tika = new Tika();

  @Autowired
  public EComAppCDNController(@Value(CDN_WEBROOTPATH) String webRootPath) {
    this.webRootPath = webRootPath;
  }

  /**
   * Function to stream app specific files available in resource folder for ex. CSS, JSS
   *
   * @param response HttpServletResponse
   */
  @RequestMapping(value = "/app/**", method = RequestMethod.GET)
  @ResponseBody
  public void getAppSpecificFile(HttpServletRequest request, HttpServletResponse response) {
    String restOfTheUrl = (String) request
        .getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    try {
      Resource resource = new ClassPathResource(
          restOfTheUrl.substring(1));//load app specific file in classpath
      if (restOfTheUrl.endsWith(CSS)) {
        response.setContentType(TEXT_CSS);
      } else if (restOfTheUrl.endsWith(JS)) {
        response.setContentType(TEXT_JAVASCRIPT);
      } else {
        response.setContentType(
            tika.detect(resource.getInputStream()));//try to detect mime type from stream
      }
      IOUtils.copy(resource.getInputStream(), response.getOutputStream());//copy stream to output
    } catch (Exception err) {
      LOGGER
          .error("Error occurred while streaming app specific file: {}, Err:{}", restOfTheUrl, err);
    }
  }

  /**
   * Function to stream files from CDN folder
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   */
  @RequestMapping(value = "/cdn/**", method = RequestMethod.GET)
  @ResponseBody
  public void getFile(HttpServletRequest request, HttpServletResponse response) {
    String restOfTheUrl = (String) request.getAttribute(
        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    String fileToStream = webRootPath + restOfTheUrl;
    try {
      File file = new File(fileToStream);
      response.setContentType(tika.detect(file));
      IOUtils.copy(new FileInputStream(file), response.getOutputStream());
    } catch (Exception err) {
      LOGGER.error("Error occurred while streaming file from CDN: {}", fileToStream);
    }
  }
}

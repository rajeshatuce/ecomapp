package com.rt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EComAppRestController {

  @RequestMapping("/test")
  public String doTest() {

    return "I love java";

  }

}

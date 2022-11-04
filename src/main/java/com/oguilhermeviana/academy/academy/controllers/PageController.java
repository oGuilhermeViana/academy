package com.oguilhermeviana.academy.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

  @GetMapping("/")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("home/index");
    return mv;
  }

}

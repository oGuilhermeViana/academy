package com.oguilhermeviana.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oguilhermeviana.academy.model.Aluno;

@Controller
public class HomeController {

  @GetMapping("/")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("home/index");
    mv.addObject("aluno", new Aluno());
    return mv;
  }

}

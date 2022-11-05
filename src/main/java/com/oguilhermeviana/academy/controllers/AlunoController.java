package com.oguilhermeviana.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oguilhermeviana.academy.dao.AlunoDao;
import com.oguilhermeviana.academy.model.Aluno;

@Controller
public class AlunoController {

  @Autowired
  private AlunoDao repo;

  @GetMapping("/cadastro-aluno")
  public ModelAndView cadastro(Aluno aluno) {
    ModelAndView mv = new ModelAndView("aluno/cadastro");
    mv.addObject("aluno", new Aluno());
    return mv;
  }

  @PostMapping("/cadastro-aluno")
  public ModelAndView cadastrar(Aluno aluno) {
    ModelAndView mv = new ModelAndView("redirect:/aluno/lista");
    repo.save(aluno);
    return mv;
  }
}

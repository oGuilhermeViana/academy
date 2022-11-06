package com.oguilhermeviana.academy.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ModelAndView cadastrar(@Valid Aluno aluno, BindingResult br) {
    ModelAndView mv = new ModelAndView();
    if (br.hasErrors()) {
      mv.setViewName("aluno/cadastro");
      mv.addObject("aluno");
    } else {
      mv.setViewName("redirect:/lista-aluno");
      repo.save(aluno);
    }
    return mv;
  }

  @GetMapping("/lista-aluno")
  public ModelAndView lista(Aluno aluno) {
    ModelAndView mv = new ModelAndView("aluno/lista");
    mv.addObject("lista", repo.findAll());
    return mv;
  }

  @GetMapping("/alterar/{id}")
  public ModelAndView alterar(@PathVariable("id") Integer id) {
    ModelAndView mv = new ModelAndView("aluno/alterar");
    Optional<Aluno> aluno = repo.findById(id);
    mv.addObject("aluno", aluno);
    return mv;
  }

  @PostMapping("/alterar")
  public ModelAndView alterar(Aluno aluno) {
    ModelAndView mv = new ModelAndView("redirect:/lista-aluno");
    repo.save(aluno);
    return mv;
  }

  @GetMapping("/excluir/{id}")
  public String excluir(@PathVariable Integer id) {
    repo.deleteById(id);
    return "redirect:/lista-aluno";
  }
}

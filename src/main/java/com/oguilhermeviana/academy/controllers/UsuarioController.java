package com.oguilhermeviana.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

// import com.oguilhermeviana.academy.dao.UsuarioDao;
import com.oguilhermeviana.academy.model.Usuario;
import com.oguilhermeviana.academy.services.ServiceUsuario;

@Controller
public class UsuarioController {

  // @Autowired
  // private UsuarioDao repo;

  @Autowired
  private ServiceUsuario service;

  @GetMapping("/")
  public ModelAndView login() {
    ModelAndView mv = new ModelAndView("login/login");
    return mv;
  }

  @GetMapping("/cadastro")
  public ModelAndView cadastro() {
    ModelAndView mv = new ModelAndView("login/cadastro");
    mv.addObject("usuario", new Usuario());
    return mv;
  }

  @PostMapping("/salvar-usuario")
  public ModelAndView cadastro(Usuario usuario) throws Exception {
    ModelAndView mv = new ModelAndView("redirect:/");
    service.salvarUsuario(usuario);
    return mv;
  }
}

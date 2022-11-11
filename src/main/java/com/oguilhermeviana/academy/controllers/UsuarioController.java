package com.oguilhermeviana.academy.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oguilhermeviana.academy.exceptions.ServiceException;
import com.oguilhermeviana.academy.model.Aluno;
import com.oguilhermeviana.academy.model.Usuario;
import com.oguilhermeviana.academy.services.ServiceUsuario;
import com.oguilhermeviana.academy.util.Util;

@Controller
public class UsuarioController {

  @Autowired
  private ServiceUsuario service;

  @GetMapping("/")
  public ModelAndView login() {
    ModelAndView mv = new ModelAndView("login/login");
    mv.addObject("usuario", new Usuario());
    return mv;
  }

  @GetMapping("/index")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("home/index");
    mv.addObject("aluno", new Aluno());
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

  @PostMapping("/login")
  public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session)
      throws NoSuchAlgorithmException, ServiceException {

    ModelAndView mv = new ModelAndView();
    mv.addObject("usuario", new Usuario());
    if (br.hasErrors()) {
      mv.setViewName("login/login");
    }

    Usuario userLogin = service.login(usuario.getUser(), Util.md5(usuario.getSenha()));

    if (userLogin == null) {
      mv.addObject("msg", "Usuário não encontrado");
    } else {
      session.setAttribute("usuarioLogado", userLogin);
      return home();
    }

    return mv;
  }

  @PostMapping("/logout")
  public ModelAndView logout(HttpSession session) {
    session.invalidate();
    return login();
  }

}

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

/**
 * Controlador responsável por lidar com operações relacionadas a usuários (login, cadastro, etc.).
 *
 * @author Guilherme Viana
 */
@Controller
public class UsuarioController {

  @Autowired
  private ServiceUsuario service;

  /**
   * Método para exibir a página de login.
   *
   * @return ModelAndView contendo a página de login.
   */
  @GetMapping("/")
  public ModelAndView login() {
    ModelAndView mv = new ModelAndView("login/login");
    mv.addObject("usuario", new Usuario());
    return mv;
  }

  /**
   * Método para exibir a página inicial após o login.
   *
   * @return ModelAndView contendo a página inicial.
   */
  @GetMapping("/index")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("home/index");
    mv.addObject("aluno", new Aluno());
    return mv;
  }

  /**
   * Método para exibir a página de cadastro de usuário.
   *
   * @return ModelAndView contendo a página de cadastro.
   */
  @GetMapping("/cadastro")
  public ModelAndView cadastro() {
    ModelAndView mv = new ModelAndView("login/cadastro");
    mv.addObject("usuario", new Usuario());
    return mv;
  }

  /**
   * Método para processar o cadastro de um novo usuário.
   *
   * @param usuario       O usuário a ser cadastrado.
   * @param bindingResult O resultado da validação do usuário.
   * @return ModelAndView redirecionando para a página inicial após o cadastro.
   * @throws Exception Se ocorrer um erro durante o processo de cadastro.
   */
  @PostMapping("/salvar-usuario")
  public ModelAndView cadastro(@Valid Usuario usuario, BindingResult bindingResult) throws Exception {
    ModelAndView mv = new ModelAndView();
    if (bindingResult.hasErrors()) {
      mv.setViewName("login/cadastro");
      return mv;
    }

    service.salvarUsuario(usuario);
    mv.setViewName("redirect:/");
    return mv;
  }

  /**
   * Método para processar o login do usuário.
   *
   * @param usuario O usuário que está tentando fazer login.
   * @param br      O resultado da validação do usuário.
   * @param session A sessão HTTP para armazenar informações do usuário logado.
   * @return ModelAndView redirecionando para a página inicial após o login bem-sucedido.
   * @throws NoSuchAlgorithmException Se ocorrer um erro durante a autenticação do usuário.
   * @throws ServiceException          Se ocorrer um erro durante a autenticação do usuário.
   */
  @PostMapping("/login")
  public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session)
          throws NoSuchAlgorithmException, ServiceException {

    ModelAndView mv = new ModelAndView();
    if (br.hasErrors()) {
      mv.setViewName("login/login");
      return mv;
    }

    Usuario userLogin = service.login(usuario.getUser(), Util.md5(usuario.getSenha()));

    if (userLogin == null) {
      mv.setViewName("login/login");
      mv.addObject("msg", "Usuário não encontrado");
      return mv;
    }

    session.setAttribute("usuarioLogado", userLogin);
    return home();
  }

  /**
   * Método para realizar o logout do usuário.
   *
   * @param session A sessão HTTP para invalidar o usuário logado.
   * @return ModelAndView redirecionando para a página de login após o logout.
   */
  @PostMapping("/logout")
  public ModelAndView logout(HttpSession session) {
    session.invalidate();
    return login();
  }
}

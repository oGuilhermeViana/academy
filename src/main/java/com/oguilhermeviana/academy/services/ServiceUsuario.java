package com.oguilhermeviana.academy.services;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguilhermeviana.academy.dao.UsuarioDao;
import com.oguilhermeviana.academy.exceptions.CriptoException;
import com.oguilhermeviana.academy.exceptions.EmailExistException;
import com.oguilhermeviana.academy.exceptions.ServiceException;
import com.oguilhermeviana.academy.model.Usuario;
import com.oguilhermeviana.academy.util.Util;

/**
 * Serviço responsável por operações relacionadas a usuários.
 *
 * @author Guilherme Viana
 */
@Service
public class ServiceUsuario {

  @Autowired
  private UsuarioDao repo;

  /**
   * Salva um novo usuário.
   *
   * @param usuario O usuário a ser salvo.
   * @throws EmailExistException se o email já estiver cadastrado.
   * @throws CriptoException se houver erro na criptografia da senha.
   */
  public void salvarUsuario(Usuario usuario) throws EmailExistException, CriptoException {
    try {
      if (repo.findByEmail(usuario.getEmail()) != null) {
        throw new EmailExistException("Esse email já está cadastrado");
      }

      usuario.setSenha(Util.md5(usuario.getSenha()));

    } catch (NoSuchAlgorithmException e) {
      throw new CriptoException("Erro na criptografia da senha");
    }

    repo.save(usuario);
  }

  /**
   * Realiza o login de um usuário.
   *
   * @param user O nome de usuário.
   * @param senha A senha do usuário.
   * @return O usuário logado, se encontrado.
   * @throws ServiceException se ocorrer um erro durante o login.
   */
  public Usuario login(String user, String senha) throws ServiceException {
    Usuario userLogin = repo.findLogin(user, senha);
    return userLogin;
  }

}

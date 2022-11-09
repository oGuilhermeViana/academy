package com.oguilhermeviana.academy.services;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguilhermeviana.academy.dao.UsuarioDao;
import com.oguilhermeviana.academy.exceptions.CriptoException;
import com.oguilhermeviana.academy.exceptions.EmailExistException;
import com.oguilhermeviana.academy.model.Usuario;
import com.oguilhermeviana.academy.util.Util;

@Service
public class ServiceUsuario {

  @Autowired
  private UsuarioDao repo;

  public void salvarUsuario(Usuario usuario) throws Exception {
    try {
      if (repo.findByEmail(usuario.getEmail()) != null) {
        throw new EmailExistException("Esse email já está cadastrato");
      }

      usuario.setSenha(Util.md5(usuario.getSenha()));

    } catch (NoSuchAlgorithmException e) {
      throw new CriptoException("Erro na criptografia da senha");
    }

    repo.save(usuario);
  }

}

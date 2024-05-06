package com.oguilhermeviana.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oguilhermeviana.academy.model.Usuario;

/**
 * Interface para acesso aos dados dos usuários na base de dados.
 *
 * @author Guilherme Viana
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

  /**
   * Busca um usuário pelo email.
   *
   * @param email O email do usuário a ser buscado.
   * @return O usuário encontrado ou null se não existir.
   */
  @Query("select x from Usuario x where x.email = :email")
  public Usuario findByEmail(String email);

  /**
   * Realiza o login de um usuário com o nome de usuário e senha especificados.
   *
   * @param user O nome de usuário.
   * @param senha A senha do usuário.
   * @return O usuário logado, se encontrado.
   */
  @Query("select x from Usuario x where x.user = :user and x.senha = :senha")
  public Usuario findLogin(String user, String senha);

}

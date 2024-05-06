package com.oguilhermeviana.academy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Representa um usuário da academia.
 *
 * @author Guilherme Viana
 */
@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank(message = "O campo usuário não pode estar vazio.")
  @Size(min = 3, max = 40, message = "Usuário deve ter entre 3 e 40 caracteres.")
  private String user;

  @NotBlank(message = "O campo senha não pode estar vazio.")
  private String senha;

  @Email(message = "O formato do email deve ser válido.")
  private String email;

  /**
   * Construtor padrão sem argumentos.
   */
  public Usuario() {
    // Construtor vazio
  }

  /**
   * Construtor com todos os argumentos.
   *
   * @param id    O ID do usuário.
   * @param user  O nome de usuário.
   * @param senha A senha do usuário.
   * @param email O email do usuário.
   */
  public Usuario(Long id, String user, String senha, String email) {
    this.id = id;
    this.user = user;
    this.senha = senha;
    this.email = email;
  }

  /**
   * Obtém o ID do usuário.
   *
   * @return O ID do usuário.
   */
  public Long getId() {
    return id;
  }

  /**
   * Define o ID do usuário.
   *
   * @param id O ID do usuário a ser definido.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Obtém o nome de usuário.
   *
   * @return O nome de usuário.
   */
  public String getUser() {
    return user;
  }

  /**
   * Define o nome de usuário.
   *
   * @param user O nome de usuário a ser definido.
   */
  public void setUser(String user) {
    this.user = user;
  }

  /**
   * Obtém a senha do usuário.
   *
   * @return A senha do usuário.
   */
  public String getSenha() {
    return senha;
  }

  /**
   * Define a senha do usuário.
   *
   * @param senha A senha do usuário a ser definida.
   */
  public void setSenha(String senha) {
    this.senha = senha;
  }

  /**
   * Obtém o email do usuário.
   *
   * @return O email do usuário.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Define o email do usuário.
   *
   * @param email O email do usuário a ser definido.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Retorna uma representação em string deste usuário.
   *
   * @return Uma string representando o usuário.
   */
  @Override
  public String toString() {
    return "Usuario{" +
            "id=" + id +
            ", user='" + user + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}

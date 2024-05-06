package com.oguilhermeviana.academy.exceptions;

/**
 * Exceção lançada quando ocorre tentativa de cadastrar um email que já está em uso.
 *
 * @author Guilherme Viana
 */
public class EmailExistException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Construtor que aceita uma mensagem de erro.
   *
   * @param msg A mensagem de erro associada à exceção.
   */
  public EmailExistException(String msg) {
    super(msg);
  }

}

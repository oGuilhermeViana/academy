package com.oguilhermeviana.academy.exceptions;

/**
 * Exceção lançada em caso de erro durante a criptografia.
 *
 * @author Guilherme Viana
 */
public class CriptoException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Construtor que aceita uma mensagem de erro.
   *
   * @param msg A mensagem de erro associada à exceção.
   */
  public CriptoException(String msg) {
    super(msg);
  }
}

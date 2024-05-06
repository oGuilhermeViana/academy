package com.oguilhermeviana.academy.exceptions;

/**
 * Exceção lançada para representar erros genéricos durante a execução de serviços.
 *
 * @author Guilherme Viana
 */
public class ServiceException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Construtor que aceita uma mensagem de erro.
   *
   * @param msg A mensagem de erro associada à exceção.
   */
  public ServiceException(String msg) {
    super(msg);
  }

}

package com.oguilhermeviana.academy.model.enums;

/**
 * Enumeração que representa os possíveis status de um curso na academia.
 *
 * @author Guilherme Viana
 */
public enum Status {
  ATIVO("Ativo"),
  INATIVO("Inativo"),
  TRANCADO("Trancado");

  private String status;

  /**
   * Construtor privado para inicializar cada valor da enumeração com um status.
   *
   * @param status O nome do status.
   */
  private Status(String status) {
    this.status = status;
  }

  /**
   * Obtém o nome do status.
   *
   * @return O nome do status.
   */
  public String getStatus() {
    return status;
  }
}

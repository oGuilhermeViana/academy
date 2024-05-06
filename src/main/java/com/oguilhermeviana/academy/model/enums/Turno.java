package com.oguilhermeviana.academy.model.enums;

/**
 * Enumeração que representa os turnos disponíveis para os cursos na academia.
 *
 * @author Guilherme Viana
 */
public enum Turno {
  MANHA("Manhã"),
  TARDE("Tarde"),
  NOITE("Noite");

  private String turno;

  /**
   * Construtor privado para inicializar cada valor da enumeração com um nome de turno.
   *
   * @param turno O nome do turno.
   */
  private Turno(String turno) {
    this.turno = turno;
  }

  /**
   * Obtém o nome do turno.
   *
   * @return O nome do turno.
   */
  public String getTurno() {
    return turno;
  }
}

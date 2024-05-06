package com.oguilhermeviana.academy.model.enums;

/**
 * Enumeração que representa os cursos disponíveis na academia.
 *
 * @author Guilherme Viana
 */
public enum Curso {
  CONTABILIDADE("Contabilidade"),
  INFORMATICA("Informática"),
  ADMINISTRACAO("Administração"),
  PROGRAMACAO("Programação"),
  ENFERMAGEM("Enfermagem");

  private String curso;

  /**
   * Construtor privado para inicializar cada valor da enumeração com um nome de curso.
   *
   * @param curso O nome do curso.
   */
  private Curso(String curso) {
    this.curso = curso;
  }

  /**
   * Obtém o nome do curso.
   *
   * @return O nome do curso.
   */
  public String getCurso() {
    return curso;
  }
}

package com.oguilhermeviana.academy.model.enums;

public enum Curso {
  CONTABILIDADE("Contabilidade"),
  INFORMATICA("Informática"),
  ADMINISTRACAO("Administração"),
  PROGRAMACAO("Programação"),
  ENFERMAGEM("Enfermagem");

  private String curso;

  private Curso(String curso) {
    this.curso = curso;
  }

  public String getCurso() {
    return curso;
  }

}

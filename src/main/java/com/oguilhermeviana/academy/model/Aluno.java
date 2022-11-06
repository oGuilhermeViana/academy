package com.oguilhermeviana.academy.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.oguilhermeviana.academy.model.enums.Curso;
import com.oguilhermeviana.academy.model.enums.Status;
import com.oguilhermeviana.academy.model.enums.Turno;

@Entity
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Size(min = 3, max = 45, message = "Mínimo de 3 caracteres")
  @NotBlank(message = "O campo nome não pode ser vazio.")
  private String nome;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "O campo curso não pode ser nulo.")
  private Curso curso;

  @NotBlank(message = "O campo matricula não pode ser vazio. CLique em Gerar para gerar uma matricula.")
  private String matricula;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "O campo status não pode ser nulo.")
  private Status status;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "O campo turno não pode ser nulo.")
  private Turno turno;

  public Aluno() {
  }

  public Aluno(Integer id, String nome, Curso curso, String matricula, Status status, Turno turno) {
    this.id = id;
    this.nome = nome;
    this.curso = curso;
    this.matricula = matricula;
    this.status = status;
    this.turno = turno;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

}

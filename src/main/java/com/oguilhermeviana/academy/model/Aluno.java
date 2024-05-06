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

/**
 * Classe que representa um aluno na academia.
 */
@Entity
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Size(min = 3, max = 45, message = "O nome deve ter entre 3 e 45 caracteres.")
  @NotBlank(message = "O campo nome não pode estar vazio.")
  private String nome;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "O campo curso não pode ser nulo.")
  private Curso curso;

  @NotBlank(message = "O campo matrícula não pode estar vazio. Clique em Gerar para gerar uma matrícula.")
  private String matricula;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "O campo status não pode ser nulo.")
  private Status status;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "O campo turno não pode ser nulo.")
  private Turno turno;

  /**
   * Construtor padrão sem argumentos.
   */
  public Aluno() {
    // Construtor vazio
  }

  /**
   * Construtor com todos os argumentos.
   *
   * @param id        O ID do aluno.
   * @param nome      O nome do aluno.
   * @param curso     O curso do aluno.
   * @param matricula A matrícula do aluno.
   * @param status    O status do aluno.
   * @param turno     O turno do aluno.
   */
  public Aluno(Integer id, String nome, Curso curso, String matricula, Status status, Turno turno) {
    this.id = id;
    this.nome = nome;
    this.curso = curso;
    this.matricula = matricula;
    this.status = status;
    this.turno = turno;
  }

  /**
   * Obtém o ID do aluno.
   *
   * @return O ID do aluno.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Define o ID do aluno.
   *
   * @param id O ID do aluno a ser definido.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Obtém o nome do aluno.
   *
   * @return O nome do aluno.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Define o nome do aluno.
   *
   * @param nome O nome do aluno a ser definido.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Obtém o curso do aluno.
   *
   * @return O curso do aluno.
   */
  public Curso getCurso() {
    return curso;
  }

  /**
   * Define o curso do aluno.
   *
   * @param curso O curso do aluno a ser definido.
   */
  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  /**
   * Obtém a matrícula do aluno.
   *
   * @return A matrícula do aluno.
   */
  public String getMatricula() {
    return matricula;
  }

  /**
   * Define a matrícula do aluno.
   *
   * @param matricula A matrícula do aluno a ser definida.
   */
  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  /**
   * Obtém o status do aluno.
   *
   * @return O status do aluno.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Define o status do aluno.
   *
   * @param status O status do aluno a ser definido.
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Obtém o turno do aluno.
   *
   * @return O turno do aluno.
   */
  public Turno getTurno() {
    return turno;
  }

  /**
   * Define o turno do aluno.
   *
   * @param turno O turno do aluno a ser definido.
   */
  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  /**
   * Retorna uma representação em string deste aluno.
   *
   * @return Uma string representando o aluno.
   */
  @Override
  public String toString() {
    return "Aluno{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", curso=" + curso +
            ", matricula='" + matricula + '\'' +
            ", status=" + status +
            ", turno=" + turno +
            '}';
  }
}

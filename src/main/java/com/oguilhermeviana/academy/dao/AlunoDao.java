package com.oguilhermeviana.academy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oguilhermeviana.academy.model.Aluno;

/**
 * Interface para acesso aos dados dos alunos na base de dados.
 *
 * @author Guilherme Viana
 */
public interface AlunoDao extends JpaRepository<Aluno, Integer> {

  /**
   * Busca todos os alunos com status "ATIVO".
   *
   * @return Lista de alunos ativos.
   */
  @Query("select x from Aluno x where x.status = 'ATIVO'")
  public List<Aluno> findByStatusAtivo();

  /**
   * Busca todos os alunos com status "INATIVO".
   *
   * @return Lista de alunos inativos.
   */
  @Query("select x from Aluno x where x.status = 'INATIVO'")
  public List<Aluno> findByStatusInativo();

  /**
   * Busca todos os alunos com status "TRANCADO".
   *
   * @return Lista de alunos trancados.
   */
  @Query("select x from Aluno x where x.status = 'TRANCADO'")
  public List<Aluno> findByStatusTrancado();

  /**
   * Busca todos os alunos cujo nome contenha a string especificada (ignorando maiúsculas/minúsculas).
   *
   * @param nome O nome a ser buscado.
   * @return Lista de alunos cujo nome contenha a string especificada.
   */
  public List<Aluno> findByNomeContainingIgnoreCase(String nome);

}

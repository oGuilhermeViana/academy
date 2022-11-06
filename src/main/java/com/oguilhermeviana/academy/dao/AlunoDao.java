package com.oguilhermeviana.academy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oguilhermeviana.academy.model.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer> {

  @Query("select x from Aluno x where x.status = 'ATIVO'")
  public List<Aluno> findByStatusAtivo();

  @Query("select x from Aluno x where x.status = 'INATIVO'")
  public List<Aluno> findByStatusInativo();

  @Query("select x from Aluno x where x.status = 'TRANCADO'")
  public List<Aluno> findByStatusTrancado();

}

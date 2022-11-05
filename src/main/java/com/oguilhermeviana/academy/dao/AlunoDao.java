package com.oguilhermeviana.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguilhermeviana.academy.model.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer> {

}

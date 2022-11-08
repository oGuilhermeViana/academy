package com.oguilhermeviana.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguilhermeviana.academy.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

}

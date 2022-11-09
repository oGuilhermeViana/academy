package com.oguilhermeviana.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oguilhermeviana.academy.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
  @Query("select x from Usuario x where x.email = :email")
  public Usuario findByEmail(String email);
}

package com.losBicos.ControlTechV1.repositories;

import com.losBicos.ControlTechV1.modelos.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNome(String nome);
    List<Usuario> findByLogin(String login);
}
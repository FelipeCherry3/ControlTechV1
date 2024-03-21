package com.losBicos.ControlTechV1.repositories;

import com.losBicos.ControlTechV1.modelos.Ativos;
import com.losBicos.ControlTechV1.modelos.LocalArmazenado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtivoRepository extends JpaRepository<Ativos, Long> {
    Optional<Ativos> findById(Long id);
    Ativos findByNome(String nome);
    List<Ativos> findByLocalArmazenado(LocalArmazenado localArmazenado);
}

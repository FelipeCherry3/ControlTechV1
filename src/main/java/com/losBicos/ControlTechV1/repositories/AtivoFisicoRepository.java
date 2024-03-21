package com.losBicos.ControlTechV1.repositories;

import com.losBicos.ControlTechV1.modelos.AtivoFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtivoFisicoRepository extends JpaRepository<AtivoFisico, Long> {

        }

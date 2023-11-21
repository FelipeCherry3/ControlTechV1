package com.losBicos.ControlTechV1.repositories;

import com.losBicos.ControlTechV1.modelos.LocalArmazenado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalRepository  extends JpaRepository<LocalArmazenado, Long> {
}

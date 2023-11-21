package com.losBicos.ControlTechV1.repositories;

import com.losBicos.ControlTechV1.modelos.SubLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubLocalRepository extends JpaRepository<SubLocal, Long> {
}

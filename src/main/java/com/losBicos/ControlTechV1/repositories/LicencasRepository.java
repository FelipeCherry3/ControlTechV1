package com.losBicos.ControlTechV1.repositories;

import com.losBicos.ControlTechV1.modelos.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicencasRepository extends JpaRepository<ProdutoCategoria, Long> {
}

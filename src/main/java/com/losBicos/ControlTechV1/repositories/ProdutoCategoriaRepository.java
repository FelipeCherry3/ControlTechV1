package com.losBicos.ControlTechV1.repositories;

import com.losBicos.ControlTechV1.modelos.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Long> {
}

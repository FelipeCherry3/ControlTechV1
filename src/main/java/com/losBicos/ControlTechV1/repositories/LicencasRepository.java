package com.losBicos.ControlTechV1.repositories;

import com.losBicos.ControlTechV1.modelos.Licencas;
import com.losBicos.ControlTechV1.modelos.ProdutoCategoria;
import com.losBicos.ControlTechV1.modelos.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicencasRepository extends JpaRepository<Licencas, Long> {
    Iterable<Licencas> findAllBySoftware(Software software);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.losBicos.ControlTechV1.repositories;

/**
 *
 * @author Pc Elaine
 */
import com.losBicos.ControlTechV1.modelos.Ativos;
import com.losBicos.ControlTechV1.modelos.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SoftwareRepository extends JpaRepository<Software, Long> {
    Optional<Software> findByProduto(Ativos produto);

    List<Software> findByProdutoIn(List<Ativos> produtos);

}

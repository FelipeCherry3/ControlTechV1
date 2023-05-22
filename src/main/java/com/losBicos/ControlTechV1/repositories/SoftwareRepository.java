/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.losBicos.ControlTechV1.repositories;

/**
 *
 * @author Pc Elaine
 */

import org.springframework.data.repository.CrudRepository;

import com.losBicos.ControlTechV1.modelos.Software;

public interface SoftwareRepository extends CrudRepository<Software, Integer> {
    
}

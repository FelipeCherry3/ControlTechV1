/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.losBicos.ControlTechV1.controladores;

import com.losBicos.ControlTechV1.modelos.Software;
import com.losBicos.ControlTechV1.repositories.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author Pc Elaine
 */

@Controller
@RequestMapping(path="/main") //Mapeamento da URL
public class ControladorMain {
    @Autowired
    private SoftwareRepository softwareRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Software> getAllSoftwares() {
        return softwareRepository.findAll();
    }
}

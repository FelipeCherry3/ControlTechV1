/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Pc Elaine
 */
@Entity
@Table(name = "software")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Software extends Ativos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_software;
    private String versao;
    private Date data_expira;
    private String tipo_licenca;
    private Long n_licenca;
    private String tipo_OS;


    private Usuario user;
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Getter
public class Software extends Ativos {

    private Date data_expira;
    private Integer pessoas_atribuidas;
    private String tipo_licenca;
    private Long n_licenca;
    private String tipo_OS;

    
    
}

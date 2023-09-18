package com.losBicos.ControlTechV1.modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.Set;

@Entity
@Table(name = "Usuarios")
@Getter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String username;
    private String password;

}

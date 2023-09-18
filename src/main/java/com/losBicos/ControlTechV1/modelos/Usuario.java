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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}

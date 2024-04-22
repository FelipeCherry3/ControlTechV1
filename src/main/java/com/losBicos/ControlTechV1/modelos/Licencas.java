package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
@Entity
@Table(name = "licencas")
@AllArgsConstructor
@NoArgsConstructor
public class Licencas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_licenca;

    private String chave;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "software_id")
    private Software software;

    @OneToOne
    @JoinColumn(name = "id_user")
    private Usuario usuario;
}

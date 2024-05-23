package com.losBicos.ControlTechV1.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "licencas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Licencas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_licenca;

    private String chave;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_software")
    private Software software;

    @OneToOne
    @JoinColumn(name = "id_user")
    private Usuario usuario;
}

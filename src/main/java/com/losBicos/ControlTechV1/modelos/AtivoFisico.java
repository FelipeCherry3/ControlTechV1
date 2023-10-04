package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ativoFisico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AtivoFisico extends Ativos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ativo;
    @OneToOne(mappedBy = "id_produto")
    private Ativos produto;
    @ManyToOne
    private Usuario user;
}

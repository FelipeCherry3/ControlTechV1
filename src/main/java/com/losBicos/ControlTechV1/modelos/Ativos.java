package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ativos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer qntEstoque;
    private Double valorItem;

    private Date data_aquisicao;

    private String statusAtivo;

    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idLocalArmazenado")
    private LocalArmazenado localArmazenado;

}

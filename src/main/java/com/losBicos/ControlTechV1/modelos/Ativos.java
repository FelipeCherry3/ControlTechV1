package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ativos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ativos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_ativos;
    private String nome_ativo;
    private Integer qtdEstoque;
    private Double valorItem;
    private Fornecedor fornecedor;
    private LocalArmazenado localArmazenado;
    private Categoria categoria;
    private Date data_aquisicao;
    private String status_ativo;
    private String descricao;
    private String historico;

}

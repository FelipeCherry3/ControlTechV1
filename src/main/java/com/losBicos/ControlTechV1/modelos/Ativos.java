package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "produto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ativos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Integer qtdEstoque;
    private Double valorItem;
    private Fornecedor fornecedor;
    private LocalArmazenado localArmazenado;
    private Categoria categoria;
    private Date data_aquisicao;
    private String statusAtivo;
    private String descricao;

}

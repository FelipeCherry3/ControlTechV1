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

    @Column(name = "nome")
    private String nome;

    @Column(name = "qtdEstoque")
    private Integer qtdEstoque;

    @Column(name = "valorItem")
    private Double valorItem;

    @ManyToMany
    @JoinTable(name = "produto_has_fornecedor",
                joinColumns = @JoinColumn(name = "id_produto"),
                inverseJoinColumns = @JoinColumn(name = "id_fornecedor"))
    private List<Fornecedor> fornecedor;

    @ManyToOne
    @JoinColumn(name = "idLocalArmazenado")
    private LocalArmazenado localArmazenado;

    @ManyToMany
    @JoinTable(name  = "produto_has_categoria",
                joinColumns = @JoinColumn(name = "id_produto"),
                inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> categoria;

    @Column(name = "dataAquisicao")
    private Date data_aquisicao;

    @Column(name = "statusAtivo")
    private String statusAtivo;

    @Column(name = "descricao")
    private String descricao;

}

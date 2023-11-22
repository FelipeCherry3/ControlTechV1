package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto_has_categoria")
@NoArgsConstructor
public class ProdutoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Ativos produto;


    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public ProdutoCategoria(Ativos produto, Categoria categoria) {
        this.produto = produto;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ativos getProduto() {
        return produto;
    }

    public void setProduto(Ativos produto) {
        this.produto = produto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

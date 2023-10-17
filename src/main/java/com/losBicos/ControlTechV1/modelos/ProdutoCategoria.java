package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "produto_has_categoria")
public class ProdutoCategoria {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Ativos produto;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}

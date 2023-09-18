package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "produto")
public class Ativos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduto;
    private String nomeProduto;
    private Integer qtdEstoque;
    private Double valorItem;
    private Fornecedor fornecedor;
    private LocalArmazenado localArmazenado;
    private Categoria categoria;
    private Date data_aquisicao;
    private String status_ativo;
    private String descricao;

    public Ativos() {
    }

    public Ativos(Integer idProduto, String nomeProduto, Integer qtdEstoque, Double valorItem, Fornecedor fornecedor, LocalArmazenado localArmazenado, Categoria categoria, Date data_aquisicao, String status_ativo, String descricao) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.qtdEstoque = qtdEstoque;
        this.valorItem = valorItem;
        this.fornecedor = fornecedor;
        this.localArmazenado = localArmazenado;
        this.categoria = categoria;
        this.data_aquisicao = data_aquisicao;
        this.status_ativo = status_ativo;
        this.descricao = descricao;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Double getValorItem() {
        return valorItem;
    }

    public void setValorItem(Double valorItem) {
        this.valorItem = valorItem;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalArmazenado getLocalArmazenado() {
        return localArmazenado;
    }

    public void setLocalArmazenado(LocalArmazenado localArmazenado) {
        this.localArmazenado = localArmazenado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public String getStatus_ativo() {
        return status_ativo;
    }

    public void setStatus_ativo(String status_ativo) {
        this.status_ativo = status_ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

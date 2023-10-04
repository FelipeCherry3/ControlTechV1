package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "localArmazenado")
public class LocalArmazenado {
    private Integer id;
    private String nomeLocal;
    private String endereco;
    private String descricao;
    private LocalArmazenado subLocal;

    @OneToMany(mappedBy = "localArmazenado")
    private List<Ativos> produtos;

    public LocalArmazenado() {
    }

    public LocalArmazenado(Integer id, String nomeLocal, String endereco, String descricao, LocalArmazenado subLocal) {
        this.id = id;
        this.nomeLocal = nomeLocal;
        this.endereco = endereco;
        this.descricao = descricao;
        this.subLocal = subLocal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalArmazenado getSubLocal() {
        return subLocal;
    }

    public void setSubLocal(LocalArmazenado subLocal) {
        this.subLocal = subLocal;
    }
}

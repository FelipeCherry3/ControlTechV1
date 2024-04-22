package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
public class Ativos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;
    private String nome;

    @Column(name = "qntEstoque")
    private Integer qntEstoque;
    @Column(name = "valorItem")
    private Double valorItem;

    @Column(name = "dataAquisicao")
    private Date data_aquisicao;

    @Column(name = "statusAtivo")
    private String statusAtivo;

    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idLocalArmazenado")
    private LocalArmazenado localArmazenado;

    public Integer getIdLocalArmazenado() {
        return idLocalArmazenadoId;
    }

    public void setIdLocalArmazenado(Integer idLocalArmazenado) {
        this.idLocalArmazenadoId = idLocalArmazenado;
    }

    private Integer idLocalArmazenadoId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQntEstoque(Integer qntEstoque) {
        this.qntEstoque = qntEstoque;
    }

    public void setValorItem(Double valorItem) {
        this.valorItem = valorItem;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public void setStatusAtivo(String statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLocalArmazenado(LocalArmazenado localArmazenado) {
        this.localArmazenado = localArmazenado;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQntEstoque() {
        return qntEstoque;
    }

    public Double getValorItem() {
        return valorItem;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public String getStatusAtivo() {
        return statusAtivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalArmazenado getLocalArmazenado() {
        return localArmazenado;
    }
}

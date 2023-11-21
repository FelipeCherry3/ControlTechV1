package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "localarmazenado")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class LocalArmazenado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomelocal;
    private String endereco;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "sublocal")
    private SubLocal subLocal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomelocal() {
        return nomelocal;
    }

    public void setNomelocal(String nomelocal) {
        this.nomelocal = nomelocal;
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

    public SubLocal getSubLocal() {
        return subLocal;
    }

    public void setSubLocal(SubLocal subLocal) {
        this.subLocal = subLocal;
    }
}

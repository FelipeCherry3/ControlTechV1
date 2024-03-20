package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.util.List;

@Entity
@Table(name = "localarmazenado")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class LocalArmazenado {

    public LocalArmazenado(String nomelocal, String endereco, String descricao){
        this.nomelocal = nomelocal;
        this.endereco = endereco;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomelocal;
    private String endereco;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "sublocal")
    private SubLocal subLocal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

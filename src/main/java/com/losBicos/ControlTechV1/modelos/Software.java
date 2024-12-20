/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc Elaine
 */
@Entity
@Table(name = "software")
@AllArgsConstructor
@NoArgsConstructor
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_software;
    private String versao;
    private LocalDate data_expira;
    private String n_licenca;
    private String tipo_OS;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Ativos produto;

    @OneToMany
    @Column(name = "id_licenca")
    private List<Licencas> licencas;

    public List<Licencas> getLicencas() {
        return licencas;
    }

    public void setLicencas(List<Licencas> licencas) {
        this.licencas = licencas;
    }

    public void setId_software(Long id_software) {
        this.id_software = id_software;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public void setData_expira(LocalDate data_expira) {
        this.data_expira = data_expira;
    }

    public void setN_licenca(String n_licenca) {
        this.n_licenca = n_licenca;
    }

    public void setTipo_OS(String tipo_OS) {
        this.tipo_OS = tipo_OS;
    }

    public void setProduto(Ativos produto) {
        this.produto = produto;
    }

    public Long getId_software() {
        return id_software;
    }

    public String getVersao() {
        return versao;
    }

    public LocalDate getData_expira() {
        return data_expira;
    }

    public String getN_licenca() {
        return n_licenca;
    }

    public String getTipo_OS() {
        return tipo_OS;
    }

    public Ativos getProduto() {
        return produto;
    }
}

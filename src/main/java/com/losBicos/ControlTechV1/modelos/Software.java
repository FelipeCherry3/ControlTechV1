/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Pc Elaine
 */
@Entity
public class Software {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Integer id_fornecedor;
    private Date data_aquisicao;
    private Date data_expira;
    private String status_software;
    private String descricao;
    private Integer pessoas_atribuidas;
    private String historico;
    private String tipo_licenca;
    private Long n_licenca;
    private String tipo_OS;
    
        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Integer id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public Date getData_expira() {
        return data_expira;
    }

    public void setData_expira(Date data_expira) {
        this.data_expira = data_expira;
    }

    public String getStatus_software() {
        return status_software;
    }

    public void setStatus_software(String status_software) {
        this.status_software = status_software;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPessoas_atribuidas() {
        return pessoas_atribuidas;
    }

    public void setPessoas_atribuidas(Integer pessoas_atribuidas) {
        this.pessoas_atribuidas = pessoas_atribuidas;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getTipo_licenca() {
        return tipo_licenca;
    }

    public void setTipo_licenca(String tipo_licenca) {
        this.tipo_licenca = tipo_licenca;
    }

    public Long getN_licenca() {
        return n_licenca;
    }

    public void setN_licenca(Long n_licenca) {
        this.n_licenca = n_licenca;
    }

    public String getTipo_OS() {
        return tipo_OS;
    }

    public void setTipo_OS(String tipo_OS) {
        this.tipo_OS = tipo_OS;
    }
    
    
}

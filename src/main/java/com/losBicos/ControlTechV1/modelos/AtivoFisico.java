package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ativoFisico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AtivoFisico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ativo;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Ativos produto;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario user;

    public void setProduto(Ativos ativoCad) {
        this.produto = ativoCad;
    }
    public void setUser(Usuario user){
        this.user = user;
    }
}

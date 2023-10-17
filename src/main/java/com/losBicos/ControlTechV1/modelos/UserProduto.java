package com.losBicos.ControlTechV1.modelos;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "users_has_produto")
@Getter
public class UserProduto {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_users")
    private Usuario user;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Ativos produto;
}

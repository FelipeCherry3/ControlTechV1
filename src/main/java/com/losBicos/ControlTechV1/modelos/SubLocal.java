package com.losBicos.ControlTechV1.modelos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sublocal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeLocal;
    private String endereco;
    private String descricao;
}
